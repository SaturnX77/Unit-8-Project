import java.util.ArrayList;

public class StoryManager {

    static int case1Visited = 0;
    static int case2Visited = 0;
    static int case3Visited = 0;
    static int case4Visited = 0;

    //---------------------------------------------------Village Story Top-------------------------------------------------------------
    static int case0Visited = 0;
    static int case0Position = 0;
    //--------------------------------------------------Village Story Bottom-----------------------------------------------------------


    static ArrayList<Integer> usedStories = new ArrayList<>();
    public static void newStory(){
        if(usedStories.size() == 1){
            System.out.println("No more stories available");
            ProgressionManager.moveForward();
        }
      //  System.out.println("newstory called");
        //System.out.println(usedStories);
        int rand = NumberProcessor.getRandom(0,1);
        //System.out.println("new story rand: " + rand);
        boolean usedStory = false;
        for (Integer storyIndex : usedStories) {
            if (rand == storyIndex) {
                usedStory = true;
                break;
            }
        }
        if(!usedStory){
            usedStories.add(rand);
            storyManager(rand);
        } else {
            newStory();
        }
    }

    private static void storyManager(int storyIndex){
//        System.out.println("This is the test of the story exit system");
//        exitStory();
        switch(storyIndex){
            case 0:
                villageArtifactStart();
                exitStory();
                break;
            case 1:
                case1Visited++;
                System.out.println("case 1");
                exitStory();
                break;
            case 2:
                case2Visited++;
                System.out.println("case 2");
                exitStory();
                break;
            case 3:
                case3Visited++;
                System.out.println("case 3");
                exitStory();
                break;
            case 4:
                case4Visited++;
                System.out.println("case 4");
                exitStory();
                break;
            default:
                exitStory();
        }
    }


