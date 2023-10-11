package nl.sogyo.chess.chesscontroller.models;
import chess.domain.Playable;


public class SquareDTO {
    private Playable.PieceEnum PieceEnum;

    public SquareDTO(Playable.PieceEnum PieceEnum) {
        this.PieceEnum = PieceEnum;
    }
}


