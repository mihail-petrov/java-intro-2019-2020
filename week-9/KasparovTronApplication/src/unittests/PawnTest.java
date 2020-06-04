package unittests;

import piece.Pawn;

class PawnTest extends PieceUnitTest {

    public void run() {

        testGroup("PawnTest");
        testIfMoveInSingleSquareWithBlackPawnIsValid();
        testIfMoveInSingleSquareWithWhitePawnIsValid();
        testIfMoveInMultipleSquareWithBlackIsNotValid();
        testIfMoveInMultipleSquareWithWhiteIsNotValid();

        testIsOneSquareRightDiagonalAttackWitchBlackIsValid();
        testIsOneSquareLeftDiagonalAttackWitchBlackIsValid();
        testIsMultipleSquareRightDiagonalAttackWitchBlackIsNotValid();
        testIsMultipleRowSquareRightDiagonalAttackWitchBlackIsNotValid();
    }

    private void testIfMoveInSingleSquareWithBlackPawnIsValid() {

        final int INIT_ROW = 8;
        final int EXTERNAL_ROW = 7;
        final int INIT_COL = 1;
        final int EXTERNAL_COL = 1;

        Pawn pawn = new Pawn("b", INIT_ROW, INIT_COL);

        testMessage("testIfMoveInSingleSquareWithBlackPawnIsValid", INIT_ROW,EXTERNAL_ROW, INIT_COL,EXTERNAL_COL);
        assertIsTrue(pawn.isMoveValid(EXTERNAL_ROW,EXTERNAL_COL));
    }

    private void testIfMoveInSingleSquareWithWhitePawnIsValid() {

        testMessage("testIfMoveInSingleSquareWithWhitePawnIsValid", 1,2,1,1);

        Pawn pawnSecondPiece = new Pawn("w", 1, 1);
        assertIsTrue(pawnSecondPiece.isMoveValid(2,1));
    }

    private void testIfMoveInMultipleSquareWithBlackIsNotValid() {

        Pawn pawn = new Pawn("b", 8, 1);
        testMessage("testIfMoveInMultipleSquareWithBlackIsNotValid", pawn.getRow(),6,pawn.getCol(),1);
        assertIsFalse(pawn.isMoveValid(6,1));
    }

    private void testIfMoveInMultipleSquareWithWhiteIsNotValid() {

        Pawn pawn = new Pawn("w", 1, 1);
        testMessage("testIfMoveInMultipleSquareWithWhiteIsNotValid", pawn.getRow(), 5, pawn.getCol(), 1);
        assertIsFalse(pawn.isMoveValid(5,1));
    }

    private void testIsOneSquareRightDiagonalAttackWitchBlackIsValid() {

        System.out.println("testIsOneSquareRightDiagonalAttackWitchBlackIsValid:");
        System.out.print("Attack from 8 to 7 row and 1 to 2 col:");

        Pawn pawn = new Pawn("b", 8, 1);
        assertIsTrue(pawn.isAttackValid(7,2));
    }

    private void testIsOneSquareLeftDiagonalAttackWitchBlackIsValid() {

        System.out.println("testIsOneSquareLeftDiagonalAttackWitchBlackIsValid:");
        System.out.print("Attack from 8 to 7 row and 1 to 0 col:");

        Pawn pawn = new Pawn("b", 8, 1);
        assertIsTrue(pawn.isAttackValid(7,0));
    }

    private void testIsMultipleSquareRightDiagonalAttackWitchBlackIsNotValid() {

        System.out.println("testIsMultipleSquareRightDiagonalAttackWitchBlackIsNotValid:");
        System.out.print("Attack from 8 to 7 row and 1 to 3 col:");

        Pawn pawn = new Pawn("b", 8, 1);
        assertIsFalse(pawn.isAttackValid(7,3));
    }

    private void testIsMultipleRowSquareRightDiagonalAttackWitchBlackIsNotValid() {

        System.out.println("testIsMultipleRowSquareRightDiagonalAttackWitchBlackIsNotValid:");
        System.out.print("Attack from 8 to 6 row and 1 to 2 col:");

        Pawn pawn = new Pawn("b", 8, 1);
        assertIsFalse(pawn.isAttackValid(6,1));
    }
}
