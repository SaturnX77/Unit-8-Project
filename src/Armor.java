import java.util.ArrayList;

public class Armor extends Item{
    String name;
    double defense = 0.0;
    double dexterityScalar = 1.0;
    public Armor(PCharacter character){
        setRarity((int)character.baseLuck);
        setValue(getRarity());
        switch (rarity){
            case COMMON:
                setDefense(30,50);
                // temp.setAttack(NumberProcessor.getRandom(30,50) * Weapon.weaponClass.AXE.attackScalar);
                break;
            case UNCOMMON:
                setDefense(50,70);
                // temp.setAttack(NumberProcessor.getRandom(50,70) * Weapon.weaponClass.AXE.attackScalar);
                break;
            case RARE:
                setDefense(70,90);
                break;
            case VERY_RARE:
                setDefense(90,110);
                break;
            case LEGENDARY:
                setDefense(120,140);
                break;
            case MYTHIC:
                setDefense(180, 280);
                break;
        }
        setDexterityScalar(NumberProcessor.getRandom(0.5,1.2));
        setName();
    }

    public void setDexterityScalar(double dexterityScalar) {
        this.dexterityScalar = dexterityScalar;
    }

    public double getDefense() {
        return defense;
    }

    public double getDexterityScalar() {
        return dexterityScalar;
    }
    public void setDefense(double defense) {
        this.defense = defense;
    }
    public void setDefense(int low, int high){
        setDefense(NumberProcessor.getRandom(low,high));
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        ArrayList<String> armorNames = FileReader.getStringData("src/names/armornames.txt");
        String temp = armorNames.get(NumberProcessor.getRandom(0,armorNames.size()));
        setName(temp);
    }
    public void printArmorStats(){
        System.out.println("\nArmor stats:");
        System.out.println("Name: " + getName());
        System.out.println("Defense: " + getDefense());
        System.out.println("Dexterity Scalar: " + getDexterityScalar());
        System.out.println("Rarity: " + getRarity());
        System.out.println("Value: " + getValue());
    }

}
