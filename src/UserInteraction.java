import java.util.ArrayList;
import java.util.Scanner;

public class UserInteraction {
    static boolean enemyDefeated = false;

    public UserInteraction(){
        //welcome();
    }
    public void welcome(){
        System.out.println("Welcome to The Eternal Archipelago");
        System.out.println("what will be your story?");
        characterSelect();
        ProgressionManager progressionManager = new ProgressionManager();
        progressionManager.startGame();
    }
    private void characterSelect(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your character");
        System.out.println("Elf [0], Human [1], Dwarf [2], Dragonborn [3], Gnome [4]");
        int choice = scanner.nextInt();
        printRaceStats(choice);
    }
    public static String getUserText(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().toLowerCase();
    }
    public static void actionBar(){
        passiveActionBar();
    }
    public static void actionBar(boolean isLooting){
        if(isLooting){
            lootingActionBar((Weapon) Main.character.inventory.get(0), (Armor) Main.character.inventory.get(1));
        }
    }
    public static void actionBar(boolean inCombat, boolean trading, boolean looting, NPC enemy, PCharacter character){
        if(inCombat){
            combatActionBar(enemy,character);
        } else if(!trading){
            passiveActionBar();
        } else {
            tradeActionBar();
        }
    }
    private static void lootingActionBar(Weapon weapon, Armor armor){
        int rand = NumberProcessor.getRandom(0,2);
        String temp;
        switch (rand){
            case 0:
                System.out.println("\nCurrent Weapon:");
                weapon.printWeaponStats();
                System.out.println("\nLooted Weapon:");
                Weapon tempWeapon = new Weapon(Main.character);
                tempWeapon.printWeaponStats();
                System.out.println("Would you like to replace your weapon?   [Yes][0]   [No][1]");
                temp = UserInteraction.getUserText().toLowerCase();
                switch (temp){
                    case "0":
                    case "yes":
                        Main.character.inventory.set(0,tempWeapon);
                        System.out.println("Equipped looted weapon");
                        break;
                    case "1":
                    case "no":
                        System.out.println("Leaving looted weapon");
                        break;
                }
                break;
            case 1:
                System.out.println("\nCurrent Armor:");
                armor.printArmorStats();
                System.out.println("\nLooted Armor:");
                Armor tempArmor = new Armor(Main.character);
                tempArmor.printArmorStats();
                System.out.println("Would you like to replace your armor?   [Yes][0]   [No][1]");
                temp = UserInteraction.getUserText().toLowerCase();
                switch (temp){
                    case "0":
                    case "yes":
                        Main.character.inventory.set(1,tempArmor);
                        System.out.println("Equipped looted armor");
                        break;
                    case "1":
                    case "no":
                        System.out.println("Leaving looted armor");
                        break;
                }
                break;
        }
        ProgressionManager.turnManager();

    }
    private static void passiveActionBar(){
        System.out.println("\nWhat would you like to?   [Move Forward][0]   [View Inventory][1]   [See Stats][2]   [Rest][3]");
        switch (UserInteraction.getUserText()){
            case "0":
            case "move forward":
                ProgressionManager.moveForward();
                //wip
                //passiveActionBar();
                break;
            case "1":
            case "view inventory":
                Main.character.viewInventory();
                //wip
                passiveActionBar();
                break;
            case "2":
            case "see stats":
                Main.character.printEffectiveStats();
                passiveActionBar();
                break;
            case "3":
            case "rest":
                Main.character.rest();
                passiveActionBar();
                break;
                //character
        }
    }
    private static void combatActionBar(NPC enemy, PCharacter character){
        enemyDefeated = false;
        //System.out.println("\nPrepare for combat");
        ProgressionManager.sleep(1000);
        if(character.isDead()){
            ProgressionManager.inCombat = false;
            ProgressionManager.turnManager(enemy);
        } else {
            if(enemy.dexterity > character.getEffectiveDex()){
                ProgressionManager.sleep(200);
                System.out.println("\nEnemy attacks first");
                attackCharacter(enemy);
            }
            if(character.isDead()){
                ProgressionManager.inCombat = false;
                ProgressionManager.turnManager(enemy);
            } else {
                System.out.println("\nWhat would you like to?   [Attack][0]   [Heal][1]   [Run Away][2]");
                switch (UserInteraction.getUserText()){
                    case "0":
                    case "attack":
                        //character attack
                        attackEnemy(enemy);
                        if(enemy.health > 0){
                            attackCharacter(enemy);
                        }
                        ProgressionManager.turnManager(enemy);
                        //actionBar(ProgressionManager.inCombat,ProgressionManager.isTrading,enemy,character);
                        break;
                    case "1":
                    case "heal":
                        Main.character.combatRest();
                        ProgressionManager.turnManager(enemy);
                        break;
                    case "2":
                    case "run away":
                        Main.character.runAway(enemy);
                        //develop some sort of mechanic for this
                        break;
                }
            }
        }
    }
    private static void attackCharacter(NPC npc){
        double randomNum = NumberProcessor.getRandom(0,101);
        randomNum = randomNum*(1+ (Main.character.getEffectiveDex()/200));
        if(randomNum <= 60){
            double damage = npc.attack / (Main.character.getEffectiveDefense()/100);
            Main.character.subtractHealth(damage);
            System.out.println("You have taken " + damage + " damage");
            System.out.println("You have " + Main.character.getEffectiveHealth() + " health");
//            if(Main.character.isDead()){
//                ProgressionManager.inCombat = false;
//              //  enemyDefeated = true;
//                ProgressionManager.turnManager(npc);
//            }
        } else {
            System.out.println("You have dodged the attack");
        }
    }
    private static void attackEnemy(NPC npc){
        double randomNum = NumberProcessor.getRandom(0,101);
        randomNum = randomNum*(1+ (npc.dexterity/200));
        if(randomNum <= 60){
            double damage = npc.attack / (npc.defense/100);
            npc.subtractHealth(damage);
            System.out.println("Enemy has taken " + damage + " damage");
            System.out.println("It has " + npc.health + " health left");
        } else {
            System.out.println("Enemy has dodged the attack");
        }

        if(npc.health <= 0){
            System.out.println("You have vanquished your enemy");
            Main.character.coins += npc.value;
            enemyDefeated = true;
           // ProgressionManager.inCombat = false;
        }
    }
    private static void tradeActionBar(){
        System.out.println("\nWhat would you like to?   [Trade][0]   [Leave][1]");
        switch (UserInteraction.getUserText()){
            case "0":
            case "trade":
                //character trade
                break;
            case "1":
            case "leave":
                //move forward
                break;
        }
    }
    private void printRaceStats(int choice){
        switch (choice){
            case 0 :
                System.out.println("Race: Elf");
                System.out.println("Base Health: 70");
                System.out.println("Base Attack: 40");
                System.out.println("Base Defense: 30");
                System.out.println("Base Dexterity 60");
                System.out.println("Base Intelligence: 75");
                System.out.println("Base Mana: 55");
                System.out.println("Base Luck: 45");
                printCharacterPreview("elf");
                confirmCharacter("elf");
                break;
            case 1 :
                System.out.println("Race: Human");
                System.out.println("Base Health: 80");
                System.out.println("Base Attack: 50");
                System.out.println("Base Defense: 50");
                System.out.println("Base Dexterity: 50");
                System.out.println("Base Intelligence: 70");
                System.out.println("Base Mana: 35");
                System.out.println("Base Luck: 40");
                printCharacterPreview("human");
                confirmCharacter("human");
                break;
            case 2 :
                System.out.println("Race: Dwarf");
                System.out.println("Base Health: 90");
                System.out.println("Base Attack: 55");
                System.out.println("Base Defense: 65");
                System.out.println("Base Dexterity: 35");
                System.out.println("Base Intelligence: 60");
                System.out.println("Base Mana: 15");
                System.out.println("Base Luck: 55");
                printCharacterPreview("dwarf");
                confirmCharacter("dwarf");
                break;
            case 3 :
                System.out.println("Race: Dragonborn");
                System.out.println("Base Health: 110");
                System.out.println("Base Attack: 70");
                System.out.println("Base Defense 80");
                System.out.println("Base Dexterity: 20");
                System.out.println("Base Intelligence: 40");
                System.out.println("Base Mana: 30");
                System.out.println("Base Luck: 25");
                printCharacterPreview("dragonborn");
                confirmCharacter("dragonborn");
                break;
            case 4 :
                System.out.println("Race: Gnome");
                System.out.println("Base Health: 50");
                System.out.println("Base Attack: 30");
                System.out.println("Base Defense 70");
                System.out.println("Base Dexterity: 20");
                System.out.println("Base Intelligence: 85");
                System.out.println("Base Mana: 30");
                System.out.println("Base Luck: 90");
                printCharacterPreview("gnome");
                confirmCharacter("gnome");
                break;
        }
    }

