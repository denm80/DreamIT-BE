/**
 * Class implements strategy always {@link GameElement#ROCK}.
 */
public class RockPlayer extends Player {
    protected GameElement next() {
        return GameElement.ROCK;
    }
}