import java.util.HashMap;
import java.util.Map;

public class Referee {

    //immutable map
    private Map<GameElement, GameElement> rules =
            new HashMap<GameElement, GameElement>() {{
                put(GameElement.ROCK, GameElement.SCISSORS);
                put(GameElement.SCISSORS, GameElement.PAPER);
                put(GameElement.PAPER, GameElement.ROCK);
            }};

    public int judje(GameElement elements1, GameElement elements2) {
        if (elements1.equals(elements2)) {
            return 0;
        }
        if (rules.get(elements1).equals(elements2)) {
            return 1;
        } else {
            return -1;
        }

    }
}