    private void confirmCharacter(String race){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Confirm Selection? [Yes][0]   [No][1]");
        String answer = scanner.next();
        if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("0")){
            switch (race){
                case "elf" :
                    Main.character.setStats(70,40,30,60,75,55,45);
                    break;
                case "human" :
                    Main.character.setStats(80,50,50,50,70,35,40);
                    break;
                case "dwarf" :
                    Main.character.setStats(90,55,65,35,60,15,55);
                    break;
                case "dragonborn" :
                    Main.character.setStats(110,70,80,20,40,30,25);
                    break;
                case "gnome" :
                    Main.character.setStats(50,30,70,20,85,30,90);
                    break;
            }
        } else{
            characterSelect();
        }
    }
    private void printCharacterPreview(String charName){
        ArrayList<String> temp = FileReader.getStringData("src/art/character/" + charName + ".txt");
        for(String string : temp){
            System.out.println(string);
        }
    }

    public static void deathUpgrades(){
        ProgressionManager.sleep(1000);
        System.out.println("\nYou have obtained " + Main.character.coins + " coins in your adventure");
        ProgressionManager.sleep(1000);
        System.out.println("You can now use these coins to upgrade your base stats. Any coins not spent will be lost");
        ProgressionManager.sleep(1000);
        System.out.println("It costs 1000 coins per upgrade");
        int upgradeTimes = Main.character.coins/1000;
        System.out.println("You can upgrade your base stats " + upgradeTimes +" times");
        if(upgradeTimes == 0){
            System.out.println("Since you cannot upgrade your character, you will now rise again");
            ProgressionManager.sleep(2000);
            System.out.println();
            ProgressionManager progressionManager = new ProgressionManager();
            ProgressionManager.returnPoint = 2;
            Main.character.respawn();
            progressionManager.startGame();
        } else {
            String userInput = "";
            int statUpgradeCount = 0;
            while(!userInput.equals("6")){
                System.out.println("Which stat would you like to upgrade?");
                System.out.println("Health is [0], Attack is [1], Defense is [2], Dexterity is [3], Intelligence is [4], and Mana is [5]     Finish is [6]");
                Scanner scanner  = new Scanner(System.in);
                userInput = scanner.nextLine();
                if(userInput.equals("0") ||userInput.equals("1") || userInput.equals("2")|| userInput.equals("3")|| userInput.equals("4") || userInput.equals("5")){
                    boolean enterUpgradeCount = false;
                    while(!enterUpgradeCount){
                        System.out.println("How many times would you like to upgrade this stat?");
                        statUpgradeCount = scanner.nextInt();
                        if(statUpgradeCount > upgradeTimes){
                            System.out.println("Invalid Input");
                        } else {
                            upgradeTimes -= statUpgradeCount;
                            enterUpgradeCount = true;
                            switch (userInput){
                                case "0":
                                    Main.character.baseHealth += (2 * statUpgradeCount);
                                    break;
                                case "1":
                                    Main.character.baseAttack += (2 * statUpgradeCount);
                                    break;
                                case "2":
                                    Main.character.baseDefense += (2 * statUpgradeCount);
                                    break;
                                case "3":
                                    Main.character.baseDexterity += (statUpgradeCount);
                                    break;
                                case "4":
                                    Main.character.baseIntelligence += (2 * statUpgradeCount);
                                    break;
                                case "5":
                                    Main.character.baseMana += (statUpgradeCount);
                                    break;
                            }
                        }
                    }
                } else if(userInput.equals("6")){
                    ProgressionManager progressionManager = new ProgressionManager();
                    ProgressionManager.returnPoint = 2;
                    System.out.println("\nYou will now rise again");
                    ProgressionManager.sleep(2000);
                    Main.character.respawn();
                    progressionManager.startGame();
                } else {
                    System.out.println("Invalid Input");
                }
            }

            System.out.println("Your new stats are: ");
            Main.character.printEffectiveStats();
        }
    }
}
