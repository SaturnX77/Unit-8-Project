public class Main {
    public static PCharacter character;
    public static void main(String[] args) {
        character = new PCharacter();
        UserInteraction userInteraction = new UserInteraction();
        Weapon test = new Weapon().createWeapon(character);
        Weapon.printWeaponStats(test);
    }
}