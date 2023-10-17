package nl.sogyo.chess.chesscontroller.models;
import chess.domain.Playable;
import chess.domain.Square;




public class BoardDTO {

    SquareDTO[][] squares = new SquareDTO[8][8];
    public BoardDTO(Playable chess) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                this.squares[row][col] = new SquareDTO(chess.getPieceForSquare(row, col));
            }
        }
    }

    public BoardDTO(SquareDTO[][] squares) {
        this.squares = squares;
    }

    public SquareDTO[][] getSquares() {
        return squares;
    }


}