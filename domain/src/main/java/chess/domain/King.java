package chess.domain;

public class King extends Piece {

    public King(Square square,Board board, Player owner) {
        this.square = square;
        this.board = board;
        this.owner = owner;
    }
}
