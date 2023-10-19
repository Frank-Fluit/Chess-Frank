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

    public Square getParentSquare(){
        return this.square;
    }

    public Player getOwner() {
        return owner;
    }

    public abstract void startAMove(int targetRow, int targetCol);
}



