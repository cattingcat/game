package model.engine.game_objects;

/**
 * Created by Константин on 27.02.14.
 */
public class Field {
    Deck deck;
    Hand hand;
    int[] idols;
    Grid gridSide;

    public Field(Deck deck, Hand hand, int[] idols, Grid gridSide) {
        this.deck = deck;
        this.hand = hand;
        this.idols = idols;
        this.gridSide = gridSide;
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

    public Grid getGridSide() {
        return gridSide;
    }

    public void setGridSide(Grid gridSide) {
        this.gridSide = gridSide;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("Current Mana "+ getHand().getMana() +" ");
        result.append("Current Hand: \n"+ getHand() +"  ");
        return result.toString();
    }
}
