import java.util.ArrayList;

public class Weapon extends Item{
    double attack = 0.0;
    double dexScalar = 1.0;
    String name;
    double attackScalar = 1.0;
    boolean isMagic;
    public enum WeaponType {
        AXE(0.7, 1.5, false),
        STAFF(0.7, 1.5, true),
        SWORD(1.1, 1.3, false),
        GRIMOIRE(1.2, 1.1, true),
        DAGGER(1.4, 0.8, false),
        BOW(1.7, 0.7, false);
        final double dexScalar;
        final double attackScalar;
        final boolean isMagic;

        WeaponType(double dexScalar, double attackScalar, boolean isMagic) {
            this.isMagic = isMagic;
            this.attackScalar = attackScalar;
            this.dexScalar = dexScalar;
        }
    }

    public Weapon (PCharacter character){
        //Weapon temp = new Weapon();
        setRarity((int)character.getEffectiveLuck());
        setValue(getRarity());
        int num = NumberProcessor.getRandom(0,6);
        switch (num){
            case 0: //AXE
                setWeaponClass(WeaponType.AXE);
                setDexScalar(WeaponType.AXE.dexScalar);
                setMagic(WeaponType.AXE.isMagic);
                break;
            case 1: //STAFF
                setWeaponClass(WeaponType.STAFF);
                setDexScalar(WeaponType.STAFF.dexScalar);
                setMagic(WeaponType.STAFF.isMagic);
                break;
            case 2: //SWORD
                setWeaponClass(WeaponType.SWORD);
                setDexScalar(WeaponType.SWORD.dexScalar);
                setMagic(WeaponType.SWORD.isMagic);
                break;
            case 3: //GRIMOIRE
                setWeaponClass(WeaponType.GRIMOIRE);
                setDexScalar(WeaponType.GRIMOIRE.dexScalar);
                setMagic(WeaponType.GRIMOIRE.isMagic);
                break;
            case 4: //DAGGER
                setWeaponClass(WeaponType.DAGGER);
                setDexScalar(WeaponType.DAGGER.dexScalar);
                setMagic(WeaponType.DAGGER.isMagic);
                break;
            case 5: //BOW
                setWeaponClass(WeaponType.BOW);
                setDexScalar(WeaponType.BOW.dexScalar);
                setMagic(WeaponType.BOW.isMagic);
                break;

        }
        Rarity rarity = getRarity();
        switch (rarity){
            case COMMON:
                setAttack(30,50, getWeaponType());
                // temp.setAttack(NumberProcessor.getRandom(30,50) * Weapon.weaponClass.AXE.attackScalar);
                break;
            case UNCOMMON:
                setAttack(50,70, getWeaponType());
                // temp.setAttack(NumberProcessor.getRandom(50,70) * Weapon.weaponClass.AXE.attackScalar);
                break;
            case RARE:
                setAttack(70,90, getWeaponType());
                break;
            case VERY_RARE:
                setAttack(90,110, getWeaponType());
                break;
            case LEGENDARY:
                setAttack(120,140,getWeaponType());
                break;
            case MYTHIC:
                setAttack(180, 280, getWeaponType());
                break;
        }
        setName();
       //return temp;

    }
    public WeaponType weaponType;

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }
    public void setAttack(int low, int high, WeaponType weaponType){
        setAttack(NumberProcessor.getRandom(low,high) * weaponType.attackScalar);
    }
    private void setMagic(boolean isMagic){
        this.isMagic = isMagic;
    }
    public void setDexScalar(double dexScalar) {
        this.dexScalar = dexScalar;
    }

    public double getDexScalar() {
        return dexScalar;
    }

    public void setAttackScalar(double attackScalar){
        this.attackScalar = attackScalar;
    }

    public void setWeaponClass(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void printWeaponStats(){
        System.out.println("\nWeapon stats:");
        System.out.println("Name: " + getName());
        System.out.println("Attack: " + getAttack());
        System.out.println("Rarity: " + getRarity());
        System.out.println("Value: " + getValue() + " coins");
        System.out.println("Class: " + getWeaponType());
        System.out.println("Dexterity Scalar: " + getDexScalar());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName() {
        ArrayList<String> weaponNames = FileReader.getStringData("src/names/" + getWeaponType() +"names.txt");
        String temp = weaponNames.get(NumberProcessor.getRandom(0,weaponNames.size()));
        setName(temp);
    }

}
