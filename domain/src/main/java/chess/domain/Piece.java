package chess.domain;

public abstract class Piece {
    int row;
    int col;
    Board board;

    public Piece() {

    }

    public Piece(int row, int col){
        this.row = row;
        this.col = col;
    }

    void doMove(int targetRow, int targetCol){
        //TODO : legalmovecheck
        this.board.getSquares(this.row,this.col).empty();
        Square targetSquare = this.board.getSquares(targetRow,targetCol);
        targetSquare.update(this);
        this.row = targetRow;
        this.col =targetCol;

    }
}



