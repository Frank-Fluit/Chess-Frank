package chess.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class KingLogic {

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

    @Test
    public void testIllegalMovesWhiteKing_1() {
        Board chessBoard = new Board();
        Square whiteKingSquare = chessBoard.getSquares(0, 4);
        King leftWhiteKing = (King) whiteKingSquare.getPiece();

        leftWhiteKing.startAMove(0,5);

        assertEquals(King.class, chessBoard.getSquares(0, 4).getPiece().getClass());
        assertEquals(Bisshop.class, chessBoard.getSquares(0, 5).getPiece().getClass());

    }

    @Test
    public void testIllegalMovesWhiteKing_2() {
        Board chessBoard = new Board();
        Square whiteKingSquare = chessBoard.getSquares(0, 4);
        King leftWhiteKing = (King) whiteKingSquare.getPiece();

        leftWhiteKing.startAMove(2,4);

        assertEquals(King.class, chessBoard.getSquares(0, 4).getPiece().getClass());
        assertNull(chessBoard.getSquares(2, 4).getPiece());

    }

    @Test
    public void testMovesBlackKing() {
        Board chessBoard = new Board();
        Square blackKingSquare = chessBoard.getSquares(7, 4);
        King blackKing = (King) blackKingSquare.getPiece();

        Square whiteKingPawnSquare = chessBoard.getSquares(1, 4);
        Pawn whiteKingPawn = (Pawn) whiteKingPawnSquare.getPiece();

        Square whiteQueenPawnSquare = chessBoard.getSquares(1, 3);
        Pawn whiteQueenPawn = (Pawn) whiteQueenPawnSquare.getPiece();

        Square blackKingPawnSquare = chessBoard.getSquares(6, 4);
        Pawn blackKingPawn = (Pawn) blackKingPawnSquare.getPiece();


        whiteKingPawn.startAMove(2, 4);
        blackKingPawn.startAMove(5, 4);
        whiteQueenPawn.startAMove(2, 3);
        blackKing.startAMove(6,4);


        assertEquals(Pawn.class, chessBoard.getSquares(2, 4).getPiece().getClass());
        assertEquals(Pawn.class, chessBoard.getSquares(2, 3).getPiece().getClass());
        assertEquals(Pawn.class, chessBoard.getSquares(5, 4).getPiece().getClass());
        assertEquals(King.class, chessBoard.getSquares(6, 4).getPiece().getClass());
        assertNull(blackKingSquare.getPiece());
    }

    @Test
    public void testIllegalMovesBlackKing_1() {
        Board chessBoard = new Board();
        Square blackKingSquare = chessBoard.getSquares(7, 4);
        King blackKing = (King) blackKingSquare.getPiece();

        Square whiteKingPawnSquare = chessBoard.getSquares(1, 4);
        Pawn whiteKingPawn = (Pawn) whiteKingPawnSquare.getPiece();

        whiteKingPawn.startAMove(2, 4);
        blackKing.startAMove(6,5);

        assertEquals(King.class, chessBoard.getSquares(7, 4).getPiece().getClass());
        assertEquals(Pawn.class, chessBoard.getSquares(6, 5).getPiece().getClass());

    }
    
}
