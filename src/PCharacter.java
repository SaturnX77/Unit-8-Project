import java.util.ArrayList;

public class PCharacter {
    double baseHealth;
    double baseAttack;
    double baseDefense;
    double baseDexterity;
    double baseIntelligence;
    double baseMana;
    double baseLuck;
    double currentHealth;
    int coins = 0;

    ArrayList<Item> inventory = new ArrayList<>();

    public PCharacter(){
        inventory.add(null);
        inventory.add(null);
        inventory.add(null);
       // inventory.add(null);
    }
    public void setStats(double baseHealth,double baseAttack,double baseDefense,double baseDexterity,double baseIntelligence,double baseMana,double baseLuck){
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseLuck = baseLuck;
        this.baseHealth = baseHealth;
        this.baseDexterity = baseDexterity;
        this.baseMana = baseMana;
        this.baseIntelligence = baseIntelligence;
        currentHealth = getEffectiveHealth();
    }
    //slot 0 is attack, slot 1 is defense, slot 2 is dexterity, slot 3 is luck, slot 4 is health in stats, slot 5 is intelligence, slot 6 is mana
    public ArrayList<Double> getEffectiveStats(){
        ArrayList<Double> stats = new ArrayList<>();
        stats.add(baseAttack);
        stats.add(baseDefense);
        stats.add(baseDexterity);
        stats.add(baseLuck);
        stats.add(baseHealth);
        stats.add(baseIntelligence);
        stats.add(baseMana);
        for(Item item : inventory){
            if(item instanceof Weapon){
                stats.set(0, stats.get(0) + ((Weapon) item).getAttack());
                stats.set(2, stats.get(2) * ((Weapon) item).getDexScalar());
            } else if(item instanceof Armor){
                stats.set(1, stats.get(1) + ((Armor) item).getDefense());
                stats.set(2, stats.get(2) * ((Armor) item).getDexterityScalar());
            } else if(item instanceof Artifact){
                stats.set(0, stats.get(0) + ((Artifact) item).getAttack());
                stats.set(0, stats.get(0) * ((Artifact) item).getAttackScalar());
                stats.set(1, stats.get(1) + ((Artifact) item).getDefense());
                stats.set(1, stats.get(1) * ((Artifact) item).getDefenseScalar());
                stats.set(2, stats.get(2) + ((Artifact) item).getDexterity());
                stats.set(2, stats.get(2) * ((Artifact) item).getDexterityScalar());
                stats.set(3, stats.get(3) + ((Artifact) item).getLuck());
                stats.set(3, stats.get(3) * ((Artifact) item).getLuckScalar());
                stats.set(4, stats.get(4) + ((Artifact) item).getHealth());
                stats.set(4, stats.get(4) * ((Artifact) item).getHealthScalar());
                stats.set(5, stats.get(5) + ((Artifact) item).getIntelligence());
                stats.set(6, stats.get(6) + ((Artifact) item).getMana());
                stats.set(6, stats.get(6) * ((Artifact) item).getManaScalar());
            }

        }
        return stats;
    }
    public double getEffectiveAttack(){
        return getEffectiveStats().get(0);
    }
    public double getEffectiveDefense(){
        return getEffectiveStats().get(1);
    }
    public double getEffectiveDex(){
        return getEffectiveStats().get(2);
    }
    public double getEffectiveLuck(){
        return getEffectiveStats().get(3);
    }
    public double getEffectiveInt(){
        return getEffectiveStats().get(5);
    }
    public double getEffectiveMana(){
        return getEffectiveStats().get(6);
    }
    public double getEffectiveHealth(){
        return getEffectiveStats().get(4);
    }
    public void subtractHealth(double number){
        currentHealth -= number;
    }
    public void subtractHealthStory(double number){
        currentHealth -= number;
        if(currentHealth < 0){
            ProgressionManager.death();
        }
    }

    public void printBaseStats(){
        //ArrayList<Double> temp = getEffectiveStats();
        System.out.println("Health: " + baseHealth);
        System.out.println("Attack: " + baseAttack);
        System.out.println("Defense: " + baseDefense);
        System.out.println("Dexterity: " + baseDexterity);
        System.out.println("Intelligence: " + baseIntelligence);
        System.out.println("Mana: " + baseMana);
        System.out.println("Luck: " + baseLuck);
    }
    public void printEffectiveStats(){
        System.out.println("\nEffective stats:");
        System.out.println("Current health: " + currentHealth);
        System.out.println("Max Health: " + getEffectiveHealth());
        System.out.println("Attack: " + getEffectiveAttack());
        System.out.println("Defense: " + getEffectiveDefense());
        System.out.println("Dexterity: " + getEffectiveDex());
        System.out.println("Intelligence: " + getEffectiveInt());
        System.out.println("Mana: " + getEffectiveMana());
        System.out.println("Luck: " + getEffectiveLuck());
    }

    //weapon is slot 0 armor is slot 1
    public void viewInventory(){
        System.out.println("\n---- Your Inventory ----");
        System.out.println("\nCoins: " + coins);
        Weapon temp = (Weapon) inventory.get(0);
        temp.printWeaponStats();
        Armor temp2 = (Armor) inventory.get(1);
        temp2.printArmorStats();
        if(inventory.get(2) != null){
            Artifact temp3 = (Artifact) inventory.get(2);
            temp3.printArtifactStats();
        }
    }

    public Weapon getWeapon(){
        return (Weapon) inventory.get(0);
    }
    public void rest(){
        //heals you back to full hp
        System.out.println("You have healed " + (getEffectiveHealth() - currentHealth) + " health");
        currentHealth = getEffectiveHealth();
    }
    public void combatRest(){
        //heals you 30% uses 1 turns
        double temp = currentHealth;
        currentHealth += baseHealth * 0.3;
        if(currentHealth > getEffectiveHealth()){
            currentHealth = getEffectiveHealth();
            System.out.println("You have healed " + (getEffectiveHealth() - temp) + " health");
        } else {
            System.out.println("You have healed " +  (baseHealth * 0.3) + " health");
        }
    }

    public void runAway(NPC enemy){
        int randomNum = NumberProcessor.getRandom(0,100);
        double compare = NumberProcessor.getRandom(0,50) * (1+ baseLuck/100) * (1+ getEffectiveDex()/100);
        if(compare > randomNum){
            System.out.println("You have successfully left combat");
            ProgressionManager.inCombat = false;
            ProgressionManager.turnManager();
        } else {
            System.out.println("You have failed to escape");
            UserInteraction.attackCharacter(enemy);
            ProgressionManager.turnManager(enemy);
        }
    }
    public boolean isDead(){
        return currentHealth < 0;
    }
    public void respawn(){
        currentHealth = baseHealth;
        coins = 0;
    }

}
