public abstract class Item {
    public static enum Rarity {
        COMMON(100.0, 40),
        UNCOMMON(250.0,40),
        RARE(500.0, 40),
        VERY_RARE(1000.0, 40),
        LEGENDARY(2500.0, 30),
        MYTHIC(7500.0,30);
        final double baseValue;
        final double valueScalar;

        Rarity(double baseValue, double valueScalar) {
            this.baseValue = baseValue;
            this.valueScalar = valueScalar;
        }

    }
    Rarity rarity;
    int value;
    double dexterityScalar = 1.0;
    public Item(){
//        setRarity(PCharacter.get);
//        setValue(rarity);
    }

    private void setRarity(int luck) {
        Rarity temp;
        int randomNum = NumberProcessor.getRandom(0,101);
        randomNum = randomNum*(1+ (luck/100));
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
    public Rarity getRarity() {
        return rarity;
    }

    private void setValue(Rarity rarity) {
        //if(Rarity.c)
        switch (rarity){
            case COMMON: value = (int)(100.0 / (NumberProcessor.getRandom(40,100)/100));
                break;
            case UNCOMMON: value = (int)(250.0 / (NumberProcessor.getRandom(40,100)/100));
                break;
            case RARE: value = (int)(500.0 / (NumberProcessor.getRandom(40,100)/100));
                break;
            case VERY_RARE: value = (int)(1000.0 / (NumberProcessor.getRandom(40,100)/100));
                break;
            case LEGENDARY: value = (int)(2500.0 / (NumberProcessor.getRandom(30,100)/100));
                break;
            case MYTHIC: value = (int)(7500.0 / (NumberProcessor.getRandom(30,100)/100));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + rarity);
        }
    }
    public int getValue() {
        return value;
    }
}
