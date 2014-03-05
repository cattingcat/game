package model.cards_templates;

import model.engine.Board;
import model.engine.FieldPosition;

public abstract class Spell extends Card {
    public Spell(String name, int manaCost, Effect effect) {
        super(name, manaCost,effect);
    }
}
