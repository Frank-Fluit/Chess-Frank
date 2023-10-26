package chess.domain;

public abstract class Piece {

    Board board;
    Square square;

    Player owner;

    public Piece() {

    }

    public Piece(Square square, Board board) {
        this.square = square;
        this.board = board;
    }

    public Square getParentSquare() {
        return this.square;
    }

    public Player getOwner() {
        return owner;
    }

    public abstract void startAMove(int targetRow, int targetCol);

    protected abstract boolean seesKing(Square squareEnemyKing);

    public Boolean askKingIfInCheck() {
        if(this.getClass() == King.class){
            return false;
        }
        for (int i = 0; i <= 63; i++) {
            Square square = board.getSquareIndex(i);
            Piece piece = square.getPiece();
            if (piece != null && piece instanceof King && piece.getOwner() == this.getOwner()) {
                return ((King) piece).isCheck();
            }
        }

        return null;
    }

}



