public class NPC {
    double health = 0.0;
    double attack = 0.0;
    double defense = 0.0;
    double dexterity = 0.0;
    int value = 0;
    Item tradeItem;
    WorldGenerator.WorldType worldType;
    public enum Rarity {
        COMMON(100.0, 40, 50,75),
        UNCOMMON(250.0,40, 75, 90),
        RARE(500.0, 40, 90, 105),
        VERY_RARE(1000.0, 40, 105, 120),
        LEGENDARY(2500.0, 30, 150, 200),
        MYTHIC(7500.0,30, 250,300);
        final double baseValue;
        final double valueScalar;
        final double statsScalarLow;
        final double statsScalarHigh;

        Rarity(double baseValue, double valueScalar, int statsScalarLow, int statsScalarHigh) {
            this.statsScalarHigh = statsScalarHigh;
            this.statsScalarLow = statsScalarLow;
            this.baseValue = baseValue;
            this.valueScalar = valueScalar;
        }

    }
    public enum EnemyType {
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

        EnemyType(double healthScalar, double attackScalar, double defenseScalar, double dexScalar) {
            this.healthScalar = healthScalar;
            this.attackScalar = attackScalar;
            this.defenseScalar = defenseScalar;
            this.dexScalar = dexScalar;
        }

    }
    NpcType npcType;
    EnemyType enemyType;
    Rarity rarity;
    public enum NpcType {
        ENEMY,
        MERCHANT,
        NONE;
        NpcType(){

        }
    }
    public NPC(WorldGenerator.WorldType worldType, PCharacter character){
        this.worldType = worldType;
        NpcType temp = NpcType.NONE;
        int randomNum = NumberProcessor.getRandom(0,100);
        double merchantChance = (worldType.merchantChance) * 100;
        double monsterChance = (worldType.monsterChance * 100) + merchantChance;
        if(randomNum <= merchantChance){
            temp = NpcType.MERCHANT;
        } else if (randomNum <= monsterChance) {
            temp = NpcType.ENEMY;
        }
       // temp = null;
        npcType = temp; //switch this back to temp
        int tempNum;
        //System.out.println("NPC type: " + npcType);
        if(npcType.equals(NpcType.ENEMY)){
            switch (worldType){
                case CAVE:
                case STORY_COMBAT_CAVE:
                    tempNum = NumberProcessor.getRandom(0,6);
                    switch (tempNum){
                        case 0:
                            enemyType = EnemyType.BASILISK;
                            break;
                        case 1:
                            enemyType = EnemyType.BEHIR;
                            break;
                        case 2:
                            enemyType = EnemyType.BEHOLDER;
                            break;
                        case 3:
                            enemyType = EnemyType.UNDEAD;
                            break;
                        case 4:
                            enemyType = EnemyType.GIANT_BAT;
                            break;
                        case 5:
                            enemyType = EnemyType.DRIDER;
                            break;
                    }
                    break;
                case PLAIN:
                    tempNum = NumberProcessor.getRandom(0,5);
                    switch (tempNum){
                        case 0:
                            enemyType = EnemyType.TREASURE_HUNTERS;
                            break;
                        case 1:
                            enemyType = EnemyType.BANDITS;
                            break;
                        case 2:
                            enemyType = EnemyType.SLIME;
                            break;
                        case 3:
                            enemyType = EnemyType.UNICORN;
                            break;
                        case 4:
                            enemyType = EnemyType.GIANT_BOAR;
                            break;
                    }
                    break;
                case ROAD:
                    tempNum = NumberProcessor.getRandom(0,3);
                    switch (tempNum){
                        case 0:
                            enemyType = EnemyType.MERCENARIES;
                            break;
                        case 1:
                            enemyType = EnemyType.TREASURE_HUNTERS;
                            break;
                        case 2:
                            enemyType = EnemyType.BANDITS;
                            break;
                    }
                    break;
                case ANCIENT_RUINS:
                    enemyType =  EnemyType.UNDEAD;
                    break;
                case FOREST:
                    tempNum = NumberProcessor.getRandom(0,7);
                    switch (tempNum){
                        case 0:
                            enemyType = EnemyType.BANSHEE;
                            break;
                        case 1:
                            enemyType = EnemyType.PIXIE;
                            break;
                        case 2:
                            enemyType = EnemyType.ETTERCAP;
                            break;
                        case 3:
                            enemyType = EnemyType.WEREWOLF;
                            break;
                        case 4:
                            enemyType = EnemyType.WILL_O_WISP;
                            break;
                        case 5:
                            enemyType = EnemyType.TREANT;
                            break;
                        case 6:
                            enemyType = EnemyType.DIRE_WOLF;
                            break;
                    }
                    break;
                case ATLANTIS:
                    tempNum = NumberProcessor.getRandom(0,5);
                    switch (tempNum){
                        case 0:
                            enemyType = EnemyType.CHUUL;
                            break;
                        case 1:
                            enemyType = EnemyType.KRAKEN;
                            break;
                        case 2:
                            enemyType = EnemyType.KUO_TOA;
                            break;
                        case 3:
                            enemyType = EnemyType.MERFOLK;
                            break;
                        case 4:
                            enemyType = EnemyType.MERROW;
                            break;
                    }
                    break;
                case CASTLE:
                    enemyType = EnemyType.DRAGON;
                    break;
            }
            setRarity(character.getEffectiveLuck());
            if(enemyType == EnemyType.DRAGON){
                rarity = Rarity.MYTHIC;
            }
            value = (int) (rarity.baseValue / ((NumberProcessor.getRandom(rarity.valueScalar,100))/100.0));
            attack = (NumberProcessor.getRandom(rarity.statsScalarLow,rarity.statsScalarHigh)) * enemyType.attackScalar;
            defense = (NumberProcessor.getRandom(rarity.statsScalarLow,rarity.statsScalarHigh)) * enemyType.defenseScalar;
            dexterity = (NumberProcessor.getRandom(20,100)) * enemyType.dexScalar;
            health = (NumberProcessor.getRandom(rarity.statsScalarLow,rarity.statsScalarHigh)) * enemyType.healthScalar;
            printStats();
        } else if(npcType.equals(NpcType.MERCHANT)){
            //System.out.println("merchant wip");
            //add in artifact option later
            ProgressionManager.isTrading = true;
            int rand = NumberProcessor.getRandom(0,2);
            switch (rand){
                case 0:
                    tradeItem = new Armor(character);
                    break;
                case 1:
                    tradeItem = new Weapon(character);
                    break;
            }
        } else {
            System.out.println("You move forward without encountering anything");
        }
    }
    public void subtractHealth(double number){
        health -= number;
    }
    public void setRarity(double luck) {
        Rarity temp;
        double randomNum = NumberProcessor.getRandom(0,101);
        randomNum = randomNum*(1+ (luck/300));
        if(randomNum <= 30){
            temp = Rarity.COMMON;
        } else if(randomNum <= 55){
            temp = Rarity.UNCOMMON;
        } else if(randomNum <= 75){
            temp = Rarity.RARE;
        } else if(randomNum <= 90){
            temp = Rarity.VERY_RARE;
        } else if(randomNum <= 98){
            temp = Rarity.LEGENDARY;
        } else {
            temp = Rarity.MYTHIC;
        }
        rarity = temp;
    }

    public void printStats(){
        System.out.println("\nEnemy Type: " + enemyType);
        System.out.println("Enemy Rarity: " + rarity);
        System.out.println("Health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Defense: " + defense);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Coins for defeat: " + value);
    }
    public void viewTradeItem(){
        if(tradeItem instanceof Weapon){
            ((Weapon) tradeItem).printWeaponStats();
        } else if(tradeItem instanceof Armor){
            ((Armor) tradeItem).printArmorStats();
        }
    }
}
