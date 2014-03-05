package model.cards_templates;

import model.cards_creature.CreaturesFactory;
import model.cards_creature.FieldCreature;
import model.engine.Board;
import model.engine.FieldPosition;

import java.util.UUID;

public class Creature extends Card{
    private int baseHealth;
    private int baseAttack;
    private int baseTurn;

    public Creature(String name, int manaCost, int baseHealth, int baseAttack, int baseTurn) {
        super(name,manaCost);
        this.baseHealth = baseHealth;
        this.baseAttack = baseAttack;
        this.baseTurn = baseTurn;
    }

    public Creature(String name, int manaCost, int baseHealth, int baseAttack, int baseTurn, Effect effect) {
        super(name,manaCost,effect);
        this.baseHealth = baseHealth;
        this.baseAttack = baseAttack;
        this.baseTurn = baseTurn;

    }


    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBaseTurn() {
        return baseTurn;
    }

    public void setBaseTurn(int baseTurn) {
        this.baseTurn = baseTurn;
    }

    @Override
    public void invoke(Board field, FieldPosition pos) {
        CreaturesFactory factory = CreaturesFactory.getInstance();
        // TODO uuid - id from card database;
        FieldCreature fc = factory.getFieldCreature(UUID.randomUUID());
        // TODO add method ...
        //field.addFieldCreature(fc, pos);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(""+ getName());
        result.append(" Стоимость: "+super.getManaCost());
        result.append(" Атака: "+this.getBaseAttack());
        result.append(" Жизни: "+this.getBaseHealth()+"\n");
        return result.toString();
    }
}
