public class Weapon extends Item{
    double attack = 0.0;
    public static enum weaponClass {
        CLAYMORE(0.7),
        STAFF(0.7),
        SWORD(1.1),
        GRIMOIRE(1.2),
        SUPER_LIGHT(1.4);
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
