package chess.domain;

public class Queen extends Piece{

    public Queen(Square square,Board board, Player owner) {
        this.square = square;
        this.board = board;
        this.owner = owner;
    }
}
