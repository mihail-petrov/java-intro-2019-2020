package piece;

public abstract class Piece {

    protected String color;
    protected int value;
    protected String id;

    protected int row;
    protected int col;

    public int getRow() {
        return this.row;
    }

    public void setRow(int rowInput) {

        if(rowInput > 0) {
            this.row = rowInput;
        }
    }

    public int getCol() {
        return this.col;
    }

    public void setCol(int colInput) {
        this.col = colInput;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract boolean isMoveValid(int externalRow, int externalCol);

    public abstract boolean isAttackValid(int externalRow, int externalCol);

    public abstract boolean canAttack();
}
