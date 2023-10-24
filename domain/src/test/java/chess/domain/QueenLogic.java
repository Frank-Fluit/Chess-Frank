package chess.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class QueenLogic {
    String queenBoard = "EKKKKKKK" +
            "QQQQQQQQ" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "UUUUUUUU" +
            "EVVVVVVV";

    String queenBoardSecond = "KQEEEEUV" +
            "EQEEEEUE" +
            "EQEEEEUE" +
            "EQEEEEUE" +
            "EQEEEEUE" +
            "EQEEEEUE" +
            "EQEEEEUE" +
            "EQEEEEUE";

    String diagonalTestBoard = "EKKKKKKK" +
            "QQQQQQQQ" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "UUUUUUUU" +
            "EVVVVVVV";



    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfSingleWhiteMoveIsAllowed(int num){
        Board chessBoard = new Board(queenBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow2= chessBoard.getSquares(2,num);
        Queen QueenRow1 = (Queen)squareRow1.getPiece();

        QueenRow1.startAMove(2,num);


        assertEquals(Queen.class, targetRow2.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfDoubleWhiteMoveIsAllowed(int num){
        Board chessBoard = new Board(queenBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow3= chessBoard.getSquares(3,num);
        Queen QueenRow1 = (Queen)squareRow1.getPiece();

        QueenRow1.startAMove(3,num);


        assertEquals(Queen.class, targetRow3.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfTripleWhiteMoveIsAllowed(int num){
        Board chessBoard = new Board(queenBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow4= chessBoard.getSquares(4,num);
        Queen QueenRow1 = (Queen)squareRow1.getPiece();

        QueenRow1.startAMove(4,num);


        assertEquals(Queen.class, targetRow4.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfQuadrupleWhiteMoveIsAllowed(int num){
        Board chessBoard = new Board(queenBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow5= chessBoard.getSquares(5,num);
        Queen QueenRow1 = (Queen)squareRow1.getPiece();

        QueenRow1.startAMove(5,num);


        assertEquals(Queen.class, targetRow5.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    // Vertical Black Tests
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfSingleBlackMoveIsAllowed(int num){
        Board chessBoard = new Board(queenBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);

        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow5= chessBoard.getSquares(5,num);
        Queen QueenRow6 = (Queen)squareRow6.getPiece();

        QueenRow6.startAMove(5,num);


        assertEquals(Queen.class, targetRow5.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfDoubleBlackMoveIsAllowed(int num){
        Board chessBoard = new Board(queenBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);

        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow4= chessBoard.getSquares(4,num);
        Queen QueenRow6 = (Queen)squareRow6.getPiece();

        QueenRow6.startAMove(4,num);


        assertEquals(Queen.class, targetRow4.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfTripleBlackMoveIsAllowed(int num){
        Board chessBoard = new Board(queenBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);

        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow3= chessBoard.getSquares(3,num);
        Queen QueenRow6 = (Queen)squareRow6.getPiece();

        QueenRow6.startAMove(3,num);


        assertEquals(Queen.class, targetRow3.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfQuadrupleBlackMoveIsAllowed(int num){
        Board chessBoard = new Board(queenBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);

        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow2= chessBoard.getSquares(2,num);
        Queen QueenRow6 = (Queen)squareRow6.getPiece();

        QueenRow6.startAMove(2,num);


        assertEquals(Queen.class, targetRow2.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfSingleWhiteHorizontalMoveIsAllowed(int num){
        Board chessBoard = new Board(queenBoardSecond);
        Square squareCol1 = chessBoard.getSquares(num,1);
        Square targetCol2= chessBoard.getSquares(num,2);
        Queen QueenCol1 = (Queen)squareCol1.getPiece();

        QueenCol1.startAMove(num,2);


        assertEquals(Queen.class, targetCol2.getPiece().getClass());
        assertNull(squareCol1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfDoubleWhiteHorizontalMoveIsAllowed(int num){
        Board chessBoard2 = new Board(queenBoardSecond);
        Square squareCol1 = chessBoard2.getSquares(num,1);
        Square targetCol3= chessBoard2.getSquares(num,3);
        Queen QueenCol1 = (Queen)squareCol1.getPiece();

        QueenCol1.startAMove(num,3);


        assertEquals(Queen.class, targetCol3.getPiece().getClass());
        assertNull(squareCol1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfTripleWhiteHorizontalMoveIsAllowed(int num){
        Board chessBoard2 = new Board(queenBoardSecond);
        Square squareCol1 = chessBoard2.getSquares(num,1);
        Square targetCol4= chessBoard2.getSquares(num,4);
        Queen QueenCol1 = (Queen)squareCol1.getPiece();

        QueenCol1.startAMove(num,4);


        assertEquals(Queen.class, targetCol4.getPiece().getClass());
        assertNull(squareCol1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfQuadrupleWhiteHorizontalMoveIsAllowed(int num){
        Board chessBoard2 = new Board(queenBoardSecond);
        Square squareCol1 = chessBoard2.getSquares(num,1);
        Square targetCol5= chessBoard2.getSquares(num,5);
        Queen QueenCol1 = (Queen)squareCol1.getPiece();

        QueenCol1.startAMove(num,5);


        assertEquals(Queen.class, targetCol5.getPiece().getClass());
        assertNull(squareCol1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfSingleBlackHorizontalMoveIsAllowed(int num){
        Board chessBoard = new Board(queenBoardSecond);
        King whiteKing = (King)chessBoard.getSquares(0,0).getPiece();
        whiteKing.startAMove(1,0);

        Square squareCol6 = chessBoard.getSquares(num,6);
        Square targetCol5= chessBoard.getSquares(num,5);
        Queen QueenCol6 = (Queen)squareCol6.getPiece();

        QueenCol6.startAMove(num,5);


        assertEquals(Queen.class, targetCol5.getPiece().getClass());
        assertNull(squareCol6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfDoubleBlackHorizontalMoveIsAllowed(int num){
        Board chessBoard = new Board(queenBoardSecond);
        King whiteKing = (King)chessBoard.getSquares(0,0).getPiece();
        whiteKing.startAMove(1,0);

        Square squareCol6 = chessBoard.getSquares(num,6);
        Square targetCol4= chessBoard.getSquares(num,4);
        Queen QueenCol6 = (Queen)squareCol6.getPiece();

        QueenCol6.startAMove(num,4);


        assertEquals(Queen.class, targetCol4.getPiece().getClass());
        assertNull(squareCol6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfTripleBlackHorizontalMoveIsAllowed(int num){
        Board chessBoard = new Board(queenBoardSecond);
        King whiteKing = (King)chessBoard.getSquares(0,0).getPiece();
        whiteKing.startAMove(1,0);

        Square squareCol6 = chessBoard.getSquares(num,6);
        Square targetCol3= chessBoard.getSquares(num,3);
        Queen QueenCol6 = (Queen)squareCol6.getPiece();

        QueenCol6.startAMove(num,3);


        assertEquals(Queen.class, targetCol3.getPiece().getClass());
        assertNull(squareCol6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfQuadrupleBlackHorizontalMoveIsAllowed(int num){
        Board chessBoard = new Board(queenBoardSecond);
        King whiteKing = (King)chessBoard.getSquares(0,0).getPiece();
        whiteKing.startAMove(1,0);

        Square squareCol6 = chessBoard.getSquares(num,6);
        Square targetCol2= chessBoard.getSquares(num,2);
        Queen QueenCol6 = (Queen)squareCol6.getPiece();

        QueenCol6.startAMove(num,2);


        assertEquals(Queen.class, targetCol2.getPiece().getClass());
        assertNull(squareCol6.getPiece());
    }





    // DIAGONAL TESTS

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6})
    public void TestIfSingleRightDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow2= chessBoard.getSquares(2,num +1);
        Queen QueenRow1 = (Queen)squareRow1.getPiece();

        QueenRow1.startAMove(2,num+1);


        assertEquals(Queen.class, targetRow2.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5})
    public void TestIfDoubleRightDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow3= chessBoard.getSquares(3,num + 2);
        Queen QueenRow1 = (Queen)squareRow1.getPiece();

        QueenRow1.startAMove(3,num+2);


        assertEquals(Queen.class, targetRow3.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4})
    public void TestIfTripleRightDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        Board chessBoard2= new Board();
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow4= chessBoard.getSquares(4,num + 3);
        Queen QueenRow1 = (Queen)squareRow1.getPiece();

        QueenRow1.startAMove(4,num + 3);


        assertEquals(Queen.class, targetRow4.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public void TestIfSingleLeftDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow2= chessBoard.getSquares(2,num - 1);
        Queen QueenRow1 = (Queen)squareRow1.getPiece();

        QueenRow1.startAMove(2,num -1);


        assertEquals(Queen.class, targetRow2.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5,6,7})
    public void TestIfDoubleLeftDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow3= chessBoard.getSquares(3,num - 2);
        Queen QueenRow1 = (Queen)squareRow1.getPiece();

        QueenRow1.startAMove(3,num - 2);


        assertEquals(Queen.class, targetRow3.getPiece().getClass());
        assertNull(squareRow1.getPiece());

    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6,7})
    public void TestIfTripleLeftDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow4= chessBoard.getSquares(4,num - 3);
        Queen QueenRow1 = (Queen)squareRow1.getPiece();

        QueenRow1.startAMove(4,num - 3);


        assertEquals(Queen.class, targetRow4.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    public void TestIfQuadrupleRightDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow5= chessBoard.getSquares(5,num + 4);
        Queen QueenRow1 = (Queen)squareRow1.getPiece();

        QueenRow1.startAMove(5,num + 4);


        assertEquals(Queen.class, targetRow5.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7})
    public void TestIfQuadrupleLeftDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(diagonalTestBoard);


        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow5= chessBoard.getSquares(5,num - 4);
        Queen QueenRow1 = (Queen)squareRow1.getPiece();

        QueenRow1.startAMove(5,num - 4);


        assertEquals(Queen.class, targetRow5.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }


    // black moves


    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6})
    public void TestIfSingleRightDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow5= chessBoard.getSquares(5,num +1);
        Queen QueenRow6 = (Queen)squareRow6.getPiece();

        QueenRow6.startAMove(5,num+1);


        assertEquals(Queen.class, targetRow5.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5})
    public void TestIfDoubleRightDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);

        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow4= chessBoard.getSquares(4,num + 2);
        Queen QueenRow6 = (Queen)squareRow6.getPiece();

        QueenRow6.startAMove(4,num+2);


        assertEquals(Queen.class, targetRow4.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4})
    public void TestIfTripleRightDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow3 = chessBoard.getSquares(3,num + 3);
        Queen QueenRow6 = (Queen)squareRow6.getPiece();

        QueenRow6.startAMove(3,num + 3);


        assertEquals(Queen.class, targetRow3.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public void TestIfSingleLeftDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow5= chessBoard.getSquares(5,num - 1);
        Queen QueenRow6 = (Queen)squareRow6.getPiece();

        QueenRow6.startAMove(5,num -1);


        assertEquals(Queen.class, targetRow5.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5,6,7})
    public void TestIfDoubleLeftDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow4= chessBoard.getSquares(4,num - 2);
        Queen QueenRow6 = (Queen)squareRow6.getPiece();

        QueenRow6.startAMove(4,num - 2);


        assertEquals(Queen.class, targetRow4.getPiece().getClass());
        assertNull(squareRow6.getPiece());

    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6,7})
    public void TestIfTripleLeftDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow3= chessBoard.getSquares(3,num - 3);
        Queen QueenRow6 = (Queen)squareRow6.getPiece();

        QueenRow6.startAMove(3,num - 3);


        assertEquals(Queen.class, targetRow3.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    public void TestIfQuadrupleRightDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow2= chessBoard.getSquares(2,num + 4);
        Queen QueenRow6 = (Queen)squareRow6.getPiece();

        QueenRow6.startAMove(2,num + 4);


        assertEquals(Queen.class, targetRow2.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7})
    public void TestIfQuadrupleLeftDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(diagonalTestBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow2= chessBoard.getSquares(2,num - 4);
        Queen QueenRow6 = (Queen)squareRow6.getPiece();

        QueenRow6.startAMove(2,num - 4);


        assertEquals(Queen.class, targetRow2.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }
}
