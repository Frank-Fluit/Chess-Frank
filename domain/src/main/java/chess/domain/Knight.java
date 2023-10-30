package chess.domain;

public class Knight extends Piece {

    public Knight(Square square,Board board, Player owner) {
        this.square = square;
        this.board = board;
        this.owner = owner;
    }

    @Override
    public void startAMove(int targetRow, int targetCol){
        if(isValidMove(targetRow,targetCol) && targetSquareOnBoard(targetRow, targetCol ) && this.getOwner().getHasTurn()){
            doMove(targetRow,targetCol);
        }
    }

    @Override
    protected boolean seesKing(Square squareEnemyKing) {
        return isValidMove(squareEnemyKing.getLocation()[0],squareEnemyKing.getLocation()[1]);
    }
    @Override
    protected boolean canItSolveCheck(Square squareParentKing) {
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

        if(!checkMoveDoesNotLeadToCheck(this.getParentSquare(),targetSquare)){
            return false;
        }



        return (absColDifference == 2 && absRowDifference == 1) || (absRowDifference == 2 && absColDifference == 1);
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

}
