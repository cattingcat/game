
public class GameField {
    Field field;
    Hand hand;
    Hand EnemyHand;
    int[]idols;
    int[]enemyIdols;

    static final int rowNum = 5;
    static final int columnNum = 5;
    private static final int idolBaseHealth = 10;
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
}
