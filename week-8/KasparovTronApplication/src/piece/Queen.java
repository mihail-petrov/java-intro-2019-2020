package piece;

public class Queen extends Piece {

    public Queen(String color, int row, int col) {

        this.color = color;
        this.row = row;
        this.col = col;
    }

    @Override
    public boolean isMoveValid(int externalRow, int externalCol) {
        return false;
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
