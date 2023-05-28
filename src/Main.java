import java.awt.*;
import java.io.Console;
import java.io.IOException;

public class Main {
    public static PCharacter character;
    public static void main(String[] args) {
        Console console = System.console();
        if(console == null && !GraphicsEnvironment.isHeadless()){
            String filename = Main.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
            try {
                Runtime.getRuntime().exec(new String[]{"cmd","/c","start","cmd","/k","java -jar \"" + filename + "\""});
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //System.out.println("\033[107m\033[30m");
        character = new PCharacter();
        UserInteraction userInteraction = new UserInteraction();
        userInteraction.welcome();
        //Weapon test = new Weapon(character);
        //Weapon.printWeaponStats(test);
        //System.out.println();

    }
}