import org.junit.Assert;
import org.junit.Test;

public class RefereeTest {

    @Test
    public void testOfGameElementsInteract() {
        Referee referee = new Referee();

        Assert.assertEquals(referee.judje(GameElement.ROCK, GameElement.ROCK), 0);
        Assert.assertEquals(referee.judje(GameElement.PAPER, GameElement.PAPER), 0);
        Assert.assertEquals(referee.judje(GameElement.SCISSORS, GameElement.SCISSORS), 0);

        Assert.assertEquals(referee.judje(GameElement.ROCK, GameElement.PAPER), -1);
        Assert.assertEquals(referee.judje(GameElement.PAPER, GameElement.SCISSORS), -1);
        Assert.assertEquals(referee.judje(GameElement.SCISSORS, GameElement.ROCK), -1);

        Assert.assertEquals(referee.judje(GameElement.ROCK, GameElement.SCISSORS), 1);
        Assert.assertEquals(referee.judje(GameElement.PAPER, GameElement.ROCK), 1);
        Assert.assertEquals(referee.judje(GameElement.SCISSORS, GameElement.PAPER), 1);
    }
}
