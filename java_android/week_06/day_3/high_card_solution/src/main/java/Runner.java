import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {

        Player player1 = new Player("Player 1", new Hand());
        Player player2 = new Player("Player 2", new Hand());
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        Deck deck = new Deck();
        Ui ui = new Ui();
        Game game = new Game(ui, deck, players);
        game.play();
    }

}
