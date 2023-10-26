package chess.domain;

public class Knight extends Piece {

    public Knight(Square square,Board board, Player owner) {
        this.square = square;
        this.board = board;
        this.owner = owner;
    }
    // Stays the same as pawn
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

    //Stays the same as pawn
    private boolean targetSquareOnBoard(int targetRow, int targetCol) {
        return (targetRow >= 0 && targetRow < 8 && targetCol >= 0 && targetCol <8);
    }
    // Can be simplified according to notes
    private boolean isValidMove(int targetRow, int targetCol) {


        //stays the same as pawn, checks If targetsquare contains piece of owner
        Square targetSquare = board.getSquares(targetRow,targetCol);
        if (targetSquare.getPiece() != null && targetSquare.getPiece().getOwner() == this.getOwner()){
            return false;
        }

        //stays the same as pawn
        int[] location = this.getParentSquare().getLocation();
        int originRow = location[0];
        int originCol = location[1];
        int absRowDifference = Math.abs(targetRow - originRow);
        int absColDifference = Math.abs(targetCol - originCol);



        return (absColDifference == 2 && absRowDifference == 1) || (absRowDifference == 2 && absColDifference == 1);
    }
    //Stays the same as pawn
    public void updateSquares(Square originSquare, Square targetSquare){
        targetSquare.update(this,targetSquare.getLocation());
        this.square = targetSquare;
        originSquare.empty();
    }


    //stays the same
    void doMove(int targetRow, int targetCol){
        Square targetSquare = this.board.getSquares(targetRow,targetCol);
        if(targetSquare.checkIfContainsPiece()){
            targetSquare.pieceGetsTaken();
        }
        Square originSquare = this.getParentSquare();
        updateSquares(originSquare,targetSquare);
        this.getOwner().switchTurn();
    }

}
