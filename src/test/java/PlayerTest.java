import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class PlayerTest<P extends Player> {

    abstract P getPlayer();

    @Test
    public void testOfLastElement() {
        Player player = getPlayer();
        Assert.assertNull(player.getLast());

        GameElement element = player.play();
        Assert.assertEquals(element, player.getLast());
    }
}