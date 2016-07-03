import org.junit.Assert;
import org.junit.Test;

/**
 * It is not very useful and reliable test, because we cannot assure that this player will choose ROCK infinitely.
 * We can check only first N results. For our task N is 100.
*/
public class RockPlayerTest extends PlayerTest {
    private static final int COUNT_ITERATION = 100;

    @Test
    public void testOfPredictableRock() {
        Player player = getPlayer();

        for (int i = 0; i < COUNT_ITERATION; i++) {
            Assert.assertEquals(player.play(), GameElement.ROCK);
        }
    }

    @Override
    Player getPlayer() {
        return new RockPlayer();
    }
}