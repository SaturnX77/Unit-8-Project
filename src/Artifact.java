public class Artifact extends Item{
    double luck;
    double luckScalar;
    double dexterity;
    double dexterityScalar;
    double health;
    double healthScalar;
    double attack;
    double attackScalar;
    double defense;
    double defenseScalar;
    double intelligence;
    double mana;
    double manaScalar;
    public Artifact(){
        rarity = Rarity.LEGENDARY;
        luck = NumberProcessor.getRandom(0,30);
        luckScalar = NumberProcessor.getRandom(1.0,1.5);
        dexterity = NumberProcessor.getRandom(0,30);
        dexterityScalar = NumberProcessor.getRandom(1.0,1.5);
        health = NumberProcessor.getRandom(0,100);
        healthScalar = NumberProcessor.getRandom(1.0,1.5);
        attack = NumberProcessor.getRandom(0,100);
        attackScalar = NumberProcessor.getRandom(1.0,1.5);
        defense = NumberProcessor.getRandom(0,100);
        defenseScalar = NumberProcessor.getRandom(1.0,1.5);
        intelligence = NumberProcessor.getRandom(0,30);
        mana = NumberProcessor.getRandom(0,30);
        manaScalar = NumberProcessor.getRandom(1.0,1.5);
      //  printArtifactStats();
    }

    public double getLuck() {
        return luck;
    }

    public double getLuckScalar() {
        return luckScalar;
    }

    public double getDexterity() {
        return dexterity;
    }

    public double getDexterityScalar() {
        return dexterityScalar;
    }

    public double getHealth() {
        return health;
    }

    public double getHealthScalar() {
        return healthScalar;
    }

    public double getAttack() {
        return attack;
    }

    public double getAttackScalar() {
        return attackScalar;
    }

    public double getDefense() {
        return defense;
    }

    public double getDefenseScalar() {
        return defenseScalar;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public double getMana() {
        return mana;
    }

    public double getManaScalar() {
        return manaScalar;
    }

    public void printArtifactStats(){
        System.out.println("\nArtifact stats:");
        System.out.println("Rarity: " + rarity);
        System.out.println("Health: " + health);
        System.out.println("Health Scalar: " + healthScalar);
        System.out.println("Attack: " + attack);
        System.out.println("Attack Scalar: " + attackScalar);
        System.out.println("Defense: " + defense);
        System.out.println("Defense Scalar: " + defenseScalar);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Dexterity Scalar: " + dexterityScalar);
        System.out.println("Luck:" + luck);
        System.out.println("Luck Scalar: " + luckScalar);
        System.out.println("Intelligence: " + intelligence);
        System.out.println("Mana: " + mana);
        System.out.println("Mana Scalar: " + manaScalar);
    }

}
