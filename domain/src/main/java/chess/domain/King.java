package chess.domain;

public class King extends Piece {
    private Boolean checkMate;



    private int[] previousLocation;

    public int[] getPreviousLocation() {
        return previousLocation;
    }

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

        if(absColDifference > 1 && originRow == 0){
            return isValidCastlingWhite(targetRow,targetCol);
        }

        if(absColDifference > 1 && originRow == 7){
            return isValidCastlingBlack(targetRow,targetCol);
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

    private boolean isValidCastlingBlack(int targetRow, int targetCol) {

        if (!((targetRow == 7 && targetCol == 6) || (targetRow == 7 && targetCol == 2))) {
            return false;
        }

        if(targetCol == 6) {
            Square kingrookSquare = this.board.getSquares(7, 7);
            if (kingrookSquare.getPiece() == null || kingrookSquare.getPiece().getClass() != Rook.class) {
                return false;
            }
            Rook kingrook = (Rook) kingrookSquare.getPiece();
            if (this.square.getLocation()[0] != 7 && this.square.getLocation()[1] != 4) {
                return false;
            }
            if (kingrook.getPreviousLocation() != null || this.getPreviousLocation() != null) {
                return false;
            }
            if (this.board.getSquares(7, 5).getPiece() != null ||
                    this.board.getSquares(7, 6).getPiece() != null) {
                return false;
            }
            if(this.board.getSquares(7,5).isSeenByOpponent(this.owner) || this.board.getSquares(7,6).isSeenByOpponent(this.owner) ||
                    this.isCheck()){
                return false;
            }
        }

        if(targetCol ==2) {
            Square queenrookSquare = this.board.getSquares(7, 0);
            if (queenrookSquare.getPiece() == null || queenrookSquare.getPiece().getClass() != Rook.class) {
                return false;
            }
            Rook queenrook = (Rook) queenrookSquare.getPiece();
            if (this.square.getLocation()[0] != 7 && this.square.getLocation()[1] != 4) {
                return false;
            }
            if (queenrook.getPreviousLocation() != null || this.getPreviousLocation() != null) {
                return false;
            }
            if (this.board.getSquares(7, 2).getPiece() != null ||
                    this.board.getSquares(7, 3).getPiece() != null) {
                return false;
            }
            if(this.board.getSquares(7,2).isSeenByOpponent(this.owner) || this.board.getSquares(7,3).isSeenByOpponent(this.owner) ||
                    this.isCheck()){
                return false;
            }
        }
        // TODO
        return true;
    }
    private boolean isValidCastlingWhite(int targetRow, int targetCol) {

        if (!((targetRow == 0 && targetCol == 6) || (targetRow == 0 && targetCol == 2))) {
            return false;
        }

        if(targetCol == 6) {
            Square kingrookSquare = this.board.getSquares(0, 7);
            if (kingrookSquare.getPiece() == null || kingrookSquare.getPiece().getClass() != Rook.class) {
                return false;
            }
            Rook kingrook = (Rook) kingrookSquare.getPiece();
            if (this.square.getLocation()[0] != 0 && this.square.getLocation()[1] != 4) {
                return false;
            }
            if (kingrook.getPreviousLocation() != null || this.getPreviousLocation() != null) {
                return false;
            }
            if (this.board.getSquares(0, 5).getPiece() != null ||
                    this.board.getSquares(0, 6).getPiece() != null) {
                return false;
            }
            if(this.board.getSquares(0,5).isSeenByOpponent(this.owner) || this.board.getSquares(0,6).isSeenByOpponent(this.owner) ||
            this.isCheck()){
                return false;
            }
        }

        if(targetCol ==2) {
            Square queenrookSquare = this.board.getSquares(0, 0);
            if (queenrookSquare.getPiece() == null || queenrookSquare.getPiece().getClass() != Rook.class) {
                return false;
            }
            Rook queenrook = (Rook) queenrookSquare.getPiece();
            if (this.square.getLocation()[0] != 0 && this.square.getLocation()[1] != 4) {
                return false;
            }
            if (queenrook.getPreviousLocation() != null || this.getPreviousLocation() != null) {
                return false;
            }
            if (this.board.getSquares(0, 2).getPiece() != null ||
                    this.board.getSquares(0, 3).getPiece() != null) {
                return false;
            }
            if(this.board.getSquares(0,2).isSeenByOpponent(this.owner) || this.board.getSquares(0,3).isSeenByOpponent(this.owner) ||
                    this.isCheck()){
                return false;
            }
        }
        //TODO
        return true;
    }

    private void doCastleMove(int targetRow, int targetCol) {

        this.previousLocation = this.square.getLocation();
        Square kingRookSquare = this.board.getSquares(0,7);
        Square queenRookSquare = this.board.getSquares(0,0);
        Square blackKingRookSquare = this.board.getSquares(7,7);
        Square blackQueenRookSquare = this.board.getSquares(7,0);

        Square originSquare = this.getParentSquare();

        if(targetRow == 0) {

            if (targetCol == 2) {
                updateSquares(originSquare, this.board.getSquares(0, 2));
                updateSquares(queenRookSquare, this.board.getSquares(0, 3));
            }
            if (targetCol == 6) {

                updateSquares(originSquare, this.board.getSquares(0, 6));
                updateSquares(kingRookSquare, this.board.getSquares(0, 5));
            }
        }

        if(targetRow == 7) {

            if (targetCol == 2) {
                updateSquares(originSquare, this.board.getSquares(7, 2));
                updateSquares(blackQueenRookSquare, this.board.getSquares(7, 3));
            }
            if (targetCol == 6) {
                updateSquares(originSquare, this.board.getSquares(7, 6));
                updateSquares(blackKingRookSquare, this.board.getSquares(7, 5));
            }
        }

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
