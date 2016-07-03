import org.junit.Assert;
import org.junit.Test;

public class MatchResultTest {
    Player player1 = new RandomPlayer();
    Player player2 = new RockPlayer();

    public static void testOfPlayerResult(PlayerResult playerResult, long wins, long defeats, long draws) {
        Assert.assertEquals(wins, playerResult.getWins());
        Assert.assertEquals(defeats, playerResult.getDefeats());
        Assert.assertEquals(draws, playerResult.getDraws());
    }

    @Test
    public void testOfOnly1Draws() {
        MatchResult matchResult = new MatchResult(new Player[]{null});
        testOfPlayerResult(matchResult.getResultByPlayer(player1), 0, 0, 1);
        testOfPlayerResult(matchResult.getResultByPlayer(player2), 0, 0, 1);
    }

    @Test
    public void testOfWithoutDraws() {
        MatchResult matchResult = new MatchResult(new Player[]{player1, player1, player2});
        testOfPlayerResult(matchResult.getResultByPlayer(player1), 2, 1, 0);
        testOfPlayerResult(matchResult.getResultByPlayer(player2), 1, 2, 0);
    }

    @Test
    public void testOfEmptyWinnerArray() {
        MatchResult matchResult = new MatchResult(new Player[]{});
        testOfPlayerResult(matchResult.getResultByPlayer(player1), 0, 0, 0);
        testOfPlayerResult(matchResult.getResultByPlayer(player2), 0, 0, 0);
    }
}
