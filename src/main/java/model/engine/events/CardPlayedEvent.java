package model.engine.events;

import model.cards_templates.Card;
import model.engine.GameField;

/**
 * Created by Константин on 23.02.14.
 */
public class CardPlayedEvent extends Event<CardPlayedListener>{
    GameField field;

    public CardPlayedEvent(GameField field) {
        this.field = field;
    }

    public void notifyAll(Card c){
        for(CardPlayedListener l : listeners){
            l.playCard(c,field);
        }

    }
}
