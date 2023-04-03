public class Item {

    String rarity;
    int value;
    public Item(int characterLuck){
        setRarity(characterLuck);
        setValue(rarity);
    }

    private void setRarity(int luck) {
        String temp;
        int randomNum = NumberProcessor.getRandom(0,101);
        randomNum = randomNum*(luck/100);
        if(randomNum <= 30){
            temp = "Common";
        } else if(randomNum <= 55){
            temp = "Uncommon";
        } else if(randomNum <= 75){
            temp = "Rare";
        } else if(randomNum <= 90){
            temp = "Very Rare";
        } else if(randomNum <= 98){
            temp = "Legendary";
        } else {
            temp = "Artifact";
        }
        rarity = temp;
    }
    public String getRarity() {
        return rarity;
    }

    private void setValue(String rarity) {
        switch (rarity){
            case "Common" : value = (int)(100.0 / (NumberProcessor.getRandom(40,100)/100));
                break;
            case "Uncommon" : value = (int)(250.0 / (NumberProcessor.getRandom(40,100)/100));
                break;
            case "Rare" : value = (int)(500.0 / (NumberProcessor.getRandom(40,100)/100));
                break;
            case "Very Rare" : value = (int)(1000.0 / (NumberProcessor.getRandom(40,100)/100));
                break;
            case "Legendary" : value = (int)(2500.0 / (NumberProcessor.getRandom(30,100)/100));
                break;
            case "Artifact" : value = (int)(7500.0 / (NumberProcessor.getRandom(30,100)/100));

        }
    }
    public int getValue() {
        return value;
    }
}
