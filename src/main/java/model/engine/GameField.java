package model.engine;

import model.Programm;
import model.cards_creature.FieldCreature;
import model.cards_templates.Card;
import model.cards_templates.Creature;

public class GameField {
    private int turn = 0;
    Field[] fieldSides;
    Hand[] hands;
    int[][]idols;
    Deck[] decks;
    static final int playersCount = 2;

    static final int rowNum = 5;
    static final int columnNum = 3;
    private static final int idolBaseHealth = 10;
    {
        hands = new Hand[playersCount];
        hands[0] = new Hand();
        hands[1] = new Hand();

        decks= new Deck[playersCount];
        decks[0] = new Deck();
        decks[1] = new Deck();
        //TODO make normal deck, this is test.
        decks[0] = Deck.getTestDeck();
        //~~~~
        fieldSides = new Field[playersCount];
        fieldSides[0] = new Field(rowNum,columnNum);
        fieldSides[1] = new Field(rowNum,columnNum);
        idols = new int[playersCount][];
        for(int i = 0 ;i<playersCount;i++){
            idols[i] = initializeIdols();
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
        return hands[turn];
    }

    private Field getMyField(){
        return fieldSides[turn];
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int k = 0 ;k<playersCount;k++){
            for(int i=0;i<rowNum;i++){
                sb.append("[ ");
                for(int j=0;j<columnNum;j++) {
                    if (fieldSides[j].getHex(i,j) != null) {
                        sb.append(fieldSides[k].getHex(i,j).getAttack()+ "/" +fieldSides[k].getHex(i,j).getHealth()+" ," );
                    } else {
                        sb.append(" X ,");
                    }
                }
                sb.append(" ]");
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void endTurn(){
        turn = (turn==0)? 1 :0;
    }
}
