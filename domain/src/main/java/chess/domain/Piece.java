package chess.domain;

public abstract class Piece {

    Board board;
    Square square;

    Player owner;

    public Piece() {

    }

    public Piece(Square square, Board board){
        this.square = square;
        this.board = board;
    }

//    void doMove(int targetRow, int targetCol){
//        //TODO : legalmovecheck
//        this.board.getSquares(this.row,this.col).empty();
//        Square targetSquare = this.board.getSquares(targetRow,targetCol);
//        targetSquare.update(this);
//        this.row = targetRow;
//        this.col =targetCol;
//
//    }
}



