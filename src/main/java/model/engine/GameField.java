package model.engine;

import model.Programm;
import model.cards_creature.FieldCreature;
import model.cards_templates.Card;
import model.cards_templates.Creature;

public class GameField {
    Field field;
    Hand hand;
    Hand EnemyHand;
    int[]idols;
    int[]enemyIdols;
    Deck deck;

    static final int rowNum = 5;
    static final int columnNum = 3;
    private static final int idolBaseHealth = 10;
    {
        hand = new Hand();
        field = new Field(rowNum,columnNum);
        idols = initializeIdols();
        enemyIdols = initializeIdols();
        deck = Deck.getTestDeck();
    }


    public void playCreature(Creature cc, int row, int column){
        FieldCreature fc = new FieldCreature(cc.getHealth(),cc.getAttack(),cc.getTurn(),cc.getEffect(),cc.getName());
        if (field.getHex(row,column)==null) {
            field.setHex(fc,row,column);
        }

    }


    public boolean playCard(int CardNumber){
       Card playCard = hand.getCard(CardNumber);
        if (playCard instanceof Creature) {
            Integer row =0 ,column= 0 ;
            int[] coords= new int[2];
            Programm.requestHex(coords);
            playCreature((Creature) playCard,coords[0],coords[1]);
            return true;
        }
        return false;
    }

    public void endTurn(){
        hand.addCard(deck.getTopCard());
    }

    ///Начальная инициализация идолов здоровьем 10
    private int[] initializeIdols() {

        int [] result = new int [rowNum];
        for(int i = 0;i<result.length;i++){
            result[i] = idolBaseHealth;
        }
        return result;
    }

    public int[] getEnemyIdols() {
        return enemyIdols;
    }

    public void setEnemyIdols(int[] enemyIdols) {
        this.enemyIdols = enemyIdols;
    }

    public int[] getIdols() {
        return idols;
    }

    public void setIdols(int[] idols) {
        this.idols = idols;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<rowNum;i++){
            sb.append("[ ");
            for(int j=0;j<columnNum;j++) {
                if (field.getHex(i,j) != null) {
                    sb.append(field.getHex(i,j).getAttack()+ "/" +field.getHex(i,j).getHealth()+" ," );
                } else {
                    sb.append(" X ,");
                }
            }
            sb.append(" ]");
            sb.append("\n");
        }
        return sb.toString();
    }
}
