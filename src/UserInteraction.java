import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class UserInteraction {
    static int runCounter = 0;
    static boolean enemyDefeated = false;
    static Scanner scanner = new Scanner(System.in);
   // static ArrayList<String> inputs = new ArrayList<>();
    public void welcome(){
        System.out.println("Welcome to The Eternal Archipelago");
        System.out.println("what will be your story?");
        characterSelect();
        ProgressionManager progressionManager = new ProgressionManager();
        progressionManager.startGame();
    }
    private void characterSelect(){
        System.out.println("Select your character");
        System.out.println("Elf [0], Human [1], Dwarf [2], Dragonborn [3], Gnome [4]");
        String choice = UserInteraction.getUserText("0,1,2,3,4");
        printRaceStats(choice);
    }
    public static String getUserText(String possibleInputs){
        String userInput = "";
        if(possibleInputs.equals("no letters")){
            boolean isInValid = false;
            while(!isInValid){
                userInput = scanner.nextLine();
                for(int i = 0; i < userInput.length(); i++){
                    if(Character.isDigit(userInput.charAt(i)) || userInput.charAt(i) == ','){
                        isInValid = true;
                    } else {
                        isInValid = false;
                        break;
                    }
                }
                if(!isInValid){
                    System.out.println("Please enter a valid input");
                }
            }

        } else {
            ArrayList<String> validInputs = new ArrayList<>();
            StringBuilder temp = new StringBuilder();
            for(int i = 0; i < possibleInputs.length(); i++) {
                if (possibleInputs.charAt(i) != ',') {
                    temp.append(possibleInputs.charAt(i));
                } else {
                    validInputs.add(temp.toString());
                    temp = new StringBuilder();
                }
            }
            validInputs.add(temp.toString());

            boolean validInput = false;
            while(!validInput) {
                userInput =  scanner.nextLine().toLowerCase();
                for(String input : validInputs){
                    if (input.equals(userInput)) {
                        validInput = true;
                        break;
                    }
                }
                if(!validInput){
                    System.out.println("Please enter a valid input");
                }
            }
        }
        return userInput;
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
            tradeActionBar(enemy);
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
                temp = UserInteraction.getUserText("yes,0,no,1").toLowerCase();
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
                switch (UserInteraction.getUserText("yes,0,no,1").toLowerCase()){
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
        switch (UserInteraction.getUserText("move forward,0,view inventory,1,see stats,2,rest,3")){
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
                switch (UserInteraction.getUserText("attack,0,heal,1,run away,2")){
                    case "0":
                    case "attack":
                        //character attack
                        if(Main.character.getWeapon().isMagic){
                            if(magicCasting()){
                                System.out.println("Cast successful!\n");
                                attackEnemy(enemy);
                            } else {
                                System.out.println("Cast failed\n");
                            }
                        } else {
                            attackEnemy(enemy);
                        }
                        if(enemy.health > 0){
                            attackCharacter(enemy);
                        }
                        ProgressionManager.turnManager(enemy);
                        break;
                    case "1":
                    case "heal":
                        Main.character.combatRest();
                        ProgressionManager.turnManager(enemy);
                        break;
                    case "2":
                    case "run away":
                        if(runCounter % 2 == 0){
                            runCounter++;
                            Main.character.runAway(enemy);
                        } else {
                            runCounter+= NumberProcessor.getRandom(0,2);
                            System.out.println("You cannot run away again right now");
                            attackCharacter(enemy);
                            combatActionBar(enemy,character);
                        }
                        break;
                }
            }
        }
    }
    public static void attackCharacter(NPC npc){
        double randomNum = NumberProcessor.getRandom(0,101);
        randomNum = randomNum*(1+ (Main.character.getEffectiveDex()/200));
        if(randomNum <= 60){
            double damage = npc.attack / (Main.character.getEffectiveDefense()/100);
            Main.character.subtractHealth(damage);
            System.out.println("You have taken " + damage + " damage");
            System.out.println("You have " + Main.character.getEffectiveHealth() + " health");
        } else {
            System.out.println("You have dodged the attack");
        }
    }
    public static void attackEnemy(NPC npc){
        double randomNum = NumberProcessor.getRandom(0,101);
        randomNum = randomNum*(1+ (npc.dexterity/200));
        if(randomNum <= 60){
            double damage = Main.character.getEffectiveAttack() / (npc.defense/100);
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
            runCounter = 0;
        }
    }
    private static void tradeActionBar(NPC merchant){
        System.out.println("You approach a person wearing long, fancy robes standing alongside a caravan of what appears to be weapons, armor, and artifacts");
        Main.character.viewInventory();
        System.out.println("\nWhat would you like to?   [Trade][0]   [Leave][1]");
        switch (UserInteraction.getUserText("trade,0,leave,1")){
            case "0":
            case "trade":
                //character trade
                System.out.println("The person looks up as you approach them. They introduce themselves as a merchant");
                System.out.println("Feel free to browse my wares");
                System.out.println("--- Merchant's Wares ---");
                merchant.viewTradeItem();
                System.out.println("Would you like to trade your item for the merchant's item?   [Yes][0]   [No][1]");
                String userInput = UserInteraction.getUserText("yes,0,no,1").toLowerCase();
                switch (userInput){
                    case "yes":
                    case "0":
                        if(merchant.tradeItem instanceof Weapon){
                            int cost = Main.character.inventory.get(0).value - merchant.tradeItem.value;
                            if(cost < 0){
                                int temp = Main.character.coins + cost;
                                if(temp < 0){
                                    System.out.println("You cannot afford this item");
                                    System.out.println("\nYou leave the merchant. They are slightly upset that you tried to buy an item you can't afford");
                                } else {
                                    System.out.println("You have purchased this item for " +  Math.abs(cost) + " coins");
                                    Main.character.coins += cost;
                                    Main.character.inventory.set(0, merchant.tradeItem);
                                    merchant.tradeItem = null;
                                }
                            } else {
                                System.out.println("You have purchased this item and have been refunded " + cost + " coins");
                                Main.character.coins += cost;
                                Main.character.inventory.set(0, merchant.tradeItem);
                            }
                        } else if (merchant.tradeItem instanceof Armor){
                            int cost = Main.character.inventory.get(1).value - merchant.tradeItem.value;
                            if(cost < 0){
                                int temp = Main.character.coins + cost;
                                if(temp < 0){
                                    System.out.println("You cannot afford this item");
                                    System.out.println("\nYou leave the merchant. They are slightly upset that you tried to buy an item you can't afford");
                                } else {
                                    System.out.println("You have purchased this item for " + Math.abs(cost) + " coins");
                                    Main.character.coins += cost;
                                    Main.character.inventory.set(1, merchant.tradeItem);
                                }
                            } else {
                                System.out.println("You have purchased this item and have been refunded " + cost + " coins");
                                Main.character.coins += cost;
                                Main.character.inventory.set(1, merchant.tradeItem);
                                merchant.tradeItem = null;
                            }
                        }
                        ProgressionManager.isTrading = false;
                        ProgressionManager.turnManager();
                        break;
                    case "no":
                    case "1":
                        System.out.println("You leave the merchant");
                        ProgressionManager.isTrading = false;
                        ProgressionManager.turnManager();
                        break;
                }
                break;
            case "1":
            case "leave":
                ProgressionManager.isTrading = false;
                ProgressionManager.turnManager();
                break;
        }
    }
    private void printRaceStats(String choice){
        switch (choice){
            case "0" :
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
            case "1" :
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
            case "2" :
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
            case "3" :
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
            case "4" :
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
        System.out.println("Confirm Selection? [Yes][0]   [No][1]");
        String answer = getUserText("yes,0,no,1");
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
        System.out.println("You can upgrade your base stats " + Main.character.coins/1000 +" times");
        while (checkCoins()){
            userUpgradeStat();
        }
        System.out.println("You cannot upgrade your character anymore");
        ProgressionManager.sleep(2000);
        restart();
    }

    private static void restart(){
        System.out.println("\nYour new base stats are: ");
        Main.character.printBaseStats();
        ProgressionManager progressionManager = new ProgressionManager();
        ProgressionManager.returnPoint = 2;
        ProgressionManager.inCombat = false;
        StoryManager.usedStories = new ArrayList<>();
        System.out.println("\nYou will now rise again");
        ProgressionManager.sleep(2000);
        Main.character.respawn();
        progressionManager.startGame();
    }
    private static void userUpgradeStat(){
        int upgradeTimes = Main.character.coins/1000;
        int statUpgradeCount;
        System.out.println("Which stat would you like to upgrade?");
        System.out.println("Health is [0], Attack is [1], Defense is [2], Dexterity is [3], Intelligence is [4], and Mana is [5]     Finish is [6]");
        Scanner scanner  = new Scanner(System.in);
        String userInput = getUserText("0,1,2,3,4,5,6");
        if(userInput.equals("0") ||userInput.equals("1") || userInput.equals("2")|| userInput.equals("3")|| userInput.equals("4") || userInput.equals("5")){
            System.out.println("How many times would you like to upgrade this stat?");
            statUpgradeCount = scanner.nextInt();
            if(statUpgradeCount > upgradeTimes){
                System.out.println("You do not have the coins to complete this action");
            } else if(statUpgradeCount >= 0) {
                Main.character.coins -= (statUpgradeCount * 1000);
                switch (userInput){
                    case "0":
                        Main.character.baseHealth += (5 * statUpgradeCount);
                        break;
                    case "1":
                        Main.character.baseAttack += (5 * statUpgradeCount);
                        break;
                    case "2":
                        Main.character.baseDefense += (5 * statUpgradeCount);
                        break;
                    case "3":
                        Main.character.baseDexterity += (2 * statUpgradeCount);
                        break;
                    case "4":
                        Main.character.baseIntelligence += (5 * statUpgradeCount);
                        break;
                    case "5":
                        Main.character.baseMana += (2 * statUpgradeCount);
                        break;
                }
                System.out.println("You have " + Main.character.coins + " coins left");
            } else {
                System.out.println("Invalid input");
            }
        } else if(userInput.equals("6")){
            restart();
        } else {
            System.out.println("Invalid Input");
        }
    }
    private static boolean checkCoins(){
        return Main.character.coins / 1000 > 0;
    }

    public static boolean magicCasting(){
        System.out.println("You are using a magic weapon. Prepare for casting");
        int[] nums = new int[4];
        for(int i = 0; i < nums.length; i++){
            nums[i] = NumberProcessor.getRandom(0,100);
        }
        System.out.println(Arrays.toString(nums));
        int binaryValue = NumberProcessor.getRandom(0,2);
        switch (binaryValue){
            case 0:
                System.out.println("Sort these numbers from least to greatest. Separate each number with a comma");
                int[] sorted = NumberProcessor.bubbleSort(nums);
                return parseUserStringAndCompare(getUserText("no letters"), sorted);
            case 1:
                System.out.println("Sort these numbers from greatest to least. Separate each number with a comma");
                int[] sorted2 = NumberProcessor.insertionSort(nums);
                return parseUserStringAndCompare(getUserText("no letters"), sorted2);
        }
        return false;
    }

    public static boolean parseUserStringAndCompare(String userInput, int[] computerSolve){
        String workingInput = userInput.replaceAll("\\s", "");
        ArrayList<Integer> userResult = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < workingInput.length(); i++){
            if(workingInput.charAt(i) != ','){
                temp.append(workingInput.charAt(i));
            } else {
                userResult.add(Integer.parseInt(temp.toString()));
                temp = new StringBuilder();
            }
        }
        userResult.add(Integer.parseInt(temp.toString()));
        boolean correct = true;
        for(int i = 0; i < computerSolve.length; i ++){
            if(computerSolve[i] != userResult.get(i)){
                correct = false;
                break;
            }
        }
        return correct;
    }
}
