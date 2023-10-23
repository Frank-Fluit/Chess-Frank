package nl.sogyo.chess.chesscontroller.models;

import chess.domain.Playable;

public class PlayerDTO {
    private String name;
    private Boolean hasTurn;

    private String colour;

    public PlayerDTO( Playable chess, String name, String colour) {
        this.name = name;
        this.colour = colour;
        this.hasTurn = chess.isPLayersTurn(colour);
    }

    public Boolean getHasTurn() {
        return hasTurn;
    }

    public void setHasTurn(Boolean hasTurn) {
        this.hasTurn = hasTurn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}