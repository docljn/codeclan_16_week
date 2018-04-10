import java.util.ArrayList;

public class Ui {

    public void showResults(ArrayList<Player> players){

        for(int i = 0; i<50; i++){
            System.out.print("*");
        }
        System.out.println();
        for (Player player : players){
            System.out.println("\n" + player.getName() + " has " + player.getHandValue());
        }
        System.out.println();
        pause();
    }

    public void showDealtCard(ArrayList<Player> players){
        for (Player player : players) {
            for (Card card: player.getHand().getCards()) {
                System.out.println(player.getName() + " has the " + card.prettyName());
            }
            System.out.println();
            pause();
        }
    }

    public void showWinner(Player winner){
        if (!winner.equals(null)){
        System.out.println(winner.getName() + " wins.");
        } else {
            System.out.println("It's a draw");
        }
        goodbye();
    }

    public void goodbye() {
        System.out.println("\nSee ya later alligator!");
        System.exit(1);

    }


    public void pause(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
