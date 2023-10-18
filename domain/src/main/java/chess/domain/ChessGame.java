package chess.domain;

public class ChessGame implements Playable{

    private Board chessBoard;
    private String playerOne;
    private String playerTwo;


    public ChessGame(String playerOne,String playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        chessBoard = new Board();
    }

    @Override
    public String getNameOfPlayerOne() {
        return this.playerOne;
    }

    @Override
    public String getNameOfPlayerTwo() {
        return this.playerTwo;
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

    @Override
    public String getColourPiece(int rank, int file) {
        Square square = chessBoard.getSquares(rank, file);
        if(square.getPiece() == null){
            return "Empty";
        }
        else {
            return square.getPiece().getOwner().getColour();
        }
    }
}


