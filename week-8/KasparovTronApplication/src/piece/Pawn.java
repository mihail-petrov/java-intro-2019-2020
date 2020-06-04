package piece;

public class Pawn extends Piece {

    public Pawn(String pieceColor, int rowInput, int colInput) {

        // this.color = pieceColor;
        this.setColor(pieceColor);
        this.setRow(rowInput);
        this.setCol(colInput);
    }

    public boolean isMoveValid(int externalRow, int externalCol) {

        int moveRowCoefficient = Math.abs(externalRow - this.row);
        int moveColCoefficient = Math.abs(externalCol - this.col);

        return  (moveRowCoefficient == 1) &&
                (moveColCoefficient == 0);
    }

    public boolean isAttackValid(int externalRow, int externalCol) {

        int moveRowCoefficient = Math.abs(externalRow - this.row);
        int moveColCoefficient = Math.abs(externalCol - this.col);

        return  (moveRowCoefficient == 1) &&
                (moveColCoefficient == 1);
    }

    @Override
    public boolean canAttack() {
        return true;
    }
}