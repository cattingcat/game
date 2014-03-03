package model.engine.player;

/**
 * Created by Константин on 27.02.14.
 */
public class Player {
    Deck deck;
    Hand hand;
    int[] idols;
    Field fieldSide;

    public Player(Deck deck, Hand hand, int[] idols, Field fieldSide) {
        this.deck = deck;
        this.hand = hand;
        this.idols = idols;
        this.fieldSide = fieldSide;
    }

    public void takeTopCard(){
        hand.addCard(deck.getTopCard());
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int[] getIdols() {
        return idols;
    }

    public void setIdols(int[] idols) {
        this.idols = idols;
    }

    public Field getFieldSide() {
        return fieldSide;
    }

    public void setFieldSide(Field fieldSide) {
        this.fieldSide = fieldSide;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("Current Mana "+ getHand().getMana() +" ");
        result.append("Current Hand: \n"+ getHand() +"  ");
        return result.toString();
    }
}
