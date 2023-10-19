package nl.sogyo.chess.chesscontroller.models;

public class MoveDTO {
    int[] originSquare;
    int[] targetSquare;

    public MoveDTO(int[] originSquare, int[] targetSquare) {
        this.originSquare = originSquare;
        this.targetSquare = targetSquare;
    }

    public int[] getOriginSquare() {
        return originSquare;
    }

    public void setOriginSquare(int[] originSquare) {
        this.originSquare = originSquare;
    }

    public int[] getTargetSquare() {
        return targetSquare;
    }

    public void setTargetSquare(int[] targetSquare) {
        this.targetSquare = targetSquare;
    }
}
