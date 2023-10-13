package chess.domain;

public class Pawn extends Piece{

    public Pawn(){

    }


    public Pawn(int row, int col,Board board) {
        this.row = row;
        this.col = col;
        this.board = board;
    }


}
