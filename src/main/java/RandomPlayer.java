import java.util.Random;

public class RandomPlayer extends Player {
    private Random random = new Random();
    private int max = GameElement.values().length;

    public GameElement next() {
        int next = random.nextInt(max);
        return GameElement.values()[next];
    }
}