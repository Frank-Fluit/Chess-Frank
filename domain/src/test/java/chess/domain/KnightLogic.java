package chess.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KnightLogic {


    @Test
    public void testMovesLeftWhiteKnight_1() {
        Board chessBoard = new Board();
        Square leftWhiteKnightSquare = chessBoard.getSquares(0,1);
        Knight leftWhiteKnight = (Knight)leftWhiteKnightSquare.getPiece();

        leftWhiteKnight.startAMove(2,0);

        assertEquals(Knight.class, chessBoard.getSquares(2,0).getPiece().getClass());
        assertNull(leftWhiteKnightSquare.getPiece());
    }

    @Test
    public void testMovesLeftWhiteKnight_2() {
        Board chessBoard = new Board();
        Square leftWhiteKnightSquare = chessBoard.getSquares(0,1);
        Knight leftWhiteKnight = (Knight)leftWhiteKnightSquare.getPiece();

        leftWhiteKnight.startAMove(2,2);

        assertEquals(Knight.class, chessBoard.getSquares(2,2).getPiece().getClass());
        assertNull(leftWhiteKnightSquare.getPiece());
    }

    @Test
    public void testMovesRightWhiteKnight_1() {
        Board chessBoard = new Board();
        Square rightWhiteKnightSquare = chessBoard.getSquares(0,6);
        Knight rightWhiteKnight = (Knight)rightWhiteKnightSquare.getPiece();

        rightWhiteKnight.startAMove(2,5);

        assertEquals(Knight.class, chessBoard.getSquares(2,5).getPiece().getClass());
        assertNull(rightWhiteKnightSquare.getPiece());
    }

    @Test
    public void testMovesRightWhiteKnight_2() {
        Board chessBoard = new Board();
        Square rightWhiteKnightSquare = chessBoard.getSquares(0,6);
        Knight rightWhiteKnight = (Knight)rightWhiteKnightSquare.getPiece();

        rightWhiteKnight.startAMove(2,7);

        assertEquals(Knight.class, chessBoard.getSquares(2,7).getPiece().getClass());
        assertNull(rightWhiteKnightSquare.getPiece());
    }

    @Test
    public void testMovesLeftBlackKnight_1() {
        Board chessBoard = new Board();
        Pawn pawn1_0  = (Pawn) chessBoard.getSquares(1,0).getPiece();
        pawn1_0.startAMove(2,0);

        Square leftBlackKnightSquare = chessBoard.getSquares(7,1);
        Knight leftBlackKnight = (Knight)leftBlackKnightSquare.getPiece();

        leftBlackKnight.startAMove(5,0);

        assertEquals(Knight.class, chessBoard.getSquares(5,0).getPiece().getClass());
        assertNull(leftBlackKnightSquare.getPiece());
    }

    @Test
    public void testMovesLeftBlackKnight_2() {
        Board chessBoard = new Board();
        Pawn pawn1_0  = (Pawn) chessBoard.getSquares(1,0).getPiece();
        pawn1_0.startAMove(2,0);

        Square leftBlackKnightSquare = chessBoard.getSquares(7,1);
        Knight leftBlackKnight = (Knight)leftBlackKnightSquare.getPiece();

        leftBlackKnight.startAMove(5,2);

        assertEquals(Knight.class, chessBoard.getSquares(5,2).getPiece().getClass());
        assertNull(leftBlackKnightSquare.getPiece());
    }

    @Test
    public void testMovesRightBlackKnight_1() {
        Board chessBoard = new Board();
        Pawn pawn1_0  = (Pawn) chessBoard.getSquares(1,0).getPiece();
        pawn1_0.startAMove(2,0);

        Square rightBlackKnightSquare = chessBoard.getSquares(7,6);
        Knight rightBlackKnight = (Knight)rightBlackKnightSquare.getPiece();

        rightBlackKnight.startAMove(5,7);

        assertEquals(Knight.class, chessBoard.getSquares(5,7).getPiece().getClass());
        assertNull(rightBlackKnightSquare.getPiece());
    }

    @Test
    public void testMovesRightBlackKnight_2() {
        Board chessBoard = new Board();
        Pawn pawn1_0  = (Pawn) chessBoard.getSquares(1,0).getPiece();
        pawn1_0.startAMove(2,0);

        Square rightBlackKnightSquare = chessBoard.getSquares(7,6);
        Knight rightBlackKnight = (Knight)rightBlackKnightSquare.getPiece();

        rightBlackKnight.startAMove(5,5);

        assertEquals(Knight.class, chessBoard.getSquares(5,5).getPiece().getClass());
        assertNull(rightBlackKnightSquare.getPiece());
    }

    @Test
    public void testIfWrongWhiteKnightMovesAreNotALlowed_1() {
        Board chessBoard = new Board();
        Square leftWhiteKnightSquare = chessBoard.getSquares(0,1);
        Knight leftWhiteKnight = (Knight)leftWhiteKnightSquare.getPiece();

        leftWhiteKnight.startAMove(2,1);

        assertEquals(Knight.class, chessBoard.getSquares(0,1).getPiece().getClass());
        assertNull(chessBoard.getSquares(2,1).getPiece());
    }

    @Test
    public void testIfWrongWhiteKnightMovesAreNotALlowed_2() {
        Board chessBoard = new Board();
        Square leftWhiteKnightSquare = chessBoard.getSquares(0,1);
        Knight leftWhiteKnight = (Knight)leftWhiteKnightSquare.getPiece();

        leftWhiteKnight.startAMove(1,3);

        assertEquals(Knight.class, chessBoard.getSquares(0,1).getPiece().getClass());
        assertEquals(Pawn.class, chessBoard.getSquares(1,3).getPiece().getClass());
    }

    @Test
    public void testIfWrongWhiteKnightMovesAreNotALlowed_3() {
        Board chessBoard = new Board();
        Square leftWhiteKnightSquare = chessBoard.getSquares(0,1);
        Knight leftWhiteKnight = (Knight)leftWhiteKnightSquare.getPiece();

        leftWhiteKnight.startAMove(1,-1);

        assertEquals(Knight.class, chessBoard.getSquares(0,1).getPiece().getClass());

    }

    @Test
    public void testIfLocationKnightIsCorrectAfterTwoMoves(){
        Board chessboard = new Board();
        Square leftWhiteKnightSquare = chessboard.getSquares(0,1);
        Knight leftWhiteKnight = (Knight) leftWhiteKnightSquare.getPiece();
    }

    // hier zou ik nog verkeerde moves voor andere knight kunnen toevoegen behalve de witte knight linksonder




}
