package model.cards_templates;

import model.engine.FieldPosition;
import model.engine.GameField;

public abstract class Card {
    private String name;
    private int manaCost;

    public Card(String name,int manaCost) {
        this.name = name;
        this.manaCost= manaCost;
    }

    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }

    //TODO descriptions, images and other

    public abstract void invoke(GameField field, FieldPosition pos);


}
