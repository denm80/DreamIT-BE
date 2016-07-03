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
    }

    @Test
    public void testOfRound() {
        Referee referee = new Referee();
        final Player player1 = new MockPlayer(GameElement.ROCK, GameElement.ROCK, GameElement.ROCK,
                GameElement.PAPER, GameElement.PAPER, GameElement.PAPER,
                GameElement.SCISSORS, GameElement.SCISSORS, GameElement.SCISSORS);

        final Player player2 = new MockPlayer(GameElement.ROCK, GameElement.PAPER, GameElement.SCISSORS,
                GameElement.ROCK, GameElement.PAPER, GameElement.SCISSORS,
                GameElement.ROCK, GameElement.PAPER, GameElement.SCISSORS);

        Player[] results = new Player[]{
                null, player2, player1,
                player1, null, player2,
                player2, player1, null
        };


        Game game = new Game(referee, player1, player2);
        Arrays.stream(results).forEach(r -> Assert.assertEquals(r, game.round()));
    }
}
