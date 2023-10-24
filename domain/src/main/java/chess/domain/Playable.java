package chess.domain;

public interface Playable {

    Boolean isPLayersTurn(String colour);

    public enum Winner {
        NO_ONE,
        PLAYER_1,
        PLAYER_2,

    }


    public enum PieceEnum {
        Empty,
        Pawn,
        Bisshop,
        King,
        Knight,
        Queen,
        Rook

    }

    PieceEnum getPieceForSquare(int rank, int file);
    String getColourPiece(int rank, int file);
    String getNameOfPlayerOne();
    String getNameOfPlayerTwo();
    void playPiece(int[] originSquare, int[] targetSquare);

    boolean isEndOfGame();

    Winner getWinner();




}


