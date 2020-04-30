import java.util.Scanner;

public class MonsterChess {

    static final int LOWEST_INPUT  = 1;
    static final int GREATES_INPUT = 3;

    static final int PLAYER_RED_ID     = 1;
    static final int PLAYER_GREEN_ID   = 2;

    public static void main(String[] args) {

        // 0. Data structure
        boolean isGameOver    = false;
        boolean isGameRunning = true;
        int activePlayerId    = 1;

        // TODO: export as global variable maiby
        // int[] gameBoard       = new int[9];
        int[][] gameBoard       = new int[GREATES_INPUT][GREATES_INPUT];

        // 1. Get input data
        // cin >>
        Scanner gameInputScanner  = new Scanner(System.in);

        renderGameBoard(gameBoard);

        while(isGameRunning) {

            System.out.println("Input row");
            int pieceRowPositionInput = gameInputScanner.nextInt();

            if(isGameBoardInputInvalid(pieceRowPositionInput)) {
                System.out.println("Incorect input pls try again with data between 1 and 3");
                continue;
            }

            System.out.println("Input col:");
            int pieceColPositionInput = gameInputScanner.nextInt();

            if(isGameBoardInputInvalid(pieceColPositionInput)) {

                System.out.println("Incorect input pls try again with between 1 and 3");
                continue;
            }

            // 2. Validate input data
            // int piecePositionIndex    = getPiecePositionIndex(pieceRowPositionInput, pieceColPositionInput);
            int piecePositionRow = pieceRowPositionInput - 1;
            int piecePositionCol = pieceColPositionInput - 1;

            if(isPositinable(gameBoard, piecePositionRow, piecePositionCol)) {

                gameBoard[piecePositionRow][piecePositionCol]   = activePlayerId;

                if(isMoveWinnable(gameBoard, activePlayerId)) {

                    isGameRunning = false; // TODO: Think about it
                    System.out.println("Winner " + activePlayerId);
                    System.out.println("Winner winner chiken dinner");
                    break;
                }

                if(isGameBoardFull(gameBoard)) {
                    isGameRunning = false; // TODO: Think about it
                    System.out.println("Game over man");
                    break;
                }

                activePlayerId                  = getActivePlayerId(activePlayerId);
                renderGameBoard(gameBoard);
                continue;
            }

            System.out.println("Try again");
        }
    }

    /**
     *
     * @param currentId
     * @return
     */
    public static int getActivePlayerId(int currentId) {

        return (currentId == PLAYER_RED_ID) ? PLAYER_GREEN_ID :
                                              PLAYER_RED_ID;
    }

    /**
     *
     * @param gameBoard
     * @param row
     * @param col
     * @return
     */
    public static boolean isPositinable(int[][] gameBoard, int row, int col) {

        // return referenceCollection[index] == 0;
        return getGameBoardPlayerId(gameBoard, row, col) == 0;
    }

    /**
     * @author Mihail Petrov
     * @param rowPosition
     * @param colPosition
     * @return int
     */
//    public static int getPiecePositionIndex(int rowPosition, int colPosition) {
//
//        int colOffset                = 3;
//        final int ARRAY_INDEX_OFFSET = 1;
//        int rowOffsetFormula         = (rowPosition - ARRAY_INDEX_OFFSET) * colOffset;
//
//        return (colPosition + rowOffsetFormula) - ARRAY_INDEX_OFFSET;
//    }

    /**
     *
     * @author Mihail Petro
     * @param inputData
     * @return boolean
     */
    public static boolean isGameBoardInputValid(int inputData) { //

        return  inputData >= LOWEST_INPUT &&
                inputData <= GREATES_INPUT;
    }

    /**
     *
     * @author Mihail Petro
     * @param inputData
     * @return boolean
     */
    public static boolean isGameBoardInputInvalid(int inputData) {

        return  inputData < LOWEST_INPUT ||
                inputData > GREATES_INPUT;

        // TODO: Have in mind
        // return !isGameBoardInputValid(inputData);
    }

    public static int getGameBoardPlayerId(int[][] gameBoard, int row, int col) {
        //return gameBoard[getPiecePositionIndex(row, col)];
        return gameBoard[row][col];
    }

    public static String getGameBoardMark(int[][] gameBoard, int row, int col) {

        int playerId = getGameBoardPlayerId(gameBoard, row, col);

        if(playerId == PLAYER_RED_ID    ) return "X ";
        if(playerId == PLAYER_GREEN_ID  ) return "& ";
        return "* ";
    }

    public static void renderGameBoard(int[][] gameBoard) {

        for(int row = 0; row < GREATES_INPUT; row++) { // while(true)
            for(int col = 0; col < GREATES_INPUT; col++ ) {
                System.out.print(getGameBoardMark(gameBoard, row, col));
            }
            System.out.println();
        }
    }

    public static boolean isColWinnable(int[][] gameBoard, int colIndex, int playerId) {

        for(int i = 0; i < GREATES_INPUT; i++) {

            if(gameBoard[i][colIndex] != playerId) {
                return false;
            }
        }

        return true;
    }

    public static boolean isRowWinnable(int[][] gameBoard, int rowIndex, int playerId) {

        for(int i = 0; i < GREATES_INPUT; i++) {

            if(gameBoard[rowIndex][i] != playerId) {
                return false;
            }
        }

        return true;
    }

    public static boolean isMoveWinnable(int[][] gameBoard, int playerId) {

        for(int row = 0; row < GREATES_INPUT; row++) {
            for(int col = 0; col < GREATES_INPUT; col++) {

                int gameBoardPlayerIdForCurrentPosition = gameBoard[row][col];

                if(gameBoardPlayerIdForCurrentPosition != playerId) { // not the same
                    continue;
                }

                if(row == 0) {
                    if(isColWinnable(gameBoard, col, playerId)) {
                        return true;
                    }
                }

                if(col == 0) {
                    if(isRowWinnable(gameBoard, row, playerId)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean isGameBoardFull(int[][] gameBoard) {

        for(int row = 0; row < GREATES_INPUT; row++) {
            for(int col = 0; col < GREATES_INPUT; col++) {
                if(gameBoard[row][col] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}