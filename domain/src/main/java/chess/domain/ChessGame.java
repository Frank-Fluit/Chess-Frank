package chess.domain;

public class ChessGame implements Playable{

    private Board chessBoard;

    public ChessGame(){
        chessBoard = new Board();
    }
    @Override
    public PieceEnum getPieceForSquare(int rank, int file) {
        Square square = chessBoard.getSquares(rank, file);

        if(square.getPiece() == null){
            return PieceEnum.Empty;
        }

        if(square.getPiece().getClass().equals(Pawn.class)){
            return PieceEnum.Pawn;
        }

        if(square.getPiece().getClass().equals(Bisshop.class)){
            return PieceEnum.Bisshop;
        }

        if(square.getPiece().getClass().equals(King.class)){
            return PieceEnum.King;
        }

        if(square.getPiece().getClass().equals(Queen.class)){
            return PieceEnum.Queen;
        }

        if(square.getPiece().getClass().equals(Rook.class)){
            return PieceEnum.Rook;
        }

        if(square.getPiece().getClass().equals(Knight.class)){
            return PieceEnum.Knight;
        }
        else{
            return PieceEnum.Empty;
        }
    }
}


