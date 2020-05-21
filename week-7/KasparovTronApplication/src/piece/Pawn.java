package piece;

public class Pawn {

    private String color;
    private int value;
    private String id;

    private int row;
    private int col;

    public Pawn(String pieceColor, int rowInput, int colInput) {

        // this.color = pieceColor;
        this.setColor(pieceColor);
        this.setRow(rowInput);
        this.setCol(colInput);
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int rowInput) {
        this.row = rowInput;
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
}