public class ProgressionManager {
    int returnPoint = 0;
    static boolean inCombat = false;
    static boolean isTrading = false;
    static boolean isLooting = false;
   // static UserInteraction userInteraction = new UserInteraction();
    static WorldGenerator worldGenerator = new WorldGenerator();
    public static int gameProgressionTurns = 0;
    public ProgressionManager(){
    }
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
            returnPoint = 1;
        }
        System.out.println("You are lying on a beach. The sandy particles are everywhere in your clothes and you can hear waves crashing behind you");
        System.out.println("What do you do? [look around] [nothing]");
        String userInput = UserInteraction.getUserText();
        switch (userInput){
            case "look around":
                System.out.println("You look and notice that around you is a weapon and a set of armor");
                giveWeapon();
                giveArmor();
                //Main.character.
                System.out.println("You also notice a castle in far in the distance. It is the only sign of civilization. You have no choice but to move forwards");
                sleep(2000);
                game();
                break;
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
        if(worldGenerator.globalMovesLeft == worldGenerator.globalMovesinTile){
            worldGenerator.generateWorldTile();
        }
        worldGenerator.subtractMoves();
        sleep(1000);
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
        if(UserInteraction.enemyDefeated){
            inCombat = false;
            isLooting = true;
            UserInteraction.actionBar(isLooting);
        } else {
            //inCombat = true;
            UserInteraction.actionBar(inCombat,isTrading,isLooting,enemy,Main.character);
        }
    }
    public static void turnManager(){
        isLooting = false;
        UserInteraction.actionBar();
    }

}
