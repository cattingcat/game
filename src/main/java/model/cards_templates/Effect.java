package model.cards_templates;
import model.cards_creature.FieldCreature;
import model.engine.Board;

public abstract class Effect {
    private boolean hasFocus;

    public abstract void playEffect(Board board, FieldCreature target);

    public boolean isHasFocus() {
        return hasFocus;
    }
}
