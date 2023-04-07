public class NPC {
    double health = 0.0;
    double attack = 0.0;
    double defense = 0.0;
    double dexterity = 0.0;
    WorldGenerator.WorldType worldType;
    public enum enemyType {
        //CAVE
        BASILISK(1.1,1.2,0.8,0.9),
        BEHIR(1.4,1.3,1.2,0.5),
        BEHOLDER(0.5,0.8,0.6,1.7),
        UNDEAD(0.6,1.3,0.4,0.8), //ALSO IN ANCIENT RUINS
        GIANT_BAT(1.0,1.3,0.6,1.4),
        DRIDER(0.8,1.5,0.8,1.2),
        //PLAIN
        TREASURE_HUNTERS(1.0,1.0,1.0,1.0), //ALSO IN ROADS
        BANDITS(0.8,1.2,1.0,1.1), // ALSO IN ROADS
        SLIME(0.7,0.7,1.4,0.7),
        UNICORN(1.4,0.5,1.2,1.3),
        GIANT_BOAR(1.4,1.2,0.7,0.5),
        //ROAD
        MERCENARIES(1.0,1.1,0.7,1.2),
        //FOREST
        BANSHEE(0.8,1.1,0.7,1.3),
        PIXIE(0.7,1.3,0.8,1.2),
        ETTERCAP(1.4,1.4,1.4,0.2),
        WEREWOLF(1.2,1.2,0.8,0.8),
        WILL_O_WISP(0.4,1.5,0.4,1.5),
        TREANT(1.7,0.5,1.5,0.1),
        DIRE_WOLF(0.8,1.2,0.8,1.2),
        //ATLANTIS
        CHUUL(0.7,0.7,1.2,1.0),
        KRAKEN(2.0,2.0,0.2,0.5),
        KUO_TOA(1.0,1.0,0.8,1.0),
        MERFOLK(1.0,1.2,0.8,1.2),
        MERROW(1.0,0.8,0.8,1.0),
        //CASTLE
        DRAGON(5.0,5.0,5.0,0.1);
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
