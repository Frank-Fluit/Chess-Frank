package chess.domain;

public class Pawn extends Piece{

    int[] previousLocation;

    public Pawn(){
    }

    public Pawn(Square square,Board board, Player owner) {
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
        Square targetSquare = board.getSquares(targetRow,targetCol);
        if (targetSquare.getPiece() != null && targetSquare.getPiece().getOwner() == this.getOwner()){
            return false;
        }
        int[] location = this.getParentSquare().getLocation();
        int originRow = location[0];
        int originCol = location[1];
        int rowDifference = targetRow - originRow;
        int colDifference = targetCol - originCol;
        if(rowDifference < 0 && this.getOwner().getColour().equals("white")){
            return false;
        }
        if(rowDifference > 0 && this.getOwner().getColour().equals("black")){
            return false;
        }
        if(colDifference != 0 && targetSquare.getPiece() == null){
            return false;
        }
        if(Math.abs(rowDifference) >1 && this.previousLocation != null){
            return false;
        }
        if(Math.abs(rowDifference) >2){
            return false;
        }
        if (Math.abs(colDifference)> 1){
            return false;
        }
        return this.getOwner().getHasTurn();
    }

    public void updateSquares(Square originSquare, Square targetSquare){
        targetSquare.update(this);
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
