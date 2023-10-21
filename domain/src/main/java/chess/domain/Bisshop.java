package chess.domain;

public class Bisshop extends Piece {

    public Bisshop(Square square,Board board, Player owner) {
        this.square = square;
        this.board = board;
        this.owner = owner;
    }

    @Override
    public void startAMove(int targetRow, int targetCol){
        if(isValidMove(targetRow,targetCol) && targetSquareOnBoard(targetRow, targetCol)){
            doMove(targetRow,targetCol);
        }
    }

    //Stays the same as knight
    private boolean targetSquareOnBoard(int targetRow, int targetCol) {
        return (targetRow >= 0 && targetRow < 8 && targetCol >= 0 && targetCol <8);
    }

    private boolean isValidMove(int targetRow, int targetCol) {


        //stays the same as knight, checks If targetsquare contains piece of owner
        Square targetSquare = board.getSquares(targetRow,targetCol);
        if (targetSquare.getPiece() != null && targetSquare.getPiece().getOwner() == this.getOwner()){
            return false;
        }

        //stays the same as knight
        int[] location = this.getParentSquare().getLocation();
        int originRow = location[0];
        int originCol = location[1];
        int absRowDifference = Math.abs(targetRow - originRow);
        int absColDifference = Math.abs(targetCol - originCol);

        if(!this.getOwner().getHasTurn()){
            return false;
        }

        if(absColDifference != absRowDifference)
            return false;

        if(absColDifference >1 ){
            return checkIfDiagonalIsEmpty(this.getParentSquare().getLocation(), targetRow,targetCol);
        }

        else{
            return true;
        }


    }

  

    private boolean checkIfDiagonalIsEmpty(int[] location, int targetRow, int targetCol) {

        int originRow = location[0];
        int originCol = location[1];
        
        int colIterator = (targetCol > originCol) ? 1 : -1;
        int rowIterator = (targetRow > originRow) ? 1 : -1;

        for (int row = originRow + rowIterator, col = originCol + colIterator;
         row != targetRow && col != targetCol;
         row += rowIterator, col += colIterator) {
        if (this.board.getSquares(row, col).checkIfContainsPiece()) {
            return false; 
        }
    }

    return true; 
}
    }
    // for inspiration:




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
