package model.engine.events;

import model.cards_templates.Card;
import model.engine.Board;
import model.engine.game_objects.Field;

/**
 * Created by Константин on 23.02.14.
 */
public class CardPlayedEvent extends Event<CardPlayedListener>{
    Board field;

    public CardPlayedEvent(Board field) {
        this.field = field;
    }

    public void notifyAll(Card c,int row, int column){
        for(CardPlayedListener l : listeners){
            l.playCard(c,field,row, column);
        }

    }
}
