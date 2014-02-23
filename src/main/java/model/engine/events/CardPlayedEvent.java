package model.engine.events;

import model.cards_templates.Card;
import model.engine.Field;

/**
 * Created by Константин on 23.02.14.
 */
public class CardPlayedEvent extends Event<CardPlayedListener>{
    Field field;

    public CardPlayedEvent(Field field) {
        this.field = field;
    }

    public void notifyAll(Card c){
        for(CardPlayedListener l : listeners){
            l.playCard(c,field);
        }

    }
}
