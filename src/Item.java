import java.util.ArrayList;

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
    int value = 0;
    double dexterityScalar = 1.0;

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
    public Rarity getRarity() {
        return rarity;
    }

    public void setValue(int value){
        this.value = value;
    }
    public void setValue(Rarity rarity) {
        //if(Rarity.c)
        switch (rarity){
            case COMMON:
                //int         double                           int                          double
                setValue((int)(100.0 / ((NumberProcessor.getRandom(40,100))/100.0)));
                break;
            case UNCOMMON:
                setValue((int)(250.0 / ((NumberProcessor.getRandom(40,100))/100.0)));
                break;
            case RARE:
                setValue((int)(500.0 / ((NumberProcessor.getRandom(40,100))/100.0)));
                break;
            case VERY_RARE:
                setValue((int)(1000.0 / ((NumberProcessor.getRandom(40,100))/100.0)));
                break;
            case LEGENDARY:
                setValue((int)(2500.0 * ((NumberProcessor.getRandom(30,100))/100.0)));
                break;
            case MYTHIC:
                setValue((int)(7500.0 / ((NumberProcessor.getRandom(30,100))/100.0)));
                break;
        }
    }

    public int getValue() {
        return value;
    }
}
