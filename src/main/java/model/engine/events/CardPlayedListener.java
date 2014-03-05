package model.engine.events;

import model.cards_templates.Card;
import model.engine.GameField;

/**
 * Created by Константин on 23.02.14.
 */
public interface CardPlayedListener {
    public void playCard(Card card, GameField field);
}
