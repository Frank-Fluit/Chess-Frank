package chess.domain;

public class Pawn extends Piece{

    public Pawn(){

    }

    public Pawn(Square square,Board board, Player owner) {
        this.square = square;
        this.board = board;
        this.owner = owner;
    }



}
