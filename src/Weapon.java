public class Weapon extends Item{
    double attack = 0.0;
    public static enum weaponClass {
        AXE(0.7),
        STAFF(0.7),
        BOW(1.0),
        SWORD(1.1),
        GRIMOIRE(1.2),
        DAGGER(1.4);
        final double dexScalar;

        weaponClass(double dexScalar) {
            this.dexScalar = dexScalar;
        }
    }
    weaponClass weaponClass;
    public Weapon(){
        super();
    }

    public double getAttack() {
        return attack;
    }
//    public static double getDexScalar(){
//        return ;
//    }
}
