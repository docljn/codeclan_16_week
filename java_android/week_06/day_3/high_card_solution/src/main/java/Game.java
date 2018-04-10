import java.util.ArrayList;

public class Game {
    private Deck deck;
    private ArrayList<Player> players;
    private Ui ui;

    public Game(Ui ui, Deck deck, ArrayList<Player> players) {
        this.deck = deck;
        this.players = players;
        this.ui = ui;
    }


    public void play() {
        deal();
        ui.showDealtCard(players);
        Player winner = checkWinner();
        ui.showResults(players);
        ui.showWinner(winner);

    }


    public void deal(){
        for (Player player : players){
            for(int i = 0; i<2; i++) {
                player.addCardToHand(deck.getCard());
            }
        }
    }

    public Player checkWinner(){
        Player player1 = players.get(0);
        Player player2 = players.get(1);
        if (player1.getHandValue() == player2.getHandValue()){
            return null;
        } else {
            return player1.getHandValue() > player2.getHandValue() ?  player1 :  player2;
        }

    }
}
