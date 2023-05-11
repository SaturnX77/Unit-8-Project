import java.util.ArrayList;

public class StoryManager {

    static ArrayList<Integer> usedStories = new ArrayList<>(5);
    public static void newStory(){
        System.out.println(usedStories);
        storyManager(0);
        int rand = NumberProcessor.getRandom(1,6);
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
        System.out.println("This is the test of the story exit system");
        exitStory();

//        switch(storyIndex){
//
//        }
    }
    private static void exitStory(){
        UserInteraction.actionBar();
       // ProgressionManager.moveForward();
    }
}
