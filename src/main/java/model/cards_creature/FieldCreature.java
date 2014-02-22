package model.cards_creature;

import model.cards_templates.Creature;
import model.cards_templates.Effect;

public class FieldCreature {
    private int health;
    private int attack;
    private int turn;
    private Creature card;
    private Effect effect;


    public FieldCreature(Creature card, Effect effect) {
        this.card = card;
        this.effect = effect;
        this.turn = card.getBaseTurn();
        this.health= card.getBaseHealth();
        this.attack = card.getBaseAttack();
    }
    public FieldCreature() {
        this(new Creature("Useless imp",1,1,1,1),null);
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Creature getCard() {
        return card;
    }

    public void setCard(Creature card) {
        this.card = card;
    }

    public Effect getEffect() {
        return effect;
    }

    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
