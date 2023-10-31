package nl.sogyo.chess.chesscontroller.models;
import chess.domain.Playable;


public class SquareDTO {
    private Playable.PieceEnum PieceEnum;
    private String colour;

    private Boolean reachableSquare;

    public SquareDTO(Playable.PieceEnum PieceEnum, String colour, Boolean reachableSquare ) {
        this.PieceEnum = PieceEnum;
        this.colour = colour;
        this.reachableSquare =reachableSquare;
    }

    public Boolean getReachableSquare() {
        return reachableSquare;
    }

    public void setReachableSquare(Boolean reachableSquare) {
        this.reachableSquare = reachableSquare;
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


