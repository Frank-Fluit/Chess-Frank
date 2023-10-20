package chess.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class PawnLogic {

    // Does not test if
    
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

    @Test
    public void testIfFourMovesAreAllowed(){
        Board chessBoard = new Board();

        //White Pawn
        Pawn pawn1_0  = (Pawn) chessBoard.getSquares(1,0).getPiece();
        pawn1_0.startAMove(2,0);

        //Black Pawn
        Pawn pawn6_0 = (Pawn) chessBoard.getSquares(6,0).getPiece();
        pawn6_0.startAMove(5,0);

        //White Pawn
        Pawn pawn2_0 = (Pawn) chessBoard.getSquares(2,0).getPiece();
        pawn2_0.startAMove(3,0);

        //Black Pawn
        Pawn pawn5_0 = (Pawn) chessBoard.getSquares(5,0).getPiece();
        pawn5_0.startAMove(4,0);


        //Access square (3,0)
        assertEquals(Pawn.class, chessBoard.getSquares(3,0).getPiece().getClass());
        assertEquals(Pawn.class, chessBoard.getSquares(4,0).getPiece().getClass());


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

    @Test
    public void testIfImpossibleToJumpOverOtherPieceOnFirstMove(){
        Board chessBoard = new Board();

        //White Pawn
        Pawn pawn1_0  = (Pawn) chessBoard.getSquares(1,0).getPiece();
        pawn1_0.startAMove(2,0);


        //Black Pawn
        Pawn pawn6_4 = (Pawn) chessBoard.getSquares(6,4).getPiece();
        pawn6_4.startAMove(4,4);


        // White Pawn
        Pawn pawn2_0  = (Pawn) chessBoard.getSquares(2,0).getPiece();
        pawn2_0.startAMove(3,0);

        //Black Pawn
        Pawn pawn4_4 = (Pawn) chessBoard.getSquares(4,4).getPiece();
        pawn4_4.startAMove(3,4); // This move does not work?

       // White Pawn
        Pawn pawn3_0  = (Pawn) chessBoard.getSquares(3,0).getPiece();
        pawn3_0.startAMove(4,0);

      //Black Pawn
        Pawn pawn3_4 = (Pawn) chessBoard.getSquares(3,4).getPiece();
        pawn3_4.startAMove(2,4);

       // Other White Pawn
       Pawn pawn1_4 = (Pawn) chessBoard.getSquares(1,4).getPiece();
       pawn1_4.startAMove(3,4);



        assertNull(chessBoard.getSquares(3,4).getPiece());
        assertEquals(Pawn.class, chessBoard.getSquares(1,4).getPiece().getClass());
        assertEquals(Pawn.class, chessBoard.getSquares(2,4).getPiece().getClass());
        assertEquals(Pawn.class, chessBoard.getSquares(4,0).getPiece().getClass());
    }

    // pawn can capture sideways
    //pionnen kunnen twee keer een dubbele zet doen
    //pionnen kunnen rechtdoorslaan


}
