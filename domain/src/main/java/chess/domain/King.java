package chess.domain;

public class King extends Piece {
    Boolean checkMate;

    public King(Square square,Board board, Player owner) {
        this.square = square;
        this.board = board;
        this.owner = owner;
        this.checkMate = false;
    }

    @Override
    public void startAMove(int targetRow, int targetCol){
        if(isValidMove(targetRow,targetCol) && targetSquareOnBoard(targetRow, targetCol)){
            doMove(targetRow,targetCol);
        }
    }

    @Override
    protected boolean seesKing(Square squareEnemyKing) {
        return false;
    }




    private boolean targetSquareOnBoard(int targetRow, int targetCol) {
        return (targetRow >= 0 && targetRow < 8 && targetCol >= 0 && targetCol <8);
    }

    public boolean isValidMove(int targetRow, int targetCol) {

        Square targetSquare = board.getSquares(targetRow,targetCol);
        if (targetSquare.getPiece() != null && targetSquare.getPiece().getOwner() == this.getOwner()){
            return false;
        }

        int[] location = this.getParentSquare().getLocation();
        int originRow = location[0];
        int originCol = location[1];
        int absRowDifference = Math.abs(targetRow - originRow);
        int absColDifference = Math.abs(targetCol - originCol);


        if(!this.getOwner().getHasTurn()){
            return false;
        }
        return (absColDifference == 1 && absRowDifference == 1) ||
                (absColDifference == 1 && absRowDifference == 0) ||
                (absColDifference == 0 && absRowDifference == 1);


    }

    public void updateSquares(Square originSquare, Square targetSquare){
        targetSquare.update(this,targetSquare.getLocation());
        this.square = targetSquare;
        originSquare.empty();
    }



    void doMove(int targetRow, int targetCol){
        Square targetSquare = this.board.getSquares(targetRow,targetCol);
        if(targetSquare.checkIfContainsPiece()){
            targetSquare.pieceGetsTaken();
        }
        Square originSquare = this.getParentSquare();
        updateSquares(originSquare,targetSquare);
        if(this.isOpponentKingCheckMate()){
            setOpponentCheckMate();
        }

        this.getOwner().switchTurn();
    }
    Boolean isCheck(){
        for (int i = 0; i <= 63; i++) {
            Square square = board.getSquareIndex(i);
            Piece piece = square.getPiece();
            if (piece != null && !(piece instanceof King) && piece.getOwner() != this.getOwner()) {
                if(piece.seesKing(this.square))
                    return true;
            }
        }
        return false;
    }

    public boolean isCheckMate() {
        if (!isCheck()) {
            return false;
        }
        for (int i = 0; i < 64; i++) {
            Square square = board.getSquareIndex(i);
            Piece piece = square.getPiece();
            //all own pieces are checked if they can solve chech
            if (piece != null && piece.getOwner() == this.getOwner() && piece.canItSolveCheck(this.square)) {
                return false;
            }
        }
        return true;
    }

    public void setCheckMate(Boolean checkMate) {
        this.checkMate = checkMate;
    }

}
