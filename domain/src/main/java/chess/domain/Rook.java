package chess.domain;

public class Rook extends Piece {
    public Rook(Square square,Board board, Player owner) {
        this.square = square;
        this.board = board;
        this.owner = owner;
    }

    public void startAMove(int targetRow, int targetCol){
        if(isValidMove(targetRow,targetCol) && targetSquareOnBoard(targetRow, targetCol)){
            doMove(targetRow,targetCol);
        }
    }


    private boolean targetSquareOnBoard(int targetRow, int targetCol) {
        return (targetRow >= 0 && targetRow < 8 && targetCol >= 0 && targetCol <8);
    }

    private boolean isValidMove(int targetRow, int targetCol) {

        //check is there is a piece of owner in targetLocation
        Square targetSquare = board.getSquares(targetRow,targetCol);
        if (targetSquare.getPiece() != null && targetSquare.getPiece().getOwner() == this.getOwner()){
            return false;
        }

        if(!this.getOwner().getHasTurn()){
            return false;
        }

        int[] location = this.getParentSquare().getLocation();
        int originRow = location[0];
        int originCol = location[1];
        int absRowDifference = Math.abs(targetRow - originRow);
        int absColDifference = Math.abs(targetCol - originCol);

        //Rookspecific Logic
        //check Straightness of the move
        if(absRowDifference != 0 && absColDifference != 0)
            return false;

        // check if rows or columns are empty
        if(absColDifference>1){
            return(checkIfColumnEmpty(targetCol));
        }
        if(absRowDifference >1){
            return(checkIfRowEmpty(targetRow));
        }
        //return true when it is a 1 part move
        else{
            return true;
        }




    }

    private boolean checkIfRowEmpty(int targetRow) {
        return true;
    }

    private boolean checkIfColumnEmpty(int targetCol) {
        return true;
    }

    public void updateSquares(Square originSquare, Square targetSquare){
        targetSquare.update(this,targetSquare.getLocation());
        originSquare.empty();
    }



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
