import java.util.Random;

public class RandomPlayer implements IPlayer {
    private Random random = new Random();
    private int max = GameElement.values().length;

    public GameElement play() {
        int next = random.nextInt(max);
        return GameElement.values()[next];
    }
}