import java.util.ArrayList;

public class PCharacter {
    double baseHealth;
    double baseAttack;
    double baseDefense;
    double baseDexterity;
    double baseIntelligence;
    double baseMana;
    double baseLuck;

    ArrayList<Item> inventory = new ArrayList<>();

    public PCharacter(){

    }
    public void setStats(double baseHealth,double baseAttack,double baseDefense,double baseDexterity,double baseIntelligence,double baseMana,double baseLuck){
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.baseLuck = baseLuck;
        this.baseHealth = baseHealth;
        this.baseDexterity = baseDexterity;
        this.baseMana = baseMana;
        this.baseIntelligence = baseIntelligence;
    }
    //slot 0 is damage, slot 1 is defense, slot 2 is dexterity, slot 3 is luck, slot 4 is health in stats
    public ArrayList<Double> getEffectiveStats(){
        ArrayList<Double> temp = new ArrayList<>();
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

}
