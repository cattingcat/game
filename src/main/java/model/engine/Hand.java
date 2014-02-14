package model.engine;

import model.cards_templates.Card;

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
    public void addCard(Card c){
        cards.add(c);
    }

}
