public class Weapon extends Item{
    double attack = 0.0;
    double dexScalar = 1.0;
    double attackScalar = 1.0;
    public enum weaponClass {
        AXE(0.7, 1.5),
        STAFF(0.7, 1.5),
        SWORD(1.1, 1.3),
        GRIMOIRE(1.2, 1.1),
        DAGGER(1.4, 0.8),
        BOW(1.7, 0.7);
        final double dexScalar;
        final double attackScalar;

        weaponClass(double dexScalar, double attackScalar) {
            this.attackScalar = attackScalar;
            this.dexScalar = dexScalar;
        }
    }
    static weaponClass weaponClass;
    public Weapon(){
        super();
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }
    public void setAttack(int low, int high, Weapon.weaponClass weaponClass){
        setAttack(NumberProcessor.getRandom(low,high) * weaponClass.attackScalar);
    }

    public void setDexScalar(double dexScalar) {
        this.dexScalar = dexScalar;
    }
    public void setAttackScalar(double attackScalar){
        this.attackScalar = attackScalar;
    }

    public void setWeaponClass(Weapon.weaponClass weaponClass) {
        this.weaponClass = weaponClass;
    }

    public static Weapon.weaponClass getWeaponClass() {
        return weaponClass;
    }

    public Weapon createWeapon(PCharacter character){
        Weapon temp = new Weapon();
        temp.setRarity((int)character.baseLuck);
        temp.setValue(temp.getRarity());
        int num = NumberProcessor.getRandom(0,6);
        switch (num){
            case 0: //AXE
                temp.setWeaponClass(Weapon.weaponClass.AXE);
                temp.setDexScalar(Weapon.weaponClass.AXE.dexScalar);
                break;
            case 1: //STAFF
                temp.setWeaponClass(Weapon.weaponClass.STAFF);
                temp.setDexScalar(Weapon.weaponClass.STAFF.dexScalar);
                break;
            case 2: //SWORD
                temp.setWeaponClass(Weapon.weaponClass.SWORD);
                temp.setDexScalar(Weapon.weaponClass.SWORD.dexScalar);
                break;
            case 3: //GRIMOIRE
                temp.setWeaponClass(Weapon.weaponClass.GRIMOIRE);
                temp.setDexScalar(Weapon.weaponClass.GRIMOIRE.dexScalar);
                break;
            case 4: //DAGGER
                temp.setWeaponClass(Weapon.weaponClass.DAGGER);
                temp.setDexScalar(Weapon.weaponClass.DAGGER.dexScalar);
                break;
            case 5: //BOW
                temp.setWeaponClass(Weapon.weaponClass.BOW);
                temp.setDexScalar(Weapon.weaponClass.BOW.dexScalar);

        }
        Rarity rarity = temp.getRarity();
        switch (rarity){
            case COMMON:
                temp.setAttack(30,50, temp.getWeaponClass());
                // temp.setAttack(NumberProcessor.getRandom(30,50) * Weapon.weaponClass.AXE.attackScalar);
                break;
            case UNCOMMON:
                temp.setAttack(50,70, temp.getWeaponClass());
                // temp.setAttack(NumberProcessor.getRandom(50,70) * Weapon.weaponClass.AXE.attackScalar);
                break;
            case RARE:
                temp.setAttack(70,90, temp.getWeaponClass());
                break;
            case VERY_RARE:
                temp.setAttack(90,110, temp.getWeaponClass());
                break;
            case LEGENDARY:
                temp.setAttack(120,140,temp.getWeaponClass());
                break;
            case MYTHIC:
                temp.setAttack(180, 280, temp.getWeaponClass());
                break;
        }
        return temp;
    }

    public static void printWeaponStats(Weapon weapon){
        System.out.println("Weapon stats");
        System.out.println("Attack: " +weapon.getAttack());
        System.out.println("Rarity: " +weapon.getRarity());
        System.out.println("Value: " + weapon.getValue());
        System.out.println("Class: " + weapon.getWeaponClass());
    }

}
