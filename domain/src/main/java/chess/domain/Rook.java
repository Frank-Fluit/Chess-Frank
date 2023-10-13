package chess.domain;

public class Rook extends Piece {
    public Rook(Square square,Board board, Player owner) {
        this.square = square;
        this.board = board;
        this.owner = owner;
    }
}
