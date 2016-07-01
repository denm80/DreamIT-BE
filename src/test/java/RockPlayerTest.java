import org.junit.Assert;
import org.junit.Test;

public class RockPlayerTest {
    private static final int COUNT_ITERATION = 100;

    @Test
    public void testOfPredictableRock() {
        IPlayer player = new RockPlayer();

        for (int i = 0; i < COUNT_ITERATION; i++) {
            Assert.assertEquals(player.play(), GameElement.ROCK);
        }
    }
}