package chess.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MoveLogic {

    
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfDoMoveChangesPositionPawn(int num) {
        Board chessBoard = new Board();
        Square squareRow1 = chessBoard.getSquares(1,num);
        Pawn pawnRow1 = (Pawn)squareRow1.getPiece();

        pawnRow1.startAMove(2,num);

        assertEquals(Pawn.class, chessBoard.getSquares(2,num).getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6})
    public void testIfDoMoveDisallowsIllegalDiagonalRightPawnMoves(int num) {
        Board chessBoard = new Board();
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow = chessBoard.getSquares(2,num+1);

        Pawn pawnRow1 = (Pawn)squareRow1.getPiece();

        pawnRow1.startAMove(2,num +1);


        assertEquals(Pawn.class, chessBoard.getSquares(1,num).getPiece().getClass());
        assertNull(targetRow.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public void testIfDoMoveDisallowsIllegalDiagonalLeftPawnMoves(int num) {
        Board chessBoard = new Board();
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow = chessBoard.getSquares(2,num-1);

        Pawn pawnRow1 = (Pawn)squareRow1.getPiece();

        pawnRow1.startAMove(2,num -1);


        assertEquals(Pawn.class, chessBoard.getSquares(1,num).getPiece().getClass());
        assertNull(targetRow.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfDoubleFirstMoveIsAllowed(int num) {
        Board chessBoard = new Board();
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow = chessBoard.getSquares(3,num);

        Pawn pawnRow1 = (Pawn)squareRow1.getPiece();
        pawnRow1.startAMove(3,num);


        assertEquals(Pawn.class, chessBoard.getSquares(3,num).getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfTripleFirstMoveIsDisAllowed(int num) {
        Board chessBoard = new Board();
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow = chessBoard.getSquares(4,num);
        Pawn pawnRow1 = (Pawn)squareRow1.getPiece();
        pawnRow1.startAMove(4,num);

        assertEquals(Pawn.class, chessBoard.getSquares(1,num).getPiece().getClass());
        assertNull(targetRow.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfDoubleMoveIsDisallowed(int num) {
        Board chessBoard = new Board();
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow = chessBoard.getSquares(3,num);
        Pawn pawnRow1 = (Pawn)squareRow1.getPiece();
        pawnRow1.startAMove(3,num);
        Square squareRow3 = chessBoard.getSquares(3,num);
        Pawn pawnRow3 = (Pawn)targetRow.getPiece();

        pawnRow3.startAMove(4,num);
        Square targetRow4 = chessBoard.getSquares(4,num);


        assertEquals(Pawn.class, chessBoard.getSquares(3,num).getPiece().getClass());
        assertNull(targetRow4.getPiece());
    }


    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfMultipleMovesAreAllowed(int num) {
        Board chessBoard = new Board();
        Square squareRow1 = chessBoard.getSquares(1,num);
        Pawn pawnRow1 = (Pawn)squareRow1.getPiece();

        Square squareRow6 = chessBoard.getSquares(6,num);
        Pawn pawnRow6 = (Pawn)squareRow6.getPiece();

        pawnRow1.startAMove(2,num);
        pawnRow6.startAMove(5,num);

        assertEquals(Pawn.class, chessBoard.getSquares(5,num).getPiece().getClass());
        assertEquals(Pawn.class, chessBoard.getSquares(2,num).getPiece().getClass());
        assertNull(squareRow1.getPiece());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6})
    public void testIfBlackDiagonalRightPawnMovesAreDisallowed(int num) {
        Board chessBoard = new Board();
        Square squareRow1 = chessBoard.getSquares(1,num);
        Pawn pawnRow1 = (Pawn)squareRow1.getPiece();


        Square squareRow5 = chessBoard.getSquares(5,num);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Pawn pawnRow6 = (Pawn)squareRow6.getPiece();

        pawnRow1.startAMove(2,num);
        pawnRow6.startAMove(5,num +1);

        assertEquals(Pawn.class, chessBoard.getSquares(6,num).getPiece().getClass());
        assertEquals(Pawn.class, chessBoard.getSquares(2,num).getPiece().getClass());
        assertNull(squareRow1.getPiece());
        assertNull(squareRow5.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public void testIfBlackDiagonalLeftPawnMovesAreDisallowed(int num) {
        Board chessBoard = new Board();
        Square squareRow1 = chessBoard.getSquares(1,num);
        Pawn pawnRow1 = (Pawn)squareRow1.getPiece();


        Square squareRow5 = chessBoard.getSquares(5,num);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Pawn pawnRow6 = (Pawn)squareRow6.getPiece();

        pawnRow1.startAMove(2,num);
        pawnRow6.startAMove(5,num -1);

        assertEquals(Pawn.class, chessBoard.getSquares(6,num).getPiece().getClass());
        assertEquals(Pawn.class, chessBoard.getSquares(2,num).getPiece().getClass());
        assertNull(squareRow1.getPiece());
        assertNull(squareRow5.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfBlackCannotStartAMove(int num) {
        Board chessBoard = new Board();
        Square squareRow6 = chessBoard.getSquares(6,num);
        Pawn pawnRow6 = (Pawn)squareRow6.getPiece();
        Square squareRow5 = chessBoard.getSquares(5,num);

        pawnRow6.startAMove(5,num);

        assertEquals(Pawn.class, chessBoard.getSquares(6,num).getPiece().getClass());
        assertNull(squareRow5.getPiece());
    }





}
