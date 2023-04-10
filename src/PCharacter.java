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

    ArrayList<Item> inventory = new ArrayList<>();

    public PCharacter(){
        inventory.add(null);
        inventory.add(null);
        inventory.add(null);
        inventory.add(null);
    }
    public void setStats(double baseHealth,double baseAttack,double baseDefense,double baseDexterity,double baseIntelligence,double baseMana,double baseLuck){
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseLuck = baseLuck;
        this.baseHealth = baseHealth;
        this.baseDexterity = baseDexterity;
        this.baseMana = baseMana;
        this.baseIntelligence = baseIntelligence;
        currentHealth = baseHealth;
    }
    //slot 0 is attack, slot 1 is defense, slot 2 is dexterity, slot 3 is luck, slot 4 is health in stats
    public ArrayList<Double> getEffectiveStats(){
        ArrayList<Double> temp = new ArrayList<>();
        temp.add(null);
        temp.add(null);
        temp.add(null);
        temp.add(null);
        temp.add(null);

        for(Item item : inventory){
            if(item instanceof Weapon){
                temp.set(0, baseAttack + ((Weapon) item).getAttack());
            } else if(item instanceof Armor){
                temp.set(1, baseDefense + ((Armor) item).getDefense());
                temp.set(2, baseDexterity * ((Armor) item).getDexterityScalar());
            } else if(item instanceof Artifact){
                //temp.set(2, baseDexterity * )
            }

        }
        return temp;
    }
    public double getEffectiveAttack(){
        return baseAttack + getEffectiveStats().get(0);
    }
    public double getEffectiveDefense(){
        return baseDefense + getEffectiveStats().get(1);
    }
    public double getEffectiveDex(){
        return baseDexterity + getEffectiveStats().get(2);
    }
    public double getEffectiveLuck(){
        return baseLuck; //+ getEffectiveStats().get(3);
    }
    public double getEffectiveHealth(){
        return currentHealth; //+ getEffectiveStats().get(4);
    }
    public void subtractHealth(double number){
        currentHealth -= number;
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
        //ArrayList<Double> temp = getEffectiveStats();
        System.out.println("\nEffective stats:");
        System.out.println("Health: " + getEffectiveHealth());
        System.out.println("Attack: " + getEffectiveAttack());
        System.out.println("Defense: " + getEffectiveDefense());
        System.out.println("Dexterity: " + getEffectiveDex());
        System.out.println("Intelligence: " + baseIntelligence);
        System.out.println("Mana: " + baseMana);
        System.out.println("Luck: " + baseLuck);
    }
    public void viewInventory(){
        Weapon temp = (Weapon) inventory.get(0);
        temp.printWeaponStats();
        Armor temp2 = (Armor) inventory.get(1);
        temp2.printArmorStats();
    }
    public void rest(){
        //heals you back to full hp
    }
    public void combatRest(){
        //heals you 30% uses 1 turns
    }

}
