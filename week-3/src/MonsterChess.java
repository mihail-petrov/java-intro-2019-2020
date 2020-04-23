import java.util.Scanner;

public class MonsterChess {

    public static void main(String[] args) {

        // 0. Data structure
        boolean isGameOver    = false;
        boolean isGameRunning = true;
        int activePlayerId    = 1;
        int[] gameBoard       = new int[9];

        // 1. Get input data
        // cin >>
        Scanner gameInputScanner  = new Scanner(System.in);

        while(isGameRunning) {

            System.out.println("Input row");
            int pieceRowPositionInput = gameInputScanner.nextInt();
            System.out.println("Input col:");
            int pieceColPositionInput = gameInputScanner.nextInt();

            // 2. Validate input data
            int piecePositionIndex    = getPiecePositionIndex(pieceRowPositionInput, pieceColPositionInput);

            if(isPositinable(gameBoard, piecePositionIndex)) {

                gameBoard[piecePositionIndex]   = activePlayerId;
                activePlayerId                  = getActivePlayerId(activePlayerId);
                System.out.println("Success positioning");
                continue;
            }
            System.out.println("Try again");
        }
    }

    public static int getActivePlayerId(int currentId) {

        final int PLAYER_RED_ID     = 1;
        final int PLAYER_GREEN_ID   = 2;

        return (currentId == PLAYER_RED_ID) ? PLAYER_GREEN_ID :
                                              PLAYER_RED_ID;
    }

    public static boolean isPositinable(int[] referenceCollection, int index) {
        return referenceCollection[index] == 0;
    }

    public static int getPiecePositionIndex(int rowPosition, int colPosition) {

        int colOffset                = 3;
        final int ARRAY_INDEX_OFFSET = 1;
        int rowOffsetFormula         = (rowPosition - ARRAY_INDEX_OFFSET) * colOffset;

        return (colPosition + rowOffsetFormula) - ARRAY_INDEX_OFFSET;
    }

}