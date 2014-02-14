package model.cards_templates;

import model.cards_creature.CreaturesFactory;
import model.cards_creature.FieldCreature;
import model.engine.FieldPosition;
import model.engine.GameField;

import java.util.UUID;

public class Creature extends Card{

    @Override
    public void invoke(GameField field, FieldPosition pos) {
        CreaturesFactory factory = CreaturesFactory.getInstance();
        // TODO uuid - id from card database;
        FieldCreature fc = factory.getFieldCreature(UUID.randomUUID());
        // TODO add method ...
        //field.addFieldCreature(fc, pos);
    }
}
