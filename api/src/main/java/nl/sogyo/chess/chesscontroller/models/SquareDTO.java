package nl.sogyo.chess.chesscontroller.models;
import chess.domain.Playable;


public class SquareDTO {
    private Playable.PieceEnum PieceEnum;
    private String colour;

    public SquareDTO(Playable.PieceEnum PieceEnum, String colour) {
        this.PieceEnum = PieceEnum;
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

    public Playable.PieceEnum getPieceEnum() {
        return PieceEnum;
    }

    public void setPieceEnum(Playable.PieceEnum pieceEnum) {
        PieceEnum = pieceEnum;
    }
}


