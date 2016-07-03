import java.util.Random;

/**
 * Class implements Random strategy.
 */
public class RandomPlayer extends Player {
    private Random random = new Random();
    private int max = GameElement.values().length;

    protected GameElement next() {
        int next = random.nextInt(max);
        return GameElement.values()[next];
    }
}