import piece.Knight;
import piece.Pawn;

import java.io.*;

public class Application {

    public static Object[][] gameBoard = new Object[10][10];

    public static Object createNewPiece(String id, int row, int col) {

        if(id.equals("wP")) {
            return new Pawn("w", row, col);
        }

        if(id.equals("bP")) {
            return new Pawn("b", row, col);
        }

        return null;
    }

    public static void main(String[] args) {

        File fileReference = new File("resource/board_init");

        try {
            FileReader fileReferenceReader = new FileReader(fileReference);
            BufferedReader bufferedReader  = new BufferedReader(fileReferenceReader);

            String lineReference;
            String pieceId;
            String piecePositionCoordinate;
            int pieceRow;
            int pieceCol;
            while((lineReference = bufferedReader.readLine()) != null) {

                String[] pieceIdCollection  = lineReference.split("=");
                pieceId                     = pieceIdCollection[0];
                piecePositionCoordinate     = pieceIdCollection[1];
                String[] pieceCoordinateCollection = piecePositionCoordinate.split(":");
                pieceRow = Integer.parseInt(pieceCoordinateCollection[0]);
                pieceCol = Integer.parseInt(pieceCoordinateCollection[1]);

                // TODO: Кой носи отговорност за позиционирането на фигурите върху дъската ?
                Object pieceReference = createNewPiece(pieceId, pieceRow, pieceCol);
                gameBoard[pieceRow][pieceCol] = pieceReference;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
