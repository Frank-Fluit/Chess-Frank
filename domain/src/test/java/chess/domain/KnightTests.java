package chess.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTests {

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

}
