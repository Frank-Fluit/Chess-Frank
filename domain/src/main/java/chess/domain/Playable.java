package chess.domain;

public interface Playable {

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


}


