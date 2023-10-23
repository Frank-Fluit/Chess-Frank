package chess.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RookLogic {

    String rookBoard = "EKKKKKKK" +
            "RRRRRRRR" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "XXXXXXXX" +
            "EVVVVVVV";

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5,6,7})
    public void TestIfSingleWhiteMoveIsAllowed(int num){
        Board chessBoard = new Board(rookBoard);
        Square squareRow1 = chessBoard.getSquares(1,num);
        Square targetRow2= chessBoard.getSquares(2,num +1);
        Bisshop BishopRow1 = (Bisshop)squareRow1.getPiece();

        BishopRow1.startAMove(2,num+1);


        assertEquals(Bisshop.class, targetRow2.getPiece().getClass());
        assertNull(squareRow1.getPiece());
    }
}
