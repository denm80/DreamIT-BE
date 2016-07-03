public class Game {
    private Player player1;
    private Player player2;
    private Referee referee;

    public Game(Referee referee, Player player1, Player player2) {
        this.referee = referee;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Player round() {
        int result = referee.judje(player1.play(), player2.play());
        if (result == 0) {
            return null;
        }

        return result > 0 ? player1 : player2;
    }

    public MatchResult match(int rounds) {
        Player[] winners = new Player[rounds];
        for (int i = 0; i < rounds; i++) {
            winners[i] = round();
        }
        return new MatchResult(winners);
    }
}
