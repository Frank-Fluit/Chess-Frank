package nl.sogyo.chess.chesscontroller.models;

import chess.domain.Playable;

public class GameStateDTO {
    private Playable.Winner gameState;
    public GameStateDTO(Playable chess) {
        gameState = chess.getWinner();
    }

    public Playable.Winner getGameState() {
        return gameState;
    }

    public void setGameState(Playable.Winner gameState) {
        gameState = gameState;
    }
}
