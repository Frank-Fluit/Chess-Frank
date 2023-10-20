package nl.sogyo.chess.chesscontroller.models;
import chess.domain.Playable;
import chess.domain.Square;




public class BoardDTO {

    SquareDTO[][] squares = new SquareDTO[8][8];
    private PlayerDTO[] players;
    public BoardDTO(Playable chess) {
        players = new PlayerDTO[2];

        players[0] = new PlayerDTO(chess, chess.getNameOfPlayerOne());
        players[1] = new PlayerDTO(chess, chess.getNameOfPlayerTwo());

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                this.squares[row][col] = new SquareDTO(chess.getPieceForSquare(row, col),chess.getColourPiece(row,col));
            }
        }
    }

    public BoardDTO(SquareDTO[][] squares) {
        this.squares = squares;
    }

    public SquareDTO[][] getSquares() {
        return squares;
    }

    public PlayerDTO[] getPlayers() {
        return players;
    }

    public void setPlayers(PlayerDTO[] players) {
        this.players = players;
    }



}