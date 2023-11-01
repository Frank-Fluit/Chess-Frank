package chess.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckMateLogic {

    String whiteKingNotInCheck = "KEEEEEEE" +
            "PPEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "WWEEEEEE" +
            "VEEEEEEE" ;

    String moveBeforeBackRankMate ="QEEEEEEK" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEWW" +
            "EEEEEEEV" ;

    String moveBeforeBackRankMateButWithEscape ="QEEEEEEK" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEW" +
            "EEEEEEWE" +
            "EEEEEEEV" ;

    String backRankMateWithTwoRooksMoveBefore ="QKEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "REEEEEEE" +
            "EREEEEEE" +
            "EEEEEEEV" ;


    @Test
    public void TestIfKingInCheckReturnsFalse(){
        Board chessBoard = new Board(whiteKingNotInCheck);
        Pawn pawn1_1 = (Pawn) chessBoard.getSquares(1,1).getPiece();

        Boolean isKingInCheck = pawn1_1.askKingIfInCheck();

        assertFalse(isKingInCheck);
    }
    @Test
    public void TestIfKingChangesStateWhenCheckmatedByQueen() {
        Board chessBoard = new Board(moveBeforeBackRankMate);
        Queen queen0_0 = (Queen) chessBoard.getSquares(0, 0).getPiece();
        King king7_7 = (King) chessBoard.getSquares(7, 7).getPiece();

        queen0_0.startAMove(7, 0);
        Boolean isCheckMate = king7_7.isCheckMate();

        assertTrue(isCheckMate);
    }

    @Test
    public void TestIfKingSeesItIsNotCheckMateWithEscapeSquare() {
        Board chessBoard = new Board(moveBeforeBackRankMateButWithEscape);
        Queen queen0_0 = (Queen) chessBoard.getSquares(0, 0).getPiece();
        King king7_7 = (King) chessBoard.getSquares(7, 7).getPiece();

        queen0_0.startAMove(7, 0);
        Boolean isCheckMate = king7_7.isCheckMate();

        assertFalse(isCheckMate);
    }

    @Test
    public void TestIfKingSeesisCheckMateAfterAttackByTwoRooks() {
        Board chessBoard = new Board(backRankMateWithTwoRooksMoveBefore);
        King blackKing7_7 = (King) chessBoard.getSquares(7, 7).getPiece();
        Rook whiteRook = (Rook) chessBoard.getSquares(5,0).getPiece();

        whiteRook.startAMove(7, 0);
        Boolean isCheckMate = blackKing7_7.isCheckMate();

        assertTrue(isCheckMate);
    }

}
