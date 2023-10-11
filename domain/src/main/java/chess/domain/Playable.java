package chess.domain;

public interface Playable {

    public enum PieceEnum {
        Empty,
        Pawn,

    }

    PieceEnum getPieceForSquare(int rank, int file);
}


