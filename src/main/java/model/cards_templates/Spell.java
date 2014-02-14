package model.cards_templates;

import model.engine.FieldPosition;
import model.engine.GameField;

public class Spell extends Card {
    private Effect effect;

    @Override
    public void invoke(GameField field, FieldPosition pos) {
        if(effect.isHasFocus()){

        }
    }
}
