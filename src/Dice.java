import java.util.Random;

public class Dice {
    
    protected int value;

    public void Roll() {
        Random rand = new Random();
        value = (rand.nextInt(1000) % 6) + 1;
        return;
    }
}
