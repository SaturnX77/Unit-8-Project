public class ProgressionManager {
    public static int returnPoint = 0;
    static boolean inCombat = false;
    static boolean isTrading = false;
    static boolean isLooting = false;


    static WorldGenerator worldGenerator = new WorldGenerator();
    public static int gameProgressionTurns = 0;
    public void startGame(){
        if(returnPoint == 0){
            System.out.println("Your eyes flicker open and take a second to adjust to the light");
            sleep(1000);
            System.out.println(".");
            sleep(1000);
            System.out.println(".");
            sleep(1000);
            System.out.println(".");
            sleep(1000);
            System.out.println("Your head is foggy and you have no memory of anything");
            returnPoint = 1;
        }
        if (returnPoint == 2){
            worldGenerator.globalMovesLeft = 0;
        }
        System.out.println("You are lying on a beach. The sandy particles are everywhere in your clothes and you can hear waves crashing behind you");
        System.out.println("What do you do?   [look around][0]   [nothing][1]");
        String userInput = UserInteraction.getUserText("look around,0,nothing,1");
        switch (userInput){
            case "0":
            case "look around":
                System.out.println("You look and notice that around you is a weapon and a set of armor");
                giveWeapon();
                giveArmor();
                //Main.character.
                System.out.println("You also notice a castle in far in the distance. It is the only sign of civilization. You have no choice but to move forwards");
                sleep(2000);
                game();
                break;
            case "1":
            case "nothing":
                doNothing();
                startGame();
                break;
        }
    }
    public void game(){
        //need an action bar that doesn't take in anything
        UserInteraction.actionBar();

    }
    public static void moveForward(){
//        System.out.println("globalMovesInTile: " + worldGenerator.globalMovesInTile);
//        System.out.println("globalMovesLeft: " +worldGenerator.globalMovesLeft);
        if(worldGenerator.globalMovesLeft == worldGenerator.globalMovesInTile){
            worldGenerator.generateWorldTile();
        }
        worldGenerator.subtractMoves();
        sleep(300);
        NPC npc = new NPC(worldGenerator.getWorldType(), Main.character);
        if(npc.npcType.equals(NPC.NpcType.ENEMY)){
            inCombat = true;
        }
        UserInteraction.actionBar(inCombat, isTrading, isLooting, npc,Main.character);
        gameProgressionTurns++;
    }
    private void giveWeapon(){
        System.out.println("You have acquired a new weapon");
        Main.character.inventory.set(0, new Weapon(Main.character));
    }
    private void giveArmor(){
        System.out.println("You have acquired a new set of armor");
        Main.character.inventory.set(1, new Armor(Main.character));
    }
    private void doNothing(){
        sleep(1000);
        System.out.println(".");
        sleep(1000);
        System.out.println(".");
        sleep(1000);
        System.out.println(".");
        sleep(1000);
        System.out.println("You did nothing.... nothing happened");
    }

    public static void sleep(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void turnManager(NPC enemy){
        if(Main.character.isDead()){
            death();
        } else if(UserInteraction.enemyDefeated){
            UserInteraction.runCounter = 0;
            inCombat = false;
            isLooting = true;
            UserInteraction.actionBar(isLooting);
        } else {
            //inCombat = true;
            UserInteraction.actionBar(inCombat,isTrading,isLooting, enemy,Main.character);
        }
    }
//    public static void turnManager(NPC enemy, boolean story){
//        if(Main.character.isDead()){
//            if(story){
//                inStory = false;
//            }
//            death();
//        } else if(UserInteraction.enemyDefeated){
//            UserInteraction.runCounter = 0;
//            inCombat = false;
//            isLooting = true;
//            if(story){
//                UserInteraction.storyActionBar();
//            } else {
//                UserInteraction.actionBar(isLooting, story);
//            }
//        } else {
//            //inCombat = true;
//            UserInteraction.actionBar(inCombat,isTrading,isLooting,true,enemy,Main.character);
//        }
//    }
    public static void turnManager(){
        if(Main.character.isDead()){
            death();
        } else {
            isLooting = false;
            UserInteraction.actionBar();

        }
    }
    public static void death(){
        System.out.println("\nThe world fades to black around you");
        sleep(2000);
        System.out.println("Suddenly a stale air fills your lungs and your eyes open again");
        System.out.println("You find yourself in a desecrated cathedral. Pale light shines through broken mosaic windows");
        sleep(2000);
        System.out.println("You bring yourself to your feet and you find that your wounds from battle have been healed");
        sleep(2000);
        System.out.println("A voice pierces through your mind even though you can't see anyone");
        sleep(2000);
        System.out.println("Your journey is not over yet");
        UserInteraction.deathUpgrades();
    }

}
