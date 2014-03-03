package model.engine.player;

import model.cards_templates.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;
    private int mana;

    {
        cards= new ArrayList<Card>();
        mana = 0;
    }

    public int getMana() {
        return mana;
    }
    public void incMana() {
        if (mana < 10) {
            mana++;
        }
    }


    public Card getCard(int CardNumber){
        return cards.get(CardNumber);
    }
    public void addCard(Card c){
        cards.add(c);
    }

//    Эта беда для вывода на косоль карт в руке
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int i =0;
        for (Card c : cards) {
            result.append(i++);
            result.append(":");
            result.append(c);
        }
        return result.toString();
    }
}
