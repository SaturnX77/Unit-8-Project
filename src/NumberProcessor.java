public class NumberProcessor {
    public NumberProcessor(){

    }
    public static int getRandom(int lowLimit, int highLimit){
        return (int)(Math.random() * (highLimit - lowLimit)) + lowLimit;
    }
}
