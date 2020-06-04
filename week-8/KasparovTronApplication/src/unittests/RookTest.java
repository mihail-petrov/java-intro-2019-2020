package unittests;

import piece.Rook;

class RookTest extends PieceUnitTest {

    @Override
    public void run() {

        testGroup("RookTest");
        testIfColUpDirectionMoveIsValid();
        testIfDiagonalLeftUpDirectionMoveIsNotValid();
        testIfRowRightDirectionMoveIsValid();
    }

    public void testIfRowRightDirectionMoveIsValid() {

        final int INIT_ROW      = 9;
        final int EXTERNAL_ROW  = 9;
        final int INIT_COL      = 0;
        final int EXTERNAL_COL  = 5;
        testMessage("testIfRowRightDirectionMoveIsValid", INIT_ROW, EXTERNAL_ROW, INIT_COL, EXTERNAL_COL);

        Rook piece = new Rook("b", INIT_ROW, INIT_COL);
        assertIsTrue(piece.isMoveValid(EXTERNAL_ROW, EXTERNAL_COL));
    }

    public void testIfColUpDirectionMoveIsValid() {

        final int INIT_ROW      = 9;
        final int EXTERNAL_ROW  = 2;
        final int INIT_COL      = 0;
        final int EXTERNAL_COL  = 0;
        testMessage("testIfColUpDirectionMoveIsValid", INIT_ROW, EXTERNAL_ROW, INIT_COL, EXTERNAL_COL);
        Rook piece = new Rook("b", INIT_ROW, INIT_COL);
        assertIsTrue(piece.isMoveValid(EXTERNAL_ROW, EXTERNAL_COL));
    }

    public void testIfDiagonalLeftUpDirectionMoveIsNotValid() {

        final int INIT_ROW      = 9;
        final int EXTERNAL_ROW  = 8;
        final int INIT_COL      = 0;
        final int EXTERNAL_COL  = 1;
        testMessage("testIfDiagonalLeftUpDirectionMoveIsNotValid", INIT_ROW, EXTERNAL_ROW, INIT_COL, EXTERNAL_COL);
        Rook piece = new Rook("b", INIT_ROW, INIT_COL);
        assertIsFalse(piece.isMoveValid(EXTERNAL_ROW, EXTERNAL_COL));
    }
}
