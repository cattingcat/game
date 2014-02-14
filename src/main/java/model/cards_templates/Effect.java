package model.cards_templates;
import model.cards_creature.FieldCreature;

public abstract class Effect {
    private boolean hasFocus;

    public abstract void playEffect(FieldCreature target);

    public boolean isHasFocus() {
        return hasFocus;
    }
}