    //---------------------------------------------------Village Story Top-------------------------------------------------------------
    private static void villageArtifactStart(){
        if(case0Visited == 0){
            case0Visited++;
            System.out.println("You find yourself in a small village surrounded by rolling hills and towering trees");
            ProgressionManager.sleep(1000);
            System.out.println("As you walk down the dirt road you notice that you are beginning to attract some attention");
            ProgressionManager.sleep(1000);
            System.out.println("The people here are not used to seeing heavy armor and weapons");
            ProgressionManager.sleep(1000);
            System.out.println("You approach what looks to be a town hall");
            ProgressionManager.sleep(1000);
            System.out.println("As you walk inside the person who appear to be the leader says 'so you are the chosen one'");
            ProgressionManager.sleep(1000);
            System.out.println("\nYou have no idea what the leader is talking about so you ask 'what chosen one?'\n");
            ProgressionManager.sleep(1000);
            System.out.println("They walk up to you and tell you the tale of a long lost artifact that gave it's welder the ability to bend reality to their will");
            ProgressionManager.sleep(1000);
            System.out.println("\nYour interest is piqued so you ask the leader where the artifact could be\n");
            ProgressionManager.sleep(1000);
            System.out.println("They lead you outside and point into the distance at a range of towering mountains and give you a smile");
            ProgressionManager.sleep(1000);
            villageArtifactMountain();
        } else if (case0Visited >= 1) {
            case0Visited++;
            if(case0Position== 1 || case0Position == 4 || case0Position == 2){
                System.out.println("You find yourself in a small village surrounded by rolling hills and towering trees");
                ProgressionManager.sleep(1000);
                System.out.println("As you walk down the dirt road you notice that you are beginning to attract some attention");
                ProgressionManager.sleep(1000);
                System.out.println("The people appear to be excited for some reason. You hear whispers of 'the warrior is back'");
                ProgressionManager.sleep(1000);
                System.out.println("You approach what looks to be a town hall");
                ProgressionManager.sleep(1000);
                System.out.println("The person who appears to be the leader approaches you and says 'welcome back warrior' it has been a while!");
                ProgressionManager.sleep(1000);
                System.out.println("\nYou have no idea what the leader is talking about so you ask 'I've been here before?'\n");
                ProgressionManager.sleep(1000);
                System.out.println("They look at you strangely. 'I offered you a quest to find an ancient artifact and you never returned. Do you not remember?' ");
                ProgressionManager.sleep(1000);
                System.out.println("\nYou shake your head. You still don't know what's going on\n");
                ProgressionManager.sleep(1000);
                System.out.println("\n You hear the leader mutter something under their breath 'interesting, most interesting'\n");
                ProgressionManager.sleep(1000);
                System.out.println("They lead you outside and point into the distance at a range of towering mountains and give you a smile. Do you accept my warrior?");
                ProgressionManager.sleep(1000);
                if(case0Position == 4){
                    System.out.println("Memories suddenly flood back into your head. For some reason it seems like they are yours");
                    ProgressionManager.sleep(1000);
                    System.out.println("You remember the blood red orb and your broken promise");
                    ProgressionManager.sleep(1000);
                    System.out.println("You know you can't go back up there");
                    ProgressionManager.sleep(1000);
                    System.out.println("You apologize to the village leader and say you can't go up there. Your almost panicked face makes the leader curious");
                    ProgressionManager.sleep(1000);
                    System.out.println("You beeline out of the village");
                } else if(case0Position == 2){
                    System.out.println("Memories suddenly flood back into your head. For some reason it seems like they are yours");
                    ProgressionManager.sleep(1000);
                    System.out.println("You remember the mountain and the arduous climb");
                    ProgressionManager.sleep(1000);
                    System.out.println("You remember how you failed before");
                    ProgressionManager.sleep(1000);
                    System.out.println("Is trying again worth it?");
                    villageArtifactMountain();
                } else if (case0Position == 1) {
                    System.out.println("Apparently you had denied this quest before");
                    ProgressionManager.sleep(1000);
                    System.out.println("Is it work accepting this time?");
                    ProgressionManager.sleep(1000);
                    villageArtifactMountain();
                }
            } else if(case0Position == 9){
                System.out.println("You find yourself in a small village surrounded by rolling hills and towering trees");
                ProgressionManager.sleep(1000);
                System.out.println("As you walk down the dirt road you notice that you are beginning to attract some attention");
                ProgressionManager.sleep(1000);
                System.out.println("The people appear to be excited for some reason. You hear whispers of 'the warrior is back'");
                ProgressionManager.sleep(1000);
                System.out.println("You approach what looks to be a town hall");
                ProgressionManager.sleep(1000);
                System.out.println("The person who appears to be the leader approaches you and says 'welcome back warrior' it has been a while!");
                ProgressionManager.sleep(1000);
                System.out.println("\nYou have no idea what the leader is talking about so you ask 'I've been here before?'\n");
                ProgressionManager.sleep(1000);
                System.out.println("They look at you strangely. 'I offered you a quest to find an ancient artifact and you denied. Do you not remember?' ");
                ProgressionManager.sleep(1000);
                System.out.println("\nYou shake your head. You still don't know what's going on\1n");
                ProgressionManager.sleep(1000);
                System.out.println("You hear the leader mutter something under their breath 'interesting, most interesting'\n");
                ProgressionManager.sleep(1000);
                System.out.println("They lead you outside and point into the distance at a range of towering mountains and give you a smile. Do you accept my quest warrior?");
                ProgressionManager.sleep(1000);
                villageArtifactMountain();

            }
        }

    }
    private static void villageArtifactMountain(){
        System.out.println("Do you accept the quest?   Yes[0]   No[1]");
        switch (UserInteraction.getUserText("yes,no,0,1")){
            case "yes":
            case "0":
                System.out.println("You nod your head in acceptance");
                ProgressionManager.sleep(200);
                System.out.println("The village leader gives you a set of warm clothes and you set off");
                case0Position = 1; //accepted quest
                ProgressionManager.sleep(1000);
                System.out.println("You spend many days and nights making your way to the mountain");
                ProgressionManager.sleep(1000);
                System.out.println("From you the small monsters and animals you killed on the way you have earned 1000 coins!");
                Main.character.coins += 1000;
                ProgressionManager.sleep(1000);
                System.out.println("+ 1000 Coins");
                ProgressionManager.sleep(1000);
                System.out.println("You now find yourself at the foot of the mountain");
                ProgressionManager.sleep(1000);
                System.out.println("You glance up at the shear face of the mountain and the thought gives you chills. As you look down though, you notice a cave");
                ProgressionManager.sleep(1000);
                System.out.println("Do you try to climb the mountain (high dexterity required) [0]   or do you go into the cave [1]");
                switch (UserInteraction.getUserText("0,1")){
                    case "0":
                        if(Main.character.getEffectiveDex() > 100){
                            System.out.println("You ready yourself and begin to attack the face of the mountain");
                            ProgressionManager.sleep(1000);
                            System.out.println("The climb is hard but and your burning muscles almost give out but you finally find yourself at the top");
                            ProgressionManager.sleep(1000);
                            villageArtifactOrb();

                        } else {
                            case0Position = 2; //accepted quest but died
                            System.out.println("You ready yourself and begin to attack the face of the mountain");
                            ProgressionManager.sleep(1000);
                            System.out.println("The climb is hard but and your muscles begin to burn");
                            ProgressionManager.sleep(1000);
                            System.out.println("The air becomes thinner as you climb and you start gasping for air");
                            ProgressionManager.sleep(1000);
                            System.out.println("Your burning muscles give their one last hurrah and you pass out");
                            ProgressionManager.sleep(1000);
                            ProgressionManager.death();
                        }
                        break;
                    case "1":
                        System.out.println("You decide the climb isn't for you and you head into the cave");
                        ProgressionManager.sleep(1000);
                        System.out.println("Beautiful ice formations adorn the area as you trek deeper");
                        ProgressionManager.sleep(1000);
                        System.out.println("Suddenly you get the feeling you aren't alone");
                        storyCombat();
                        //NPC enemy = new NPC(WorldGenerator.WorldType.CAVE, Main.character);
//                        ProgressionManager.turnManager(enemy);
//                        ProgressionManager.inCombat = false;
//                        if(enemy.health > 0){
//                            case0Position = 2;
//                            exitStory();
//                        }
                        ProgressionManager.sleep(1000);
                        System.out.println("The slain enemy lays at your feet, its blood soaking into the icy floor");
                        ProgressionManager.sleep(1000);
                        System.out.println("You sheathe your weapon and keep moving forward");
                        ProgressionManager.sleep(1000);
                        System.out.println("You find yourself looking at a pool of water");
                        ProgressionManager.sleep(1000);
                        System.out.println("The longer you keep looking, the less it looks like water");
                        ProgressionManager.sleep(1000);
                        System.out.println("There is an unnatural shimmer to the surface. Something not quite of this world");
                        ProgressionManager.sleep(1000);
                        System.out.println("Step in [0]");
                        UserInteraction.getUserText("0");
                        ProgressionManager.sleep(1000);
                        System.out.println("Your foot touches the surface of the pool and nothing happens");
                        ProgressionManager.sleep(1000);
                        System.out.println("The water is warm. A perfect temperature even this high in the mountains");
                        ProgressionManager.sleep(1000);
                        System.out.println("The second you dip your torso in, the world starts to swirl");
                        ProgressionManager.sleep(1000);
                        System.out.println("You hear the chiming of bells and whispers of voices that you can't quite make out");
                        ProgressionManager.sleep(1000);
                        System.out.println("Suddenly, everything stops");
                        ProgressionManager.sleep(1000);
                        System.out.println("You realize that your eyes were closed and so you open them");
                        ProgressionManager.sleep(1000);
                        System.out.println("You are are the top of the mountain. You decide that its probably best not to question things");
                        ProgressionManager.sleep(1000);
                        System.out.println("In front of you, you see a marble altar");
                        ProgressionManager.sleep(1000);
                        villageArtifactOrb();
                }
                break;
            case "no":
            case "1":
                System.out.println("You shake your head and apologize. You say that you must continue on your journey");
                ProgressionManager.sleep(200);
                System.out.println("You leave the village and continue you on your journey");
                case0Position = 9; //denied quest
                //exitStory();
                break;
        }
    }
    private static void villageArtifactOrb(){
        System.out.println("On top of a marble altar you see a swirling... orb");
        ProgressionManager.sleep(1000);
        System.out.println("it seems to bend the world around it and you can't quite make out its details.");
        ProgressionManager.sleep(1000);
        System.out.println("This must be the artifact you were looking for");
        ProgressionManager.sleep(1000);
        System.out.println("As you approach the orb, its power begins to overwhelm you");
        ProgressionManager.sleep(1000);
        System.out.println("Suddenly a thought comes into your head. This is clearly an artifact of immense power. Why give it back to the village?");
        ProgressionManager.sleep(1000);
        System.out.println("Give it to the village [0]   Keep it for yourself [1]");
        switch (UserInteraction.getUserText("0,1")){
            case "0":
                System.out.println("The orb gives a friendly hum and you no longer feel its overwhelming power");
                ProgressionManager.sleep(1000);
                System.out.println("You put the orb in your bag and begin your trek down the mountain");
                ProgressionManager.sleep(1000);
                System.out.println("As you are pondering, your method of decent, the orb decides that it has its own ideas");
                ProgressionManager.sleep(1000);
                System.out.println("You start to feel its power surround you again");
                ProgressionManager.sleep(1000);
                System.out.println("Then, in the blink of an eye, you find yourself back in the village you started from");
                ProgressionManager.sleep(1000);
                System.out.println("The villagers swarm around you in excitement. You realize now that the orb is no longer in your bag but floating in front of you with a soft blue hue");
                ProgressionManager.sleep(1000);
                System.out.println("The village leader comes out to congratulate you and as they do, the orb flies over to them, trills happily, and flashes a bright rainbow of colors. It seems its happy to find its rightful owner");
                ProgressionManager.sleep(1000);
                System.out.println("The village leader laughs and then comes up to you and thanks you");
                ProgressionManager.sleep(1000);
                System.out.println("For your efforts, you are given 10,000 coins as a reward");
                ProgressionManager.sleep(1000);
                Main.character.coins += 10000;
                System.out.println("+ 10,000 coins");
                case0Position = 3; //accepted quest and succeeded
                break;
            case "1":
                System.out.println("The orb suddenly turns a blood red");
                ProgressionManager.sleep(1000);
                System.out.println("A void fills your head 'you have betrayed your promise'");
                ProgressionManager.sleep(1000);
                System.out.println("The orb begins to glow brighter and you find yourself overwhelmed by its power");
                ProgressionManager.death();
                case0Position = 4; //accepted quest but betrayed promise
                break;
        }
    }
    //---------------------------------------------------Village Story Bottom-------------------------------------------------------------




