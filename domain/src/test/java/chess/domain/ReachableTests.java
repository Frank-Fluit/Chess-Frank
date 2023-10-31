package chess.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReachableTests {

    String boardWithQueen ="QEEEEEEK" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEWW" +
            "EEEEEEEV" ;

    @Test
    public void testIfReachableSquaresPawnAreUpdated() {
        Board chessBoard = new Board();
        Pawn blackPawn = (Pawn) chessBoard.getSquares(1,5).getPiece();
        blackPawn.addReachableToSquares();

        for (int i = 0; i <= 63; i++) {
            Square targetSquare = chessBoard.getSquareIndex(i);
            if(i == 21 || i == 29){
                assertTrue(targetSquare.isReachableSquare());
            }
            else{
                assertFalse(targetSquare.isReachableSquare());
            }
        }
    }

    @Test
    public void testIfReachableSquaresQueenAreUpdated() {
        Board chessBoard = new Board(boardWithQueen);
        Queen whiteQueen = (Queen) chessBoard.getSquares(0,0).getPiece();
        whiteQueen.addReachableToSquares();

        for (int i = 0; i <= 63; i++) {
            Square targetSquare = chessBoard.getSquareIndex(i);
            if(i == 2 || i == 3 || i == 6 || i== 32 || i ==27){
                assertTrue(targetSquare.isReachableSquare());
            }

        }
    }



}

