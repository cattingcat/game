
public class Field {
    FieldCreature[][] battleField;
    public Field(int rowNum,int columnNum){
        battleField = createBF(rowNum,columnNum);
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
            resultRow[i] = new FieldCreature();
        }
        return resultRow;
    }

}
