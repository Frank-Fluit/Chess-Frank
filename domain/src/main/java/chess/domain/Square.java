package chess.domain;

public class Square {
    Piece piece;

    public Square(){

    }

    public Square(Piece piece){
        this.piece = piece;
    }

    protected Piece getPiece() {
        return this.piece;
    }
}