    //---------------------------------------------------Combat Mechanics Top-------------------------------------------------------------
    private static void storyCombat(){
        NPC enemy = new NPC(WorldGenerator.WorldType.STORY_COMBAT_CAVE,Main.character);
        combatActionBar(enemy,Main.character);

    }
    private static void combatActionBar(NPC enemy, PCharacter character){
        //enemyDefeated = false;
        //System.out.println("\nPrepare for combat");
        if(enemy.health > 0){
            ProgressionManager.sleep(1000);
            if(character.isDead()){
                ProgressionManager.death();
                //  ProgressionManager.inCombat = false;
                //ProgressionManager.turnManager(enemy);
            } else {
                if(enemy.dexterity > character.getEffectiveDex()){
                    ProgressionManager.sleep(200);
                    System.out.println("\nEnemy attacks first");
                    UserInteraction.attackEnemy(enemy);
                }
                if(character.isDead()){
                    //  ProgressionManager.inCombat = false;
                    ProgressionManager.death();
                } else {
                    System.out.println("\nWhat would you like to?   [Attack][0]   [Heal][1]");
                    switch (UserInteraction.getUserText("attack,0,heal,1")){
                        case "0":
                        case "attack":
                            //character attack
                            if(Main.character.getWeapon().isMagic){
                                if(UserInteraction.magicCasting()){
                                    System.out.println("Cast successful!\n");
                                    UserInteraction.attackEnemy(enemy);
                                } else {
                                    System.out.println("Cast failed\n");
                                }
                            } else {
                                UserInteraction.attackEnemy(enemy);
                            }
                            if(enemy.health > 0){
                                UserInteraction.attackEnemy(enemy);
                            }
                            combatActionBar(enemy,character);
                            //ProgressionManager.turnManager(enemy);
                            break;
                        case "1":
                        case "heal":
                            Main.character.combatRest();
                            combatActionBar(enemy,character);
                            //ProgressionManager.turnManager(enemy);
                            break;
                    }
                }
            }
        }
    }
    //---------------------------------------------------Combat Mechanics Bottom----------------------------------------------------------

    private static void exitStory(){
        System.out.println("story exit");
        UserInteraction.actionBar();
        //ProgressionManager.moveForward();
        //UserInteraction.actionBar();
        //exit is handled by moveForward called by player using the actionBar. globalMovesLeft is already set to 0 when this is called
    }
}
