public abstract class Player {
    private GameElement last;

    public GameElement play() {
        last = next();
        return last;
    }

    public final GameElement getLast() {
        return last;
    }

    protected abstract GameElement next();
}