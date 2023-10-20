package nl.sogyo.chess.chesscontroller.models;

import chess.domain.Playable;

public class PlayerDTO {
    private String name;

    public PlayerDTO( Playable chess, String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}