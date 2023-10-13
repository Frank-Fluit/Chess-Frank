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

    public void empty(){
        this.piece = null;
    }

    public void update(Piece piece){
        this.piece = piece;
    }


}