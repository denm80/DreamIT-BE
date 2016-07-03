import org.apache.commons.collections4.iterators.ArrayIterator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class GameTest {

    public class MockPlayer extends Player {
        private ArrayIterator<GameElement> iterator;

        public MockPlayer(GameElement... elements) {
            this.iterator = new ArrayIterator<GameElement>(elements);
        }

        public GameElement next() {
            if (iterator.hasNext()) {
                return iterator.next();
            } else {
                throw new NoSuchElementException();
            }
        }

        public void reset() {
            iterator.reset();
        }
    }

    private Referee referee = new Referee();

    private MockPlayer player1 = new MockPlayer(GameElement.ROCK, GameElement.ROCK, GameElement.ROCK,
            GameElement.PAPER, GameElement.PAPER, GameElement.PAPER,
            GameElement.SCISSORS, GameElement.SCISSORS, GameElement.SCISSORS);

    private MockPlayer player2 = new MockPlayer(GameElement.ROCK, GameElement.PAPER, GameElement.SCISSORS,
            GameElement.ROCK, GameElement.PAPER, GameElement.SCISSORS,
            GameElement.ROCK, GameElement.PAPER, GameElement.SCISSORS);


    @Test
    public void testOfRound() {
        Player[] results = new Player[]{
                null, player2, player1,
                player1, null, player2,
                player2, player1, null
        };

        player1.reset();
        player2.reset();
        Game game = new Game(referee, player1, player2);

        Arrays.stream(results).forEach(r -> Assert.assertEquals(r, game.round()));
    }

    @Test
    public void testOfMatch() {
        player1.reset();
        player2.reset();
        Game game = new Game(referee, player1, player2);

        MatchResult matchResult = game.match(0);
        MatchResultTest.testOfPlayerResult(matchResult.getResultByPlayer(player1), 0, 0, 0);
        MatchResultTest.testOfPlayerResult(matchResult.getResultByPlayer(player2), 0, 0, 0);

        matchResult = game.match(2);
        MatchResultTest.testOfPlayerResult(matchResult.getResultByPlayer(player1), 0, 1, 1);
        MatchResultTest.testOfPlayerResult(matchResult.getResultByPlayer(player2), 1, 0, 1);

        matchResult = game.match(7);
        MatchResultTest.testOfPlayerResult(matchResult.getResultByPlayer(player1), 3, 2, 2);
        MatchResultTest.testOfPlayerResult(matchResult.getResultByPlayer(player2), 2, 3, 2);
    }
}
