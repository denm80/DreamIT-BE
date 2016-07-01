import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class RandomPlayerTest {
    private static final int COUNT_ITERATION = 100;
    private static final double[] X_CRITERIA_FOR_ALPHA_005 = { //ALPHA = 0.005
            7.87944,
            10.59663,
            12.83816,
            14.86026,
            16.74960,
            18.54758,
            20.27774,
            21.95495,
            23.58935,
            25.18818,
            26.75685,
            28.29952,
            29.81947,
            31.31935,
            32.80132,
            34.26719,
            35.71847,
            37.15645,
            38.58226,
            39.99685,
            41.40106,
            42.79565,
            44.18128,
            45.55851,
            46.92789,
            48.28988,
            49.64492,
            50.99338,
            52.33562,
            53.67196
    };

    @Test
    public void testOfUniformDistribution() {
        IPlayer player = new RandomPlayer();

        Map<GameElement, Integer> results = new HashMap<>();
        Arrays.stream(GameElement.values()).forEach(e -> results.put(e, 0));
        for (int i = 0; i < COUNT_ITERATION; i++) {
            GameElement element = player.play();
            results.put(element, results.get(element) + 1);
        }

        int degreesFreedom = GameElement.values().length;
        double m = COUNT_ITERATION / degreesFreedom;
        double xObservable = results.values().stream().mapToDouble((i) -> Math.pow(i - m, 2) / m).sum();

        Assert.assertTrue(xObservable < X_CRITERIA_FOR_ALPHA_005[degreesFreedom - 1]);
    }
}