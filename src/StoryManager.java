import java.util.ArrayList;

public class StoryManager {

    //-------------------------------------Mansion Story Top-----------------------------------
    static int case1Visited = 0;
    static int case1Position = 0;
   // static String artifactPosition = "Bedroom";
    static boolean viewedPicture = false;
    static boolean hasArtifact = false;
    static boolean viewedBook = false;
    //------------------------------------Mansion Story Bottom---------------------------------

    static int case2Visited = 0;
    static int case3Visited = 0;
    static int case4Visited = 0;

    //----------------------------------Village Story Top---------------------------------------
    static int case0Visited = 0;
    static int case0Position = 0;
    //--------------------------------Village Story Bottom-------------------------------------


    static ArrayList<Integer> usedStories = new ArrayList<>();
    public static void newStory(){
        if(usedStories.size() == 2){
            System.out.println("No more stories available");
            ProgressionManager.moveForward();
        }
      //  System.out.println("newstory called");
        //System.out.println(usedStories);
        int rand = NumberProcessor.getRandom(0,2);
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
                abandonedLabStart();
              //  System.out.println("case 1");
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


    //-------------------------------------Village Story Top-----------------------------------------------
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
                System.out.println("You hear the leader mutter something under their breath 'interesting, most interesting'\n");
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
                    System.out.println("Is it worth accepting this time?");
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
                ProgressionManager.sleep(1000);
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
                        ProgressionManager.sleep(1000);
                        System.out.println("The slain enemy lays at your feet, its remains littering the icy floor");
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
    //---------------------------------------Village Story Bottom----------------------------------------------


    //------------------------------------------Lab Story Top--------------------------------------------------
    private static void abandonedLabStart(){
        if(case1Visited == 0){
            System.out.println("You find yourself in the nearly empty remnants of a field of sorts");
            ProgressionManager.sleep(1000);
            System.out.println("The plants are wilted and colored a sickly black");
            ProgressionManager.sleep(1000);
            System.out.println("There does not appear to be a single living creature in the vicinity");
            ProgressionManager.sleep(1000);
            System.out.println("In this middle of this dead field stands a mansion");
            ProgressionManager.sleep(1000);
            System.out.println("It's walls are stained the same sickly black color as the plants");
            ProgressionManager.sleep(1000);
            System.out.println("There seems to be a telescope as well as some other miscellaneous appendages sticking out at odd angles from the roof of the mansion");
            ProgressionManager.sleep(1000);
            System.out.println("Go towards the mansion   Yes[0]   No[1]");
            switch (UserInteraction.getUserText("yes,0,no,1")){
                case "yes":
                case "0":
                    case1Position = 1; //entered field
                    ProgressionManager.sleep(1000);
                    System.out.println("As you approach the field, the sickly black substance seems to perk up as if it has noticed your presence");
                    ProgressionManager.sleep(1000);
                    System.out.println("As you keep walking forward, it becomes clear that the substance isn't natural. It wraps around your legs and snakes its way up you body");
                    ProgressionManager.sleep(1000);
                    System.out.println("They don't appear to be particularly harmful at initial assessment.");
                    ProgressionManager.sleep(1000);
                    System.out.println("Suddenly you feel your heart flutter. You look down and you notice that in the places that the black substance touched you have started to turn black and chip off as flakes");
                    ProgressionManager.sleep(1000);
                    System.out.println("-5 Health");
                    Main.character.subtractHealthStory(5);
                    ProgressionManager.sleep(1000);
                    //System.out.println("Suddenly a robotic voice pops into your head and says 'Detecting multiple Leviathan class life forms... Are you certain whatever you're doing is worth it?'");
//                    ProgressionManager.sleep(1000);
//                    System.out.println("You have no idea what it means or what its talking about but you decide to consider the warning");
                    ProgressionManager.sleep(1000);
                    System.out.println("Continue forwards   Yes[0]   No[1]");
                    switch (UserInteraction.getUserText("yes,0,no,1")){
                        case "yes":
                        case "0":
                            case1Position = 3; //entered mansion
                            abandonedLabEntrance();
                            break;
                        case "no":
                        case "1":
                            case1Position = 4; //got to doors but left
                            break;
                    }
                    break;
                case "no":
                case "1":
                    case1Position = 2; //left when seeing field
                    System.out.println("You decide to leave the odd field behind");
                    break;
            }
        }
    }
    private static void abandonedLabEntrance(){
        System.out.println("As you approach the doors of the mansion, the dark substance continues to get thicker");
        ProgressionManager.sleep(1000);
        System.out.println("It fills your lungs and makes it difficult to breathe");
        ProgressionManager.sleep(1000);
        System.out.println("-10 Health");
        Main.character.subtractHealthStory(10);
        ProgressionManager.sleep(1000);
        System.out.println("Gasping for air, you slam the mansion's doors open and stumble inside");
        ProgressionManager.sleep(1000);
        System.out.println("You feel fresh air slam into your nostrils and you breathe a sigh of relief. The dark substance doesn't appear to have made its way into the house");
        ProgressionManager.sleep(1000);
        System.out.println("You Take a second to calm down and then look down at you body. The black substance seems to be gone and the damaged skin seems to have healed");
        Main.character.rest();
        ProgressionManager.sleep(1000);
        System.out.println("You finally take a look around the mansion");
        ProgressionManager.sleep(1000);
        System.out.println("You appear to be in some sort of entrance hall. The interior seems to be perfectly preserved. Gold stair rails, velvet on the walls, marble columns, diamond encrusted picture frames.");
        ProgressionManager.sleep(1000);
        System.out.println("You walk around and test the doors on the first floor. They are all locked. The only way forward is the stairs. The diamond encrusted picture frame catches your attention though");
        ProgressionManager.sleep(1000);
        System.out.println("Take a look at the picture [0]   Climb the stairs [1]");
        switch (UserInteraction.getUserText("0,1")){
            case "0":
                lookAtMansionPicture();
                break;
            case "1":
                mansionSecondFloor(0);
                break;
        }
    }
    private static void lookAtMansionPicture(){
        viewedPicture = true;
        System.out.println("You come closer to the diamond encrusted frame. The picture inside depicts a professional looking woman");
        ProgressionManager.sleep(1000);
        System.out.println("She is wearing a long dress and around her neck hangs a pendant with a shining gem in the center. It doesn't seem like any gem you know of");
        ProgressionManager.sleep(1000);
        if(case1Visited > 1){
            System.out.println("The picture seems to jog your memory. You've been here before. You don't know when or what happened, but you know for sure that you've seen this woman before");
        }
        mansionSecondFloor(0);
    }
    private static void mansionSecondFloor(int position){
        if(position == 0){
            System.out.println("You climb the stairs of the mansion and some of the odd features you noticed outside now become more obvious");
            ProgressionManager.sleep(1000);
        }
        System.out.println("There is an observatory room, a laboratory room, and what appears to be a bedroom");
        ProgressionManager.sleep(1000);
        System.out.println("Which do you go into?  Observatory Room[0]   Laboratory[1]   Bedroom[2]");
        switch (UserInteraction.getUserText("0,1,2")){
            case "0":
                observatoryRoom();
                break;
            case "1":
                labRoom();
                break;
            case "2":
                bedroom();
                break;
        }
    }
    private static void observatoryRoom(){
        ProgressionManager.sleep(1000);
        System.out.println("You enter the observatory. The eyepiece of the telescope is available to look through surrounded by piles of papers that seem to include sketches of various planets and charts depicting their orbits");
        ProgressionManager.sleep(1000);
        System.out.println("Do you take a look through the telescope?   Yes[0]   No[1]");
        switch (UserInteraction.getUserText("yes,0,no,1")){
            case "yes":
            case "0":
                System.out.println("As you gaze through the eyepiece of the scope the sky darkens. Its so sudden that you step back and look around");
                ProgressionManager.sleep(1000);
                System.out.println("You lead back into the telescope and the sky darkens again. It seems that any time the scope is used, it darkens the entire sky for the user. Theres bound to be a few very confused animals right now");
                ProgressionManager.sleep(1000);
                System.out.println("You look through the scope and you can hardly believe your eyes");
                ProgressionManager.sleep(1000);
                System.out.println("A universe unfurls before you, revealing a tapestry of twinkling stars and swirling galaxies. A detail the likes you could never have even imagined.");
                ProgressionManager.sleep(1000);
                System.out.println("You spend the next few minutes in a state of wonder, marveling at the beauty of the universe");
                ProgressionManager.sleep(1000);
                System.out.println("With the beauty of the universe now painted onto your mind you stumble into the same three doors");
                ProgressionManager.sleep(1000);
                mansionSecondFloor(1);
                break;
            case "no":
            case "1":
                System.out.println("You decide not to look through the telescope and make your way outside of the room");
                ProgressionManager.sleep(1000);
                mansionSecondFloor(1);
                break;

        }
    }

    private static void labRoom(){
        ProgressionManager.sleep(1000);
        System.out.println("You enter the room with a gold plaque saying 'Lab'");
        ProgressionManager.sleep(1000);
        System.out.println("As you push the door open, there is a clinking of glass as you nudge away glass beakers and jars");
        ProgressionManager.sleep(1000);
        System.out.println("As the contents of the lab focused in your eyes, you find your eyes drawn in every which direction");
        ProgressionManager.sleep(1000);
        System.out.println("There are containers everywhere, jars containing various colored liquids, some even containing pieces of some of the monsters you've encountered. \nA merfolk tail, a behir fang, and many more than you don't recognize");
        ProgressionManager.sleep(1000);
        System.out.println("You find one table with nothing on it but a thick, bound book");
        ProgressionManager.sleep(1000);
        System.out.println("Do you look inside?   Yes[0]   No[1]");
        switch (UserInteraction.getUserText("yes,0,no,1")){
            case "yes":
            case "0":
                System.out.println("You open the book");
                ProgressionManager.sleep(1000);
                System.out.println("The pages are old, brittle, and yellowed");
                ProgressionManager.sleep(1000);
                System.out.println("The text appears to be in some language that you can't understand");
                ProgressionManager.sleep(1000);
                System.out.println("As you keep flipping through the pages, one catches your attention");
                ProgressionManager.sleep(1000);
                System.out.println("A beautiful amulet with a shining green stone at the center");
                if(viewedPicture){
                    ProgressionManager.sleep(1000);
                    System.out.println("Could this be the same amulet that the woman was wearing in the picture was wearing earlier?");
                }
                if(hasArtifact){
                    ProgressionManager.sleep(1000);
                    System.out.println("You look down at your own amulet. It appears to be the same as the one in the illustration. You wonder quietly to yourself what it could mean");
                }
                ProgressionManager.sleep(1000);
                System.out.println("Once you're finished looking through the book, you leave the lab");
                viewedBook = true;
                break;
            case "no":
            case "1":
                System.out.println("You decide not to look through the book and make your way outside of the room");
                ProgressionManager.sleep(1000);
                break;
        }
        mansionSecondFloor(1);
    }
    private static void bedroom(){
        ProgressionManager.sleep(1000);
        System.out.println("You walk into a bedroom. There is a massive four poster bed in the center of of the room and a small nightstand to the left side");
        ProgressionManager.sleep(1000);
        System.out.println("A glint of green catches your eye");
        ProgressionManager.sleep(1000);
        System.out.println("As you walk towards the nightstand and examine the green glint that caught your eye, you find a piece of jewelery. It appears to be something like a necklace with a large green stone in the center.");
        if(viewedBook){
            ProgressionManager.sleep(1000);
            System.out.println("As you continue examining the necklace you think back to the book you flipped through in the lab");
            ProgressionManager.sleep(1000);
            System.out.println("You didn't understand any of the text in the book, could this necklace be dangerous? Its in a bedroom, maybe its just really fancy jewellery?");
        } else {
            ProgressionManager.sleep(1000);
            System.out.println("You take a look at the necklace. The green stone in the center is mesmerizing with the depth of color. ");
            ProgressionManager.sleep(1000);
            System.out.println("Maybe it could have a lot of value? The chain looks like its made out of gold too.");
        }
        putOnNeckLace();
    }
    private static void putOnNeckLace(){
        ProgressionManager.sleep(1000);
        System.out.println("The longer you examine it, the more you look at the necklace, the more it draws you in");
        ProgressionManager.sleep(1000);
        System.out.println("Put on the necklace [0]");
        UserInteraction.getUserText("0");
        System.out.println("You put on the necklace...");
        hasArtifact = true;
        for(int i = 0; i < 3; i++){
            ProgressionManager.sleep(2000);
            System.out.println(".");
        }
        ProgressionManager.sleep(2000);
        System.out.println("Suddenly the entire world turns black and you find yourself unconscious");
        ProgressionManager.sleep(1000);
        System.out.println("Hours if not days pass before you wake up again");
        ProgressionManager.sleep(1000);
        System.out.println("Your eyes flicker open to the sounds of wind blowing and bird chirping around you");
        ProgressionManager.sleep(1000);
        System.out.println("The mansion and the dying field are nowhere to be seen. Instead you find yourself in a beautiful plain with lots of greenery and animal life");
        ProgressionManager.sleep(1000);
        System.out.println("You glance down and find the amulet still around your neck. You try to pull at it but it looks like it has attached itself to you quite securely");
        ProgressionManager.giveArtifact();
        exitStory();
    }
    //------------------------------------------Lab Story Bottom--------------------------------------------


    //---------------------------------------Combat Mechanics Top-------------------------------------------
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
                    System.out.println("effective dexterity: " + character.getEffectiveDex());
                    ProgressionManager.sleep(200);
                    System.out.println("\nEnemy attacks first");
                    UserInteraction.attackCharacter(enemy);
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
    //---------------------------------------------Combat Mechanics Bottom---------------------------------------

    private static void exitStory(){
        System.out.println("story exit");
        UserInteraction.actionBar();
        //ProgressionManager.moveForward();
        //UserInteraction.actionBar();
        //exit is handled by moveForward called by player using the actionBar. globalMovesLeft is already set to 0 when this is called
    }
}
