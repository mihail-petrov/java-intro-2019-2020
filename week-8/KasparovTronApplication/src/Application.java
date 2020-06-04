import piece.*;

import java.io.*;

public class Application {

    public static Piece[][] gameBoard = new Piece[10][10];

    public static Piece createNewPiece(String id, int row, int col) {

        if(id.equals("wP")) {
            return new Pawn("w", row, col);
        }

        if(id.equals("bP")) {
            return new Pawn("b", row, col);
        }

        if(id.equals("wK")) {
            return new King("w", row, col);
        }

        if(id.equals("bK")) {
            return new King("b", row, col);
        }

        if(id.equals("wR")) {
            return new Rook("w", row, col);
        }

        if(id.equals("bR")) {
            return new Rook("b", row, col);
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
                Piece pieceReference = createNewPiece(pieceId, pieceRow, pieceCol);
                gameBoard[pieceRow][pieceCol] = pieceReference;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
