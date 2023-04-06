import java.util.ArrayList;
import java.util.Scanner;

public class UserInteraction {

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
    public void actionBar(boolean inCombat){
        if(inCombat){
            combatActionBar();
        } else {
            passiveActionBar();
        }
    }
    private void passiveActionBar(){
        System.out.println("\nWhat would you like to? [Move Forward] [View Inventory] [See Stats] [Rest]");
        switch (UserInteraction.getUserText()){
            case "move forward":
                ProgressionManager.moveForward();
                //wip
                //passiveActionBar();
                break;
            case "view inventory":
                Main.character.viewInventory();
                //wip
                passiveActionBar();
                break;
            case "see stats":
                Main.character.printEffectiveStats();
                passiveActionBar();
                break;
            case "rest":
                Main.character.rest();
                passiveActionBar();
                break;
                //character
        }
    }
    private void combatActionBar(){
        System.out.println("\nWhat would you like to? [Attack] [Heal] [Run Away]");
        switch (UserInteraction.getUserText()){
            case "attack":
                //character attack
                break;
            case "heal":
                Main.character.combatRest();
                break;
            case "run away":
                //develop some sort of mechanic for this
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
        System.out.println("Confirm Selection? [Yes] [No]");
        String answer = scanner.next();
        if(answer.equalsIgnoreCase("yes")){
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
        Main.character.printBaseStats();
    }
    private void printCharacterPreview(String charName){
        ArrayList<String> temp = FileReader.getStringData("src/art/character/" + charName + ".txt");
        for(String string : temp){
            System.out.println(string);
        }
    }

}
