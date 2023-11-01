package chess.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RookLogic {

    String rookBoard = "EKEEEEEE" +
            "RRRRRRRR" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "XXXXXXXX" +
            "EVEEEEEE";

    String rookBoardSecond = "KREEEEXV" +
            "EREEEEXE" +
            "EREEEEXE" +
            "EREEEEXE" +
            "EREEEEXE" +
            "EREEEEXE" +
            "EREEEEXE" +
            "EREEEEXE";



    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfSingleWhiteMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow2= chessBoard.getSquares(2,num);
        Rook RookRow1 = (Rook)squareRow1.getPiece();

        RookRow1.startAMove(2,num);


        assertEquals(Rook.class, targetRow2.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfDoubleWhiteMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow3= chessBoard.getSquares(3,num);
        Rook RookRow1 = (Rook)squareRow1.getPiece();

        RookRow1.startAMove(3,num);


        assertEquals(Rook.class, targetRow3.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfTripleWhiteMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow4= chessBoard.getSquares(4,num);
        Rook RookRow1 = (Rook)squareRow1.getPiece();

        RookRow1.startAMove(4,num);


        assertEquals(Rook.class, targetRow4.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfQuadrupleWhiteMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow5= chessBoard.getSquares(5,num);
        Rook RookRow1 = (Rook)squareRow1.getPiece();

        RookRow1.startAMove(5,num);


        assertEquals(Rook.class, targetRow5.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    // Vertical Black Tests
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfSingleBlackMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);

        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow5= chessBoard.getSquares(5,num);
        Rook RookRow6 = (Rook)squareRow6.getPiece();

        RookRow6.startAMove(5,num);


        assertEquals(Rook.class, targetRow5.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfDoubleBlackMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);

        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow4= chessBoard.getSquares(4,num);
        Rook RookRow6 = (Rook)squareRow6.getPiece();

        RookRow6.startAMove(4,num);


        assertEquals(Rook.class, targetRow4.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfTripleBlackMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);

        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow3= chessBoard.getSquares(3,num);
        Rook RookRow6 = (Rook)squareRow6.getPiece();

        RookRow6.startAMove(3,num);


        assertEquals(Rook.class, targetRow3.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfQuadrupleBlackMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);

        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow2= chessBoard.getSquares(2,num);
        Rook RookRow6 = (Rook)squareRow6.getPiece();

        RookRow6.startAMove(2,num);


        assertEquals(Rook.class, targetRow2.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfSingleWhiteHorizontalMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoardSecond);
        Square squareCol1 = chessBoard.getSquares(num,1);
        Square targetCol2= chessBoard.getSquares(num,2);
        Rook RookCol1 = (Rook)squareCol1.getPiece();

        RookCol1.startAMove(num,2);


        assertEquals(Rook.class, targetCol2.getPiece().getClass());
        assertNull(squareCol1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfDoubleWhiteHorizontalMoveIsAllowed(int num){
        Board chessBoard2 = new Board(rookBoardSecond);
        Square squareCol1 = chessBoard2.getSquares(num,1);
        Square targetCol3= chessBoard2.getSquares(num,3);
        Rook RookCol1 = (Rook)squareCol1.getPiece();

        RookCol1.startAMove(num,3);


        assertEquals(Rook.class, targetCol3.getPiece().getClass());
        assertNull(squareCol1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfTripleWhiteHorizontalMoveIsAllowed(int num){
        Board chessBoard2 = new Board(rookBoardSecond);
        Square squareCol1 = chessBoard2.getSquares(num,1);
        Square targetCol4= chessBoard2.getSquares(num,4);
        Rook RookCol1 = (Rook)squareCol1.getPiece();

        RookCol1.startAMove(num,4);


        assertEquals(Rook.class, targetCol4.getPiece().getClass());
        assertNull(squareCol1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfQuadrupleWhiteHorizontalMoveIsAllowed(int num){
        Board chessBoard2 = new Board(rookBoardSecond);
        Square squareCol1 = chessBoard2.getSquares(num,1);
        Square targetCol5= chessBoard2.getSquares(num,5);
        Rook RookCol1 = (Rook)squareCol1.getPiece();

        RookCol1.startAMove(num,5);


        assertEquals(Rook.class, targetCol5.getPiece().getClass());
        assertNull(squareCol1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfSingleBlackHorizontalMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoardSecond);
        King whiteKing = (King)chessBoard.getSquares(0,0).getPiece();
        whiteKing.startAMove(1,0);

        Square squareCol6 = chessBoard.getSquares(num,6);
        Square targetCol5= chessBoard.getSquares(num,5);
        Rook RookCol6 = (Rook)squareCol6.getPiece();

        RookCol6.startAMove(num,5);


        assertEquals(Rook.class, targetCol5.getPiece().getClass());
        assertNull(squareCol6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfDoubleBlackHorizontalMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoardSecond);
        King whiteKing = (King)chessBoard.getSquares(0,0).getPiece();
        whiteKing.startAMove(1,0);

        Square squareCol6 = chessBoard.getSquares(num,6);
        Square targetCol4= chessBoard.getSquares(num,4);
        Rook RookCol6 = (Rook)squareCol6.getPiece();

        RookCol6.startAMove(num,4);


        assertEquals(Rook.class, targetCol4.getPiece().getClass());
        assertNull(squareCol6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfTripleBlackHorizontalMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoardSecond);
        King whiteKing = (King)chessBoard.getSquares(0,0).getPiece();
        whiteKing.startAMove(1,0);

        Square squareCol6 = chessBoard.getSquares(num,6);
        Square targetCol3= chessBoard.getSquares(num,3);
        Rook RookCol6 = (Rook)squareCol6.getPiece();

        RookCol6.startAMove(num,3);


        assertEquals(Rook.class, targetCol3.getPiece().getClass());
        assertNull(squareCol6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfQuadrupleBlackHorizontalMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoardSecond);
        King whiteKing = (King)chessBoard.getSquares(0,0).getPiece();
        whiteKing.startAMove(1,0);

        Square squareCol6 = chessBoard.getSquares(num,6);
        Square targetCol2= chessBoard.getSquares(num,2);
        Rook RookCol6 = (Rook)squareCol6.getPiece();

        RookCol6.startAMove(num,2);


        assertEquals(Rook.class, targetCol2.getPiece().getClass());
        assertNull(squareCol6.getPiece());
    }




}
