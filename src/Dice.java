import java.util.Random;

public class Dice {
    
    public int value = 0;

    public void Roll() {
        Random rand = new Random();
        value = (rand.nextInt(1000) % 6) + 1;
        return;
    }
}
