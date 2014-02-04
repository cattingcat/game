import java.util.LinkedList;
import java.util.List;

public class Deck {
    LinkedList<Card> cards;


    {
        cards = new LinkedList<Card>();
    }

    public void shuffleDeck(){

    }
    public Card GetCard(){
        return cards.peek();
    }
}