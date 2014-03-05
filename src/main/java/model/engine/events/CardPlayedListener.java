package model.engine.events;

import model.cards_templates.Card;
import model.engine.Board;

/**
 * Created by Константин on 23.02.14.
 */
public interface CardPlayedListener {
    public void playCard(Card card, Board field ,int row, int column);
}
