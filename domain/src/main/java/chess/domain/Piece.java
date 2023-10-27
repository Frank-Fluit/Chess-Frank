package chess.domain;

public abstract class Piece {

    Board board;
    Square square;

    Player owner;

    public Piece() {

    }

    public Piece(Square square, Board board) {
        this.square = square;
        this.board = board;
    }

    public Square getParentSquare() {
        return this.square;
    }

    public Player getOwner() {
        return owner;
    }

    public abstract void startAMove(int targetRow, int targetCol);

    protected abstract boolean seesKing(Square squareEnemyKing);


    public Boolean askKingIfInCheck() {
        if(this.getClass() == King.class){
            return false;
        }
        for (int i = 0; i <= 63; i++) {
            Square square = board.getSquareIndex(i);
            Piece piece = square.getPiece();
            if (piece != null && piece instanceof King && piece.getOwner() == this.getOwner()) {
                return ((King) piece).isCheck();
            }
        }

        return false;
    }

    public Boolean isOpponentKingCheckMate(){
        for (int i = 0; i <= 63; i++) {
            Square square = board.getSquareIndex(i);
            Piece piece = square.getPiece();
            if (piece != null && piece instanceof King && piece.getOwner() != this.getOwner()) {
                return ((King) piece).isCheckMate();
            }
        }
        return null;

    }

    public void setOpponentCheckMate(){
        for (int i = 0; i <= 63; i++) {
            Square square = board.getSquareIndex(i);
            Piece piece = square.getPiece();
            if (piece != null && piece instanceof King && piece.getOwner() != this.getOwner()) {
                ((King) piece).setCheckMate(true);
            }
        }


    }

    public boolean checkMoveDoesNotLeadToCheck(Square originSquare, Square targetSquare){
        Boolean solvesCheck = false;
        Piece temporaryPiece = null;

        // saves piece temporary if necessary
        if(targetSquare.checkIfContainsPiece()){
            temporaryPiece =targetSquare.getPiece();
            targetSquare.pieceGetsTaken();
        }

        targetSquare.update(this,targetSquare.getLocation());
        originSquare.empty();

        // Here is the cause of the bug!!!
        solvesCheck = !this.askKingIfInCheck();
        originSquare.update(this,originSquare.getLocation());
        targetSquare.empty();
        targetSquare.update(temporaryPiece, targetSquare.getLocation());

        return solvesCheck;

    }

    protected boolean canItSolveCheck(Square squareParentKing) {

        Boolean checkCanBeSolved = false;
        for (int i = 0; i <= 63; i++) {
            Square targetSquare = board.getSquareIndex(i);
            int targetrow = targetSquare.getLocation()[0];
            int targetcol = targetSquare.getLocation()[1];
            if(isValidMove(targetrow,targetcol)){
                checkCanBeSolved = this.checkMoveDoesNotLeadToCheck(this.getParentSquare(), targetSquare);
            }
        }
        return checkCanBeSolved;
    }

    public abstract boolean isValidMove(int targetRow, int targetCol);


}



