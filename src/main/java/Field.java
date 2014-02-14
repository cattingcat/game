import java.util.LinkedList;
import java.util.List;

public class Field {
    FieldCreature[][] battleField;
    int rowNum, columnNum;

    public Field(int rowNum,int columnNum){
        battleField = createBF(rowNum,columnNum);
        this.rowNum = rowNum;
        this.columnNum = columnNum;
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



}
