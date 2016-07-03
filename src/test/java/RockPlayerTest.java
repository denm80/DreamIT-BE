import org.junit.Assert;
import org.junit.Test;

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