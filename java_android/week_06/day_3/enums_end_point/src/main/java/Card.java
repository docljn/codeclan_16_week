public class Card {

    private Suit suit;
    private Rank rank;

    // TASK
    // ADD A RANK ENUM AND USE IT IN THE CARD CLASS
    // (also write a test for it please.... otherwise how do you know it works...)
    public Card(Rank rank, Suit suit) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit(){
        return this.suit;
    }


    public Rank getRank() {
        return this.rank;
    }
}
