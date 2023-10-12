package chess.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InitialisationLogic {



    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfRow0IsEmpty(int num) {
        Board chessBoard = new Board();
        Square squareRow0 = chessBoard.getSquares(0,num);

        assertNull(squareRow0.getPiece());
    }


    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfRow1HasPawns(int num) {
        Board chessBoard = new Board();
        Square squareRow1 = chessBoard.getSquares(1,num);
        Piece pieceRow1 = squareRow1.getPiece();

        Piece pawn = new Pawn();

        assertEquals(Pawn.class, pieceRow1.getClass());
    }


    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfRow2IsEmpty(int num) {
        Board chessBoard = new Board();
        Square squareRow2 = chessBoard.getSquares(2,num);

        assertNull(squareRow2.getPiece());
    }


    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfRow3IsEmpty(int num) {
        Board chessBoard = new Board();
        Square squareRow3 = chessBoard.getSquares(3,num);

        assertNull(squareRow3.getPiece());
    }


    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfRow4IsEmpty(int num) {
        Board chessBoard = new Board();
        Square squareRow4 = chessBoard.getSquares(4,num);

        assertNull(squareRow4.getPiece());
    }


    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfRow5IsEmpty(int num) {
        Board chessBoard = new Board();
        Square squareRow5 = chessBoard.getSquares(5,num);

        assertNull(squareRow5.getPiece());
    }


    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfRow6HasPawns(int num) {
        Board chessBoard = new Board();
        Square squareRow6 = chessBoard.getSquares(6,num);
        Piece pieceRow6 = squareRow6.getPiece();

        Piece pawn = new Pawn();

        assertEquals(Pawn.class, pieceRow6.getClass());
    }


    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfRow7IsEmpty(int num) {
        Board chessBoard = new Board();
        Square squareRow7 = chessBoard.getSquares(7,num);

        assertNull(squareRow7.getPiece());
    }







}
