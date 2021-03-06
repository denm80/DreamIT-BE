import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class contains results of match and provides {@link PlayerResult} by {@link Player}
 */
public class MatchResult {
    private Player[] winners;
    private Map<Player, PlayerResult> playerResults = new HashMap<>();

    /**
     * @param winners - array of match winners in rounds
     */
    public MatchResult(Player[] winners) {
        this.winners = winners;
        Arrays.stream(winners).distinct().filter(w -> w != null)
                .forEach(p -> playerResults.put(p, buildByPlayer(p)));
    }

    private PlayerResult buildByPlayer(final Player player) {
        long wins = Arrays.stream(winners).filter(player::equals).count();
        long draws = Arrays.stream(winners).filter(i -> i == null).count();
        return new PlayerResult(wins, draws, winners.length - wins - draws);
    }

    /**
     * Returns {@link PlayerResult} by {@link Player}
     * @param player - one of {@link Player} who take a part in game
     * @return {@link PlayerResult} by passed {@link Player}
     */
    public PlayerResult getResultByPlayer(Player player) {
        if (!playerResults.containsKey(player)) {
            playerResults.put(player, buildByPlayer(player));
        }
        return playerResults.get(player);
    }
}
