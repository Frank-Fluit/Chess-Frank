package nl.sogyo.chess.chesscontroller.models;

public class SingleSquareDTO {
    int[] originSquare;

    public SingleSquareDTO() {
    }

    public SingleSquareDTO(int[] originSquare) {
        this.originSquare = originSquare;
    }

    public int[] getOriginSquare() {
        return originSquare;
    }

    public void setOriginSquare(int[] originSquare) {
        this.originSquare = originSquare;
    }

}
