import java.util.ArrayList;

public class WorldGenerator {
    public int movesLeft = 6;
    //public boolean inTile = true;
    WorldType worldType;
    public enum WorldType {
        CAVE(0.9,0.0,0),
        PLAIN(0.5,0.1,0),
        ROAD(0.2,0.2,0),
        CASTLE(0,0,1);
        final double monsterChance;
        final double merchantChance;
        final int gameEnd;

        WorldType(double monsterChance, double merchantChance, int gameEnd) {
            this. monsterChance = monsterChance;
            this.merchantChance = merchantChance;
            this.gameEnd = gameEnd;
        }

    }
    private WorldType getWorldType(){
        return worldType;
    }
    public WorldGenerator(){
    }

    public void subtractMoves(){
        movesLeft--;
        if(movesLeft == 0){
            exitTile();
            generateWorldTile();

        }
    }
    private void exitTile(){
        switch (worldType){
            case PLAIN:
                System.out.println("The luscious, yellow-green grass disappears around you. You have exited the plains");
                break;
            case ROAD:
                System.out.println("The level, paved road disappears around you. You have exited the road");
                break;
            case CAVE:
                System.out.println("The dark caverns disappear and you are finally able to see the light. You have exited the cave");
                break;
            case CASTLE:
                System.out.println("yea dis the end of the game but you aren't supposed to be here");
                break;
        }
    }

    private void enterTile(){
        switch (worldType){
            case PLAIN:
                printEnv(worldType);
                System.out.println("You find yourself in a wide open plain. The grass swishes softly around you in the wind. You have entered the plains");
                break;
            case ROAD:
                printEnv(worldType);
                System.out.println("A lovely paved road has appeared before you. You have entered the road");
                break;
            case CAVE:
                printEnv(worldType);
                System.out.println("You find yourself at the maw of an ominous cave. You enter the cave. The light disappears around you.");
                break;
            case CASTLE:
                printEnv(worldType);
                System.out.println("oh fuck i didnt write the code for this");
                break;
        }

    }

    public int getMovesLeft() {
        return movesLeft;
    }
    public void generateWorldTile(){
        WorldType temp = null;
        double randomNum = NumberProcessor.getRandom(0,101);
        randomNum = randomNum*(1+ (ProgressionManager.gameProgressionTurns/30.0));
        System.out.println("world gen:" + randomNum);
        if(randomNum <= 45){
            temp = WorldType.PLAIN;
        } else if(randomNum <= 75){
            temp = WorldType.ROAD;
        } else if(randomNum <= 99){
            temp = WorldType.CAVE;
        } else if(randomNum >= 99){
            temp = WorldType.CASTLE;
        }
        worldType = temp;
        enterTile();
        //generateWorldTile();
           // Item.Rarity temp;
    }
    private void printEnv(WorldType envName){
        ArrayList<String> temp = FileReader.getStringData("src/art/environment/" + envName + ".txt");
        for(String string : temp){
            System.out.println(string);
        }
    }
}
