import java.util.Random;

public class Dice {
    
    int value = 1;

    public void Roll() {
        Random rand = new Random();
        value = (rand.nextInt(1000) % 6) + 1;
        return;
    }
}
