import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * It is not very useful and reliable test, because we a going to check java.util.Random.
 * But we can check whether behaviour of Player matches the hypothesis of a uniform distribution, at least.
 * According table X^2 of Pearson criteria we have next list X_ CRITERIA_FOR ALPHA_900 of limit
 * for confirm of uniform distribution with 75% probability.
 * X_CRITERIA depends on freedom degrees, as well.  In our case it is third number.
 * In our case it is 0.58437.
 */
public class RandomPlayerTest extends PlayerTest {
    private static final int COUNT_ITERATION = 1000;
    private static final double[] X_CRITERIA_FOR_ALPHA_750 = { //ALPHA = 0.75
            0.10153,
            0.57536,
            1.21253,
            1.92256,
            2.67460,
            3.45460,
            4.25485,
            5.07064,
            5.89883,
            6.73720,
            7.58414,
            8.43842,
            9.29907,
            10.16531,
            11.03654,
            11.91222,
            12.79193,
            13.67529,
            14.56200,
            15.45177,
            16.34438,
            17.23962,
            18.13730,
            19.03725,
            19.93934,
            20.84343,
            21.74940,
            22.65716,
            23.56659,
            24.47761

    };

    @Test
    public void testOfUniformDistribution() {
        Player player = getPlayer();

        Map<GameElement, Integer> results = new HashMap<>();
        Arrays.stream(GameElement.values()).forEach(e -> results.put(e, 0));
        for (int i = 0; i < COUNT_ITERATION; i++) {
            GameElement element = player.play();
            results.put(element, results.get(element) + 1);
        }

        int degreesFreedom = GameElement.values().length;
        double m = COUNT_ITERATION / degreesFreedom;
        double xObservable = results.values().stream().mapToDouble((i) -> Math.pow(i - m, 2) / m).sum();

        Assert.assertTrue(xObservable < X_CRITERIA_FOR_ALPHA_750[degreesFreedom - 1]);
    }

    @Override
    Player getPlayer() {
        return new RandomPlayer();
    }
}