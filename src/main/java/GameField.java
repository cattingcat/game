
public class GameField {
    Field field;
    Hand hand;
    Hand EnemyHand;
    int[]idols;
    int[]enemyIdols;
    static final int rowNum = 5;
    static final int columnNum = 5;
    {
        field = new Field(rowNum,columnNum);
        idols = initializeIdols();
        enemyIdols = initializeIdols();
    }

    private void playCard(int CardNumber){
       // hand.playCard(CardNumber);
    }
    private void endTurn(){

    }

    ///Начальная инициализация идолов здоровьем 10
    private int[] initializeIdols() {
        final int idolBaseHealth = 10;
        int [] result = new int [rowNum];
        for(int i = 0;i<result.length;i++){
            result[i] = idolBaseHealth;
        }
        return result;
    }
}
