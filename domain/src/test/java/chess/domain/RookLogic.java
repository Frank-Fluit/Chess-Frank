package chess.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RookLogic {

    @Test
    public void testMovesWhiteKing() {
        Board chessBoard = new Board();
        Square whiteKingSquare = chessBoard.getSquares(0, 4);
        King whiteKing = (King) whiteKingSquare.getPiece();

        Square whiteKingPawnSquare = chessBoard.getSquares(1, 4);
        Pawn whiteKingPawn = (Pawn) whiteKingPawnSquare.getPiece();

        Square blackKingPawnSquare = chessBoard.getSquares(6, 4);
        Pawn blackKingPawn = (Pawn) blackKingPawnSquare.getPiece();

        whiteKingPawn.startAMove(2, 4);
        blackKingPawn.startAMove(5, 4);
        whiteKing.startAMove(1, 4);


        assertEquals(Pawn.class, chessBoard.getSquares(2, 4).getPiece().getClass());
        assertEquals(Pawn.class, chessBoard.getSquares(5, 4).getPiece().getClass());
        assertEquals(King.class, chessBoard.getSquares(1, 4).getPiece().getClass());
        assertNull(whiteKingSquare.getPiece());
    }
}
