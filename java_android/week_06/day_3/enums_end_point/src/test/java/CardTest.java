import static org.junit.Assert.*;
        import org.junit.*;

public class CardTest {

    Card card;

    @Before
    public void before(){
        card = new Card(Rank.ACE, Suit.HEARTS);
    }
    @Test
    public void canGetSuit(){
        assertEquals(Suit.HEARTS, card.getSuit());
    }

    @Test
    public void canGetRank() {
        assertEquals(Rank.ACE, card.getRank());
    }

    @Test
    public void jackValueIs11() {
        card = new Card(Rank.JACK, Suit.CLUBS);
        Rank rank = card.getRank();

        int value = rank.getValue();

        assertEquals(11, value);
    }

    @Test
    public void twoValueis2() {
        assertEquals(2, Rank.TWO.getValue());
    }

    @Test
    public void canGetAllSuits(){

        Suit[] suits = Suit.values();

        Suit[] expected = { Suit.SPADES, Suit.HEARTS, Suit.CLUBS, Suit.DIAMONDS };

        assertEquals(4, suits.length);
        assertArrayEquals(expected ,suits);
    }

//    @Test
//    public void canMisspellSuit() {
//        Card misspelled = new Card(Suit.HEARTSSS);
//        assertEquals(Suit.HEARTSSS, misspelled.getSuit());
//    }
//    @Test
//    public void suitCanBeRandomWord() {
//        Card misspelled = new Card("Craig");
//        assertEquals("Craig", misspelled.getSuit());
//    }
}
