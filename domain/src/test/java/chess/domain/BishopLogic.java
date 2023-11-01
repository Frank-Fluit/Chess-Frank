package chess.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BishopLogic {

    String checkOtherPieceBoard_2 = "KKKKKKKK" +
            "BBBBBBBB" +
            "EEEEEEEE" +
            "HHHHHHHH" +
            "RRRRRRRR" +
            "QQQQQQQQ" +
            "ZZZZZZZZ" +
            "VVVVVVVV";



    String checkOtherPieceBoard = "KKKKKKKK" +
            "PPPPPPPP" +
            "XXXXXXXX" +
            "YYYYYYYY" +
            "UUUUUUUU" +
            "WWWWWWWW" +
            "WWWWWWWW" +
            "VVVVVVVV";

    String BishopBoard = "EKKKKKKK" +
            "BBBBBBBB" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "ZZZZZZZZ" +
            "EVVVVVVV";
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfTestBoardConstructorWorks(int num) {
        Board chessBoard = new Board(checkOtherPieceBoard_2);

        assertEquals(King.class, chessBoard.getSquares(0,num).getPiece().getClass());
        assertEquals(Bisshop.class, chessBoard.getSquares(1,num).getPiece().getClass());
        assertNull(chessBoard.getSquares(2,num).getPiece());
        assertEquals(Knight.class, chessBoard.getSquares(3,num).getPiece().getClass());
        assertEquals(Rook.class, chessBoard.getSquares(4,num).getPiece().getClass());
        assertEquals(Queen.class, chessBoard.getSquares(5,num).getPiece().getClass());
        assertEquals(Bisshop.class, chessBoard.getSquares(6,num).getPiece().getClass());
        assertEquals(King.class, chessBoard.getSquares(7,num).getPiece().getClass());

    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void testIfTestBoardConstructorWorks_2(int num) {
        Board chessBoard = new Board(checkOtherPieceBoard);

        assertEquals(Pawn.class, chessBoard.getSquares(1,num).getPiece().getClass());
        assertEquals(Rook.class, chessBoard.getSquares(2,num).getPiece().getClass());
        assertEquals(Knight.class, chessBoard.getSquares(3,num).getPiece().getClass());
        assertEquals(Queen.class, chessBoard.getSquares(4,num).getPiece().getClass());
        assertEquals(Pawn.class, chessBoard.getSquares(5,num).getPiece().getClass());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6})
    public void TestIfSingleRightDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(BishopBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow2= chessBoard.getSquares(2,num +1);
        Bisshop BishopRow1 = (Bisshop)squareRow1.getPiece();

        BishopRow1.startAMove(2,num+1);


        assertEquals(Bisshop.class, targetRow2.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5})
    public void TestIfDoubleRightDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(BishopBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow3= chessBoard.getSquares(3,num + 2);
        Bisshop BishopRow1 = (Bisshop)squareRow1.getPiece();

        BishopRow1.startAMove(3,num+2);


        assertEquals(Bisshop.class, targetRow3.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4})
    public void TestIfTripleRightDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(BishopBoard);
        Board chessBoard2= new Board();
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow4= chessBoard.getSquares(4,num + 3);
        Bisshop BishopRow1 = (Bisshop)squareRow1.getPiece();

        BishopRow1.startAMove(4,num + 3);


        assertEquals(Bisshop.class, targetRow4.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

//    @ParameterizedTest
//    @ValueSource(ints = {1,2,3,4,5,6,7})
//    public void TestIfSingleLeftDiagonalMoveIsAllowed(int num){
//        Board chessBoard = new Board(BishopBoard);
//        Square squareRow1 = chessBoard.getSquares(1,num);
//        Square targetRow2= chessBoard.getSquares(2,num - 1);
//        Bisshop BishopRow1 = (Bisshop)squareRow1.getPiece();
//
//        BishopRow1.startAMove(2,num -1);
//
//
//        assertEquals(Bisshop.class, targetRow2.getPiece().getClass());
//        assertNull(squareRow1.getPiece());
//    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6,7})
    public void TestIfDoubleLeftDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(BishopBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow3= chessBoard.getSquares(3,num - 2);
        Bisshop BishopRow1 = (Bisshop)squareRow1.getPiece();

        BishopRow1.startAMove(3,num - 2);


        assertEquals(Bisshop.class, targetRow3.getPiece().getClass());
        assertNull(squareRow1.getPiece());

    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6,7})
    public void TestIfTripleLeftDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(BishopBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow4= chessBoard.getSquares(4,num - 3);
        Bisshop BishopRow1 = (Bisshop)squareRow1.getPiece();

        BishopRow1.startAMove(4,num - 3);


        assertEquals(Bisshop.class, targetRow4.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    public void TestIfQuadrupleRightDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(BishopBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow5= chessBoard.getSquares(5,num + 4);
        Bisshop BishopRow1 = (Bisshop)squareRow1.getPiece();

        BishopRow1.startAMove(5,num + 4);


        assertEquals(Bisshop.class, targetRow5.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7})
    public void TestIfQuadrupleLeftDiagonalMoveIsAllowed(int num){
        Board chessBoard = new Board(BishopBoard);


        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow5= chessBoard.getSquares(5,num - 4);
        Bisshop BishopRow1 = (Bisshop)squareRow1.getPiece();

        BishopRow1.startAMove(5,num - 4);


        assertEquals(Bisshop.class, targetRow5.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }



//    @ParameterizedTest
//    @ValueSource(ints = {0,1,2,3,4,5,6})
//    public void TestIfSingleRightDiagonalMoveIsAllowedBlack(int num){
//        Board chessBoard = new Board(BishopBoard);
//        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
//        whiteKing.startAMove(0,0);
//        Square squareRow6 = chessBoard.getSquares(6,num);
//        Square targetRow5= chessBoard.getSquares(5,num +1);
//        Bisshop BishopRow6 = (Bisshop)squareRow6.getPiece();
//
//        BishopRow6.startAMove(5,num+1);
//
//
//        assertEquals(Bisshop.class, targetRow5.getPiece().getClass());
//        assertNull(squareRow6.getPiece());
//    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5})
    public void TestIfDoubleRightDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(BishopBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);

        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow4= chessBoard.getSquares(4,num + 2);
        Bisshop BishopRow6 = (Bisshop)squareRow6.getPiece();

        BishopRow6.startAMove(4,num+2);


        assertEquals(Bisshop.class, targetRow4.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4})
    public void TestIfTripleRightDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(BishopBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow3 = chessBoard.getSquares(3,num + 3);
        Bisshop BishopRow6 = (Bisshop)squareRow6.getPiece();

        BishopRow6.startAMove(3,num + 3);


        assertEquals(Bisshop.class, targetRow3.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

//    @ParameterizedTest
//    @ValueSource(ints = {1,2,3,4,5,6,7})
//    public void TestIfSingleLeftDiagonalMoveIsAllowedBlack(int num){
//        Board chessBoard = new Board(BishopBoard);
//        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
//        whiteKing.startAMove(0,0);
//        Square squareRow6 = chessBoard.getSquares(6,num);
//        Square targetRow5= chessBoard.getSquares(5,num - 1);
//        Bisshop BishopRow6 = (Bisshop)squareRow6.getPiece();
//
//        BishopRow6.startAMove(5,num -1);
//
//
//        assertEquals(Bisshop.class, targetRow5.getPiece().getClass());
//        assertNull(squareRow6.getPiece());
//    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6,7})
    public void TestIfDoubleLeftDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(BishopBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow4= chessBoard.getSquares(4,num - 2);
        Bisshop BishopRow6 = (Bisshop)squareRow6.getPiece();

        BishopRow6.startAMove(4,num - 2);


        assertEquals(Bisshop.class, targetRow4.getPiece().getClass());
        assertNull(squareRow6.getPiece());

    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,5,6,7})
    public void TestIfTripleLeftDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(BishopBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow3= chessBoard.getSquares(3,num - 3);
        Bisshop BishopRow6 = (Bisshop)squareRow6.getPiece();

        BishopRow6.startAMove(3,num - 3);


        assertEquals(Bisshop.class, targetRow3.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    public void TestIfQuadrupleRightDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(BishopBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow2= chessBoard.getSquares(2,num + 4);
        Bisshop BishopRow6 = (Bisshop)squareRow6.getPiece();

        BishopRow6.startAMove(2,num + 4);


        assertEquals(Bisshop.class, targetRow2.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7})
    public void TestIfQuadrupleLeftDiagonalMoveIsAllowedBlack(int num){
        Board chessBoard = new Board(BishopBoard);
        King whiteKing = (King)chessBoard.getSquares(0,1).getPiece();
        whiteKing.startAMove(0,0);
        Square squareRow6 = chessBoard.getSquares(6,num);
        Square targetRow2= chessBoard.getSquares(2,num - 4);
        Bisshop BishopRow6 = (Bisshop)squareRow6.getPiece();

        BishopRow6.startAMove(2,num - 4);


        assertEquals(Bisshop.class, targetRow2.getPiece().getClass());
        assertNull(squareRow6.getPiece());
    }

}
