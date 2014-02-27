package model.engine;

import model.Programm;
import model.cards_creature.FieldCreature;
import model.cards_templates.Card;
import model.cards_templates.Creature;
import model.engine.player.*;

public class GameField {
    private int turn = 0;
    Player players[];
    static final int playersCount = 2;

    static final int rowNum = 5;
    static final int columnNum = 3;
    private static final int idolBaseHealth = 10;
    {
        players = new Player[playersCount];
        for(int i = 0 ;i<playersCount ;i++){
            players[i] = new Player(Deck.getTestDeck(),new Hand(),initializeIdols(),new Field(rowNum,columnNum));
        }
    }

    public void playCreature(Creature cc, int row, int column){
        FieldCreature fc = new FieldCreature(cc,null);
        if (getMyField().getHex(row, column)==null) {
            getMyField().setHex(fc, row, column);
        }

    }


    public boolean playCard(int CardNumber){
       Card playCard = getMyHand().getCard(CardNumber);
        if (playCard instanceof Creature) {
            int[] coords= new int[2];
            Programm.requestHex(coords);
            playCreature((Creature) playCard,coords[0],coords[1]);
            return true;
        }
        return false;
    }

    ///Начальная инициализация идолов здоровьем 10
    private int[] initializeIdols() {

        int [] result = new int [rowNum];
        for(int i = 0;i<result.length;i++){
            result[i] = idolBaseHealth;
        }
        return result;
    }

    private Hand getMyHand(){
        return players[turn].getHand();
    }

    private Field getMyField(){
        return players[turn].getFieldSide();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int k = 0 ;k<playersCount;k++){
            for(int i=0;i<rowNum;i++){
                sb.append("[ ");
                for(int j=0;j<columnNum;j++) {
                    if (players[k].getFieldSide().getHex(i, j) != null) {
                        sb.append(players[k].getFieldSide().getHex(i,j).getAttack()+ "/" +players[k].getFieldSide().getHex(i,j).getHealth()+" ," );
                    } else {
                        sb.append(" X ,");
                    }
                }
            sb.append(" ]");
            sb.append("\n");
            }
            sb.append("\n");
            sb.append("Поле второго игрока");
            sb.append("\n");
        } 
        return sb.toString();
    }

    public void beginTurn(){
        players[turn].takeTopCard();
    }


    public void endTurn(){
        turn = (turn==0)? 1 :0;
    }
}
