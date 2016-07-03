/**
 * Class contains result of match for player
 */
public class PlayerResult {
    private long wins;
    private long draws;
    private long defeats;

    public PlayerResult(long wins, long draws, long defeats) {
        this.wins = wins;
        this.draws = draws;
        this.defeats = defeats;
    }

    public long getWins() {
        return wins;
    }

    public long getDraws() {
        return draws;
    }

    public long getDefeats() {
        return defeats;
    }

    @Override
    public String toString() {
        return String.format("wins=%s\ndraws=%s\ndefeats=%s", wins, draws, defeats);
    }
}
