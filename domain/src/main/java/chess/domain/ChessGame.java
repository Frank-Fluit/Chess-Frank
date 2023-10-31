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
    public void playPiece(int[] originSquare, int[] targetSquare) {
        chessBoard.getSquares(originSquare[0],originSquare[1]).getPiece().startAMove(targetSquare[0],targetSquare[1]);

    }


    // update next two to include checkmate state
    @Override
    public boolean isEndOfGame() {


        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (chessBoard.getSquares(row, col).getPiece() != null) {
                    if (chessBoard.getSquares(row, col).getPiece().getClass().equals(King.class)) {
                        King king = (King) chessBoard.getSquares(row, col).getPiece();
                        if(king.isCheckMate()){return true;}
                    }
                }
            }
        }
        return false;
    }


    public Winner getWinner() {
        if (!isEndOfGame()) {
            return Winner.NO_ONE;
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = chessBoard.getSquares(row, col).getPiece();

                if (piece != null && piece instanceof King) {
                    Player owner = piece.getOwner();
                    King king = (King) piece;

                    if (owner.getColour().equals("white") && king.isCheckMate()) {
                        return Winner.PLAYER_2;
                    } else {
                        return Winner.PLAYER_1;
                    }
                }
            }
        }

        return Winner.NO_ONE;
    }




    @Override
    public Boolean isPLayersTurn(String colour) {
        if(colour == "white"){
            return chessBoard.getPlayerWhite().getHasTurn();
        }
        else{
            return chessBoard.getPlayerWhite().getOpponent().getHasTurn();
        }
    }

    @Override
    public void removeReachableFromSquares() {
        for (int i = 0; i <= 63; i++) {
            Square square = chessBoard.getSquareIndex(i);
            square.resetReachableSquare();
        }
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

    @Override
    public Boolean getIsReachable(int row, int col) {
        Square square = chessBoard.getSquares(row, col);
        return square.isReachableSquare();
    }

    @Override
    public void updateSquares(int row, int col) {
        Square square = chessBoard.getSquares(row, col);
        if(square.getPiece() != null){
            square.getPiece().addReachableToSquares();
        }
    }
}


