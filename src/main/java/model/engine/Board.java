package model.engine;

import model.Programm;
import model.Test;
import model.cards_creature.FieldCreature;
import model.cards_templates.Card;
import model.cards_templates.Creature;
import model.cards_templates.Effect;
import model.engine.events.CardPlayedEvent;
import model.engine.game_objects.*;

import java.util.Map;

public class Board {
    private boolean myTurn = false;
    Field self;
    Field opponent;
    static final int playersCount = 2;

    EffectsFactory effectsFactory;

    private CardPlayedEvent cardPlayed = new CardPlayedEvent(this);



    static final int rowNum = 5;
    static final int columnNum = 3;
    private static final int idolBaseHealth = 10;

    {
        //TODO delete Test initializations
            self = new Field(Test.getTestDeck(), new Hand(), initializeIdols(), new Grid(rowNum, columnNum,this));
            opponent = new Field(Test.getTestDeck(), new Hand(), initializeIdols(), new Grid(rowNum, columnNum,this));
        //~TODO
        effectsFactory = new EffectsFactory();
    }

    public String getStatus() {
        StringBuilder result = new StringBuilder();
        result.append("Status:\n");
        result.append("Now Field's "+ 1 +" turn \n");
        result.append(currentPlayer());
        return result.toString();
    }




    public void playCreature(Creature cc, int row, int column) {
        FieldCreature fc = new FieldCreature(cc, null);
        if (getMyField().getHex(row, column) == null) {
            getMyField().setHex(fc, row, column);
        }
    }


    public boolean playCard(int CardNumber) {
        Card playCard = getMyHand().getCard(CardNumber);
        if (playCard instanceof Creature) {
            int[] coords = new int[2];
            Programm.requestHex(coords);
            playCreature((Creature) playCard, coords[0], coords[1]);
            playCard.getEffect().playEffect(this,null);
            cardPlayed.notifyAll(playCard,coords[0], coords[1]);
            return true;
        }

        return false;
    }

    ///Начальная инициализация идолов здоровьем 10
    private int[] initializeIdols() {

        int[] result = new int[rowNum];
        for (int i = 0; i < result.length; i++) {
            result[i] = idolBaseHealth;
        }
        return result;
    }

    private Hand getMyHand() {
        return currentPlayer().getHand();
    }

    private Grid getMyField() {
        return currentPlayer().getGridSide();
    }

    public Field currentPlayer(){
        return (myTurn)?self:opponent;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append(self.getGridSide());


        sb.append("\n");
        sb.append("\n");
        sb.append("Поле второго игрока");
        sb.append("\n");

        sb.append(opponent.getGridSide());


        return sb.toString();
    }

    public void beginTurn() {
        currentPlayer().takeTopCard();
    }




    public void endTurn() {
        myTurn = !myTurn;
    }

    public CardPlayedEvent getCardPlayed() {
        return cardPlayed;
    }

}
