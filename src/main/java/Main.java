public class Main {
    public static void main(String[] args) {
        Player player1 = new RandomPlayer();
        Player player2 = new RockPlayer();
        Game game = new Game(new Referee(), player1, player2);

        MatchResult matchResult = game.match(100);

        System.out.println("=========================");
        System.out.println(player1);
        System.out.println("-------------------------");
        System.out.println(matchResult.getResultByPlayer(player1));
        System.out.println("=========================");
        System.out.println(player2);
        System.out.println("-------------------------");
        System.out.println(matchResult.getResultByPlayer(player2));
    }
}