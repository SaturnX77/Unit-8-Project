public class NPC {
    double health = 0.0;
    double attack = 0.0;
    double defense = 0.0;
    double dexterity = 0.0;
    WorldGenerator.WorldType worldType;
    public enum enemyType {
//        CAVE(0.9,0.0,0),
//        PLAIN(0.5,0.1,0),
//        ROAD(0.2,0.2,0),
//        ANCIENT_RUINS(0.5,0.0,0),
//        FOREST(0.6,0.1,0),
//        ATLANTIS(0.7,0.0,0),
//        CASTLE(0,0,1);
        final double healthScalar;
        final double attackScalar;
        final double defenseScalar;
        final double dexScalar;

        enemyType(double healthScalar, double attackScalar, double defenseScalar, double dexScalar) {
            this.healthScalar = healthScalar;
            this.attackScalar = attackScalar;
            this.defenseScalar = defenseScalar;
            this.dexScalar = dexScalar;
        }

    }
    public enum npcType {
        ENEMY,
        MERCHANT;
    }
    public NPC(WorldGenerator.WorldType worldType){
        this.worldType = worldType;
    }








}
