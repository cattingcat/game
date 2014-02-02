import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;


    {
            cards= new ArrayList<Card>();
    }
    public Card getCard(int CardNumber){
        return cards.get(CardNumber);
    }

}
