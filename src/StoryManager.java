import java.util.ArrayList;

public class StoryManager {

    static int case0Visited = 0;
    static int case1Visited = 0;
    static int case2Visited = 0;
    static int case3Visited = 0;
    static int case4Visited = 0;

    static ArrayList<Integer> usedStories = new ArrayList<>();
    public static void newStory(){
        if(usedStories.size() == 5){
            System.out.println("No more stories available");
            ProgressionManager.moveForward();
        }
        System.out.println("newstory called");
        System.out.println(usedStories);
        int rand = NumberProcessor.getRandom(0,5);
        System.out.println("new story rand: " + rand);
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
                case0Visited++;
//                System.out.println("You find yourself in a small village surrounded by rolling hills and towering trees");
//                System.out.println("As you walk down the dirt road ");
                System.out.println("case 0");
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
    private static void exitStory(){
        System.out.println("story exit");
        UserInteraction.actionBar();
        //ProgressionManager.moveForward();
        //UserInteraction.actionBar();
        //exit is handled by moveForward called by player using the actionBar. globalMovesLeft is already set to 0 when this is called
    }
}
