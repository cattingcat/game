package model.cards_templates;

import model.engine.Board;
import model.engine.FieldPosition;

public abstract class Card {
    private String name;
    private int manaCost;
    private Effect effect;


    public Card(String name,int manaCost) {
        this.name = name;
        this.manaCost= manaCost;
    }

    protected Card(String name, int manaCost, Effect effect) {
        this.name = name;
        this.manaCost = manaCost;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public int getManaCost() {
        return manaCost;
    }

    //TODO descriptions, images and other


    public Effect getEffect() {
        return effect;
    }

    public abstract void invoke(Board field, FieldPosition pos);


}
