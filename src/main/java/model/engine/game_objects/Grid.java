package model.engine.game_objects;

import model.cards_creature.FieldCreature;
import model.engine.Board;
import model.engine.events.CardPlayedEvent;

import java.util.LinkedList;
import java.util.List;

public class Grid {
    FieldCreature[][] battleField;
    int rowNum, columnNum;
    CardPlayedEvent cpe;
    private static final int hexLenght = 5;


    public Grid(int rowNum, int columnNum, Board gf){
        battleField = createBF(rowNum,columnNum);
        this.rowNum = rowNum;
        this.columnNum = columnNum;
        cpe = new CardPlayedEvent(gf);
    }



    public FieldCreature getHex(int rowNum,int columnNum) {
        return battleField[rowNum][columnNum];
    }
    public void setHex(FieldCreature fc,int row,int column) {
        battleField[row][column]= fc;
    }

    private FieldCreature[][] createBF(int rowNum, int columnNum) {
        FieldCreature result[][] = new FieldCreature[rowNum][];
        for(int i = 0;i<rowNum;i++){
            result[i] = createEmptyRow(columnNum);
        }
    return result;
    }

    private FieldCreature[] createEmptyRow(int columnNum) {
        FieldCreature[] resultRow = new FieldCreature[columnNum];
        for(int i = 0;i<columnNum;i++){

            resultRow[i] = null;
        }
        return resultRow;
    }

    public FieldCreature[] getNearHex(int row,int column){
        List<FieldCreature> result = new LinkedList<FieldCreature>();
        //Поле слева
        addHex(result,row,column-1);
        //Поле справа
        addHex(result,row,column+1);
        //Поле снизу
        addHex(result,row-1,column);
        //Поле сверху
        addHex(result,row+1,column);
        //В зависимости от сдвига ряда определются оставщиеся соседи
        //Четный ряд - выступающий
        if(row%2==0){
            addHex(result, row - 1, column + 1);
            addHex(result, row - 1, column - 1);
        }else{
            addHex(result, row + 1, column + 1);
            addHex(result, row + 1, column - 1);
        }
        return result.toArray(new FieldCreature[0]);

    }
    public boolean isHexExist(int row, int column){
        if(column<0){
            return false;
        }else if(column>columnNum){
            return false;
        }else if(row<0){
            return false;
        }else if(row>rowNum){
            return false;
        }
        return true;
    }
    private void addHex(List<FieldCreature> result,int row, int column){
        if(isHexExist(row,column)){
            result.add(getHex(row,column));
        }
    }

    @Override
    public String toString(){
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < rowNum; i++) {
            result.append("[ ");
            for (int j = 0; j < columnNum; j++) {
                hexString(result,i,j);
            }
            result.append(" ]");
            result.append("\n");


        }
        return result.toString();
    }

    private void hexString(StringBuffer sb ,int i, int j){
        FieldCreature cr = getHex(i, j);
        if (cr  != null) {
            String s = cr.getAttack() + "/" + cr.getHealth();
            addStringHex(sb, s);

        } else {
            addStringHex(sb, "X");
        }
        sb.append(",");
    }
    public void addStringHex(StringBuffer sb,String s){
        int len = hexLenght - s.length(); 
        sb.append(probels(len/2));
        sb.append(s);
        sb.append(probels(len - len/2 - 1));
    }
    private String probels(int length){
        char[] ch = new char[length];
        for(int i = 0;i<length;i++){
            ch[i]= ' ';
        }
        return new String(ch);
    }

}
