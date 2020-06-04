package piece;
public class Medik extends Piece implements CanJump, CanHeal {

    @Override
    public boolean isMoveValid(int externalRow, int externalCol) {

        int moveRowCoefficient = Math.abs(externalRow - this.row);
        int moveColCoefficient = Math.abs(externalCol - this.col);

        return  (moveColCoefficient == 0 && moveRowCoefficient == 1) ||
                (moveColCoefficient == 1 && moveRowCoefficient == 1) ||
                (moveColCoefficient == 1 && moveRowCoefficient == 0);
    }

    @Override
    public boolean isAttackValid(int externalRow, int externalCol) {
        return false;
    }

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public boolean isJumpValid() {
        return true;
    }

    @Override
    public boolean isHealValid() {
        return false;
    }
}
