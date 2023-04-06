import java.util.Random;

public class NumberProcessor {
    public NumberProcessor(){

    }
    public static int getRandom(int lowLimit, int highLimit){
        return (int)(Math.random() * (highLimit - lowLimit)) + lowLimit;
    }
    public static double getRandom(double lowLimit, double highLimit){
        return (Math.random() * (highLimit - lowLimit)) + lowLimit;
    }
}
