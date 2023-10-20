package chess.domain;

public interface Playable {

    Boolean isPLayersTurn(String colour);

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




}


