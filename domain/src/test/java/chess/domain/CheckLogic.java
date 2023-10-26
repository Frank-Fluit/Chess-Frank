package chess.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckLogic {

    String whiteKingNotInCheck = "KEEEEEEE" +
            "PPEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "WWEEEEEE" +
            "VEEEEEEE" ;


    String whiteKingInCheckByQueen = "KEEEEEEU" +
            "PPEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "WWEEEEEE" +
            "VEEEEEEE" ;

    String whiteKingInCheckByRook = "KEEEEEEX" +
            "PPEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "WWEEEEEE" +
            "VEEEEEEE" ;

    String whiteKingInCheckByKnight = "KEEEEEEE" +
            "PPEEEEEE" +
            "EYEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "WWEEEEEE" +
            "VEEEEEEE" ;

    String whiteKingInCheckByBishop = "EEEEEEEK" +
            "PPEEEEZE" +
            "EYEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "WWEEEEEE" +
            "VEEEEEEE" ;

    String whiteKingInCheckByPawn = "EEEEEEEK" +
            "PPEEEEWE" +
            "EYEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "EEEEEEEE" +
            "WWEEEEEE" +
            "VEEEEEEE" ;




    @Test
    public void TestIfKingInCheckReturnsFalse(){
        Board chessBoard = new Board(whiteKingNotInCheck);

        Pawn pawn1_1 = (Pawn) chessBoard.getSquares(1,1).getPiece();
        King king0_0 = (King) chessBoard.getSquares(0,0).getPiece();

        Boolean isKingInCheck = pawn1_1.askKingIfInCheck();

        assertFalse(isKingInCheck);
    }

    @Test
    public void TestIfKingInCheckReturnsTrueWithQueen(){
        Board chessBoard = new Board(whiteKingInCheckByQueen);

        Pawn pawn1_1 = (Pawn) chessBoard.getSquares(1,1).getPiece();
        King king0_0 = (King) chessBoard.getSquares(0,0).getPiece();

        Boolean isKingInCheck = pawn1_1.askKingIfInCheck();

        assertTrue(isKingInCheck);
    }

    @Test
    public void TestIfKingInCheckReturnsTrueWithRook(){
        Board chessBoard = new Board(whiteKingInCheckByRook);

        Pawn pawn1_1 = (Pawn) chessBoard.getSquares(1,1).getPiece();
        King king0_0 = (King) chessBoard.getSquares(0,0).getPiece();

        Boolean isKingInCheck = pawn1_1.askKingIfInCheck();

        assertTrue(isKingInCheck);
    }

    @Test
    public void TestIfKingInCheckReturnsTrueWithKnight(){
        Board chessBoard = new Board(whiteKingInCheckByKnight);

        Pawn pawn1_1 = (Pawn) chessBoard.getSquares(1,1).getPiece();
        King king0_0 = (King) chessBoard.getSquares(0,0).getPiece();

        Boolean isKingInCheck = pawn1_1.askKingIfInCheck();

        assertTrue(isKingInCheck);
    }

    @Test
    public void TestIfKingInCheckReturnsTrueWithBishop(){
        Board chessBoard = new Board(whiteKingInCheckByBishop);

        Pawn pawn1_1 = (Pawn) chessBoard.getSquares(1,1).getPiece();
        King king0_0 = (King) chessBoard.getSquares(0,0).getPiece();

        Boolean isKingInCheck = pawn1_1.askKingIfInCheck();

        assertTrue(isKingInCheck);
    }

    @Test
    public void TestIfKingInCheckReturnsTrueWithPawn(){
        Board chessBoard = new Board(whiteKingInCheckByPawn);

        Pawn pawn1_1 = (Pawn) chessBoard.getSquares(1,1).getPiece();
        King king0_0 = (King) chessBoard.getSquares(0,0).getPiece();

        Boolean isKingInCheck = pawn1_1.askKingIfInCheck();

        assertTrue(isKingInCheck);
    }

}

