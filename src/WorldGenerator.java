import java.util.ArrayList;

public class WorldGenerator {
    //public int movesLeft = NumberProcessor.getRandom(4,8);
    public int globalMovesLeft;
    public int globalMovesinTile;
    //public boolean inTile = true;
    WorldType worldType;
    WorldType previousTile = null;
    public enum WorldType {
        CAVE(0.9,0.0,0),
        PLAIN(0.5,0.1,0),
        ROAD(0.2,0.2,0),
        ANCIENT_RUINS(0.5,0.0,0),
        FOREST(0.6,0.1,0),
        ATLANTIS(0.7,0.0,0),
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
    public WorldType getWorldType(){
        return worldType;
    }
    public WorldGenerator(){
    }

    public void subtractMoves(){
        if(globalMovesLeft == 0){
            exitTile();
            generateWorldTile();
           // movesLeft = NumberProcessor.getRandom(4,8);
            globalMovesinTile = NumberProcessor.getRandom(4,8);
            globalMovesLeft = globalMovesinTile;
        }
        globalMovesLeft--;
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
            case ANCIENT_RUINS:
                System.out.println("The broken stone disappears from around your feet. The acropolis is now long behind you. You have exited the ancient ruins");
                break;
            case FOREST:
                System.out.println("You push away a dense patch of branches. The musty smell fades away and the trees are all behind you now. You have exited the forest");
                break;
            case ATLANTIS:
                System.out.println("You feel those same hands that pulled you down from earlier. They grab your waist and suddenly you're flung out of the water. You can finally breathe fresh air again. You have exited the sunken city");
                break;
            case CASTLE:
                System.out.println("yea dis the end of the game but you aren't supposed to be here");
                break;
        }
    }

    private void enterTile(){
        //System.out.println(worldType);
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
            case FOREST:
                printEnv(worldType);
                System.out.println("Trees stretch up endlessly around you and a musty scent fills your nostrils. You have entered the forest");
                break;
            case ANCIENT_RUINS:
                printEnv(worldType);
                System.out.println("You find yourself in a field of ancient ruins. Crumbling stone pillars and a worn marble acropolis stands in front of you. You have entered the ancient ruins");
                System.out.println("An ancient magical energy surrounds you.");
                break;
            case ATLANTIS:
                printEnv(worldType);
                System.out.println("You find yourself at the edge of a lake. Suddenly invisible hands drag you into the water and a bubble of air appears around your head. You have entered the sunken city");
                break;
            case CASTLE:
                printEnv(worldType);
                System.out.println("oh fuck i didnt write the code for this");
                break;
        }

    }

    public void generateWorldTile(){
        globalMovesinTile = NumberProcessor.getRandom(4,8);
        globalMovesLeft = globalMovesinTile;
        WorldType temp = null;
        double randomNum = NumberProcessor.getRandom(0,101);
        randomNum = randomNum*(1+ (ProgressionManager.gameProgressionTurns/30.0));
       // System.out.println("world gen:" + randomNum);
        if(randomNum <= 20){
            temp = WorldType.PLAIN;
        } else if(randomNum<= 30){
            temp = WorldType.ATLANTIS;
        } else if (randomNum <= 40){
            temp = WorldType.ANCIENT_RUINS;
        } else if(randomNum <= 55){
            temp = WorldType.FOREST;
        } else if(randomNum <= 75){
            temp = WorldType.ROAD;
        } else if(randomNum <= 99){
            temp = WorldType.CAVE;
        } else if(randomNum >= 99){
            temp = WorldType.CASTLE;
        }
        worldType = temp;
        if(worldType.equals(previousTile)){
            generateWorldTile();
        } else {
            previousTile = temp;
            enterTile();
        }
    }
    private void printEnv(WorldType envName){
        ArrayList<String> temp = FileReader.getStringData("src/art/environment/" + envName + ".txt");
        for(String string : temp){
            System.out.println(string);
        }
    }
}
