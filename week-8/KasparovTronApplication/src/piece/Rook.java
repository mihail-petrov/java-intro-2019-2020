package piece;

public class Rook extends Piece {

    public Rook(String color, int row, int col) {

        this.color  = color;
        this.row    =  row;
        this.col    = col;
    }

    public int getRow() {
        return this.row; // ?
    }

    @Override
    public boolean isMoveValid(int externalRow, int externalCol) {
        int moveRowCoefficient = Math.abs(externalRow - this.row);
        int moveColCoefficient = Math.abs(externalCol - this.col);

        return  (moveColCoefficient == 0 && moveRowCoefficient > 0) ||
                (moveRowCoefficient == 0 && moveColCoefficient > 0);
    }

    @Override
    public boolean isAttackValid(int externalRow, int externalCol) {
        return false;
    }


    @Override
    public boolean canAttack() {
        return true;
    }
}
