package chess.domain;

public class King extends Piece {
    Boolean checkMate;

    public int[] getPreviousLocation() {
        return previousLocation;
    }

    int[] previousLocation;

    public King(Square square,Board board, Player owner) {
        this.square = square;
        this.board = board;
        this.owner = owner;
        this.checkMate = false;
    }

    public Boolean getCheckMate() {
        return checkMate;
    }

    @Override
    public void startAMove(int targetRow, int targetCol){
        if(isValidMove(targetRow,targetCol) && targetSquareOnBoard(targetRow, targetCol) && !isPotentialCastle(targetCol)){
            doMove(targetRow,targetCol);
        }
        if(isValidMove(targetRow,targetCol) && targetSquareOnBoard(targetRow, targetCol) && isPotentialCastle(targetCol)){
            doCastleMove(targetRow, targetCol);
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

        if(!checkMoveDoesNotLeadToCheck(this.getParentSquare(),targetSquare)){
            return false;
        }

        if(absColDifference > 1){
            return isValidCastling(targetRow,targetCol);
        }

        return (absColDifference == 1 && absRowDifference == 1) ||
                (absColDifference == 1 && absRowDifference == 0) ||
                (absColDifference == 0 && absRowDifference == 1);

    }


    public void updateSquares(Square originSquare, Square targetSquare){
        targetSquare.update(originSquare.getPiece(), targetSquare.getLocation());

        originSquare.getPiece().square = targetSquare;
        originSquare.empty();
    }


    void doMove(int targetRow, int targetCol){

        this.previousLocation = this.square.getLocation();

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

    private boolean isPotentialCastle( int targetCol) {
        return Math.abs(targetCol - this.getParentSquare().getLocation()[1]) > 1;
    }
    private boolean isValidCastling(int targetRow, int targetCol) {

        // check if pieces are in right location and did not move yet, and the targetlocation is valid


        if(!(targetRow == 0 && targetCol == 6)){
            return false;
        }

        Square rookSquare = this.board.getSquares(0,7);
        if(rookSquare.getPiece() == null || rookSquare.getPiece().getClass() != Rook.class) {
            return false;
        }
        Rook rook = (Rook) rookSquare.getPiece();
        if(this.square.getLocation()[0] != 0 && this.square.getLocation()[1] != 4){
            return false;
        }
        if(rook.getPreviousLocation() != null || this.getPreviousLocation() != null){
            return false;
        }

        if(this.board.getSquares(0,5).getPiece() != null ||
                this.board.getSquares(0,6).getPiece() != null ){
            return false;
        }

        // the check of the targetsquare has been taken care of in the isvalidMove Functie
        // TODO
        // add a check of check for the row and for the row that is crossed
        return true;
    }

    private void doCastleMove(int targetRow, int targetCol) {

        // now this function is the old doMove, it has to be updated into the castlemove, for now only Kingside

        this.previousLocation = this.square.getLocation();
        Square rookSquare = this.board.getSquares(0,7);
        Rook rook = (Rook) rookSquare.getPiece();


        Square originSquare = this.getParentSquare();

        //updatesquare call 1
        updateSquares(originSquare,this.board.getSquares(0,6));

        //updatesquare call 2
        updateSquares(rookSquare,this.board.getSquares(0,5));


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
        // this should be reached when no false is returned as a result of no pieces that can solve the checkmate
        return true;
    }

    public void setCheckMate(Boolean checkMate) {
        this.checkMate = checkMate;
    }

}
