package chess.domain;

public class ChessGame implements Playable{

    private Board chessBoard;

    public ChessGame(){
        chessBoard = new Board();
    }
    @Override
    public PieceEnum getPieceForSquare(int rank, int file) {
        return PieceEnum.Pawn;
    }
}

