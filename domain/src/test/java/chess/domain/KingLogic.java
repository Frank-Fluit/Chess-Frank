package chess.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class KingLogic {

    @Test
    public void testMovesLeftWhiteKnight_1() {
        Board chessBoard = new Board();
        Square leftWhiteKnightSquare = chessBoard.getSquares(0,1);
        Knight leftWhiteKnight = (Knight)leftWhiteKnightSquare.getPiece();

        leftWhiteKnight.startAMove(2,0);

        assertEquals(Knight.class, chessBoard.getSquares(2,0).getPiece().getClass());
        assertNull(leftWhiteKnightSquare.getPiece());
    }
}
