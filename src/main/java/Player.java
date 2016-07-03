/**
 * This abstract class provides base for implementation strategies for game rock-paper-scissors.
 * All subclasses have to implement only one method {@link #next()} for choosing
 * one of possible game element from {@link GameElement}
 */
public abstract class Player {
    private GameElement last;


    /**
     * Does next choice of Player.
     * @return choice of Player for new round
     */
    public GameElement play() {
        last = next();
        return last;
    }

    /**
     * Returns last choice of Player.
     * @return last choice of Player
     */
    public final GameElement getLast() {
        return last;
    }

    protected abstract GameElement next();

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}