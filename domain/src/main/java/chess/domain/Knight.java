package chess.domain;

public class Knight extends Piece {

    public Knight(Square square,Board board, Player owner) {
        this.square = square;
        this.board = board;
        this.owner = owner;
    }
}
