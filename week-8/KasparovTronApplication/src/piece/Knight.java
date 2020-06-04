package piece;

public class Knight extends Piece {

    public Knight(String color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
    }

    public boolean isMoveValid(int externalRow, int externalCol) {
        return false;
    }

    public boolean isAttackValid(int externalRow, int externalCol) {
        return false;
    }

    @Override
    public boolean canAttack() {
        return true;
    }
}
