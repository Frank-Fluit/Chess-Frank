package chess.domain;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class PlayerLogic {

    @Test
    public void testNewPlayerHasTurn() {
        Player player = new Player();
        assertTrue(player.getHasTurn());
    }

    @Test
    public void checkIfPlayerKnowsOtherPlayer() {
        Player player1 = new Player();

        assertNotNull(player1.getOpponent());
    }

    @Test
    public void checkIfOpponentOfOpponentIsOriginalPlayer(){
        Player player1 = new Player();
        Player player2 = player1.getOpponent();

        assertSame(player1, player2.getOpponent());
    }


    @Test
    public void checkIfTurnSwitchesAfterMove() {
        Board chessBoard = new Board();
        Square square= chessBoard.squares[1][1];
        Piece pawnPlayer1 = square.getPiece();
        //Player pawnPlayer1.getOwner(); // to be implemented


        assertEquals(true, true);
    }



    @Test
    public void checkIfTurnSwitches() {


        assertEquals(true, true);
    }




}
