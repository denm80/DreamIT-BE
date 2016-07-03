import java.util.HashMap;
import java.util.Map;

/**
 * Class contains rules of game and makes decision about winner in terms of {@link GameElement}
 */
public class Referee {

    private Map<GameElement, GameElement> rules =
            new HashMap<GameElement, GameElement>() {{
                put(GameElement.ROCK, GameElement.SCISSORS);
                put(GameElement.SCISSORS, GameElement.PAPER);
                put(GameElement.PAPER, GameElement.ROCK);
            }};


    /**
     * Compares two {@link GameElement}.
     * @param elements1 - the first comparable element
     * @param elements2 - the second first comparable element
     * @return -1 - if the first element is weaker;
     * 1 - if the first element is stronger;
     * 0 - if the both elements are equals
     */
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
