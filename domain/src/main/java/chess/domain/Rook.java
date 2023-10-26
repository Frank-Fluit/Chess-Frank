package chess.domain;

public class Rook extends Piece {
    public Rook(Square square,Board board, Player owner) {
        this.square = square;
        this.board = board;
        this.owner = owner;
    }


    //stays the same as knight
    @Override
    public void startAMove(int targetRow, int targetCol){
        if(isValidMove(targetRow,targetCol) && targetSquareOnBoard(targetRow, targetCol) && this.getOwner().getHasTurn()){
            doMove(targetRow,targetCol);
        }
    }

    @Override
    protected boolean seesKing(Square squareEnemyKing) {
        return isValidMove(squareEnemyKing.getLocation()[0],squareEnemyKing.getLocation()[1]);
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



        if(absColDifference != 0 && absRowDifference!= 0)
            return false;

        if(absColDifference >1 ){
            return checkIfRowIsEmpty(this.getParentSquare().getLocation(), targetCol);
        }

        if(absRowDifference >1){
            return checkIfColIsEmpty(this.getParentSquare().getLocation(), targetRow);
        }

        else{
            return true;
        }


    }

    private boolean checkIfColIsEmpty(int[] location, int targetRow) {
        int originRow = location[0];
        int columnToCheck = location[1];

        int startRow = Math.min(originRow, targetRow);
        int endRow = Math.max(originRow, targetRow);


        for (int row = startRow + 1; row < endRow; row++) {
            if (this.board.getSquares(row,columnToCheck).checkIfContainsPiece()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfRowIsEmpty(int[] location,int targetCol) {
        int rowToCheck = location[0];
        int originCol = location[1];

        int startCol = Math.min(originCol, targetCol);
        int endCol = Math.max(originCol, targetCol);


        for (int col = startCol + 1; col < endCol; col++) {
            if (this.board.getSquares(rowToCheck,col).checkIfContainsPiece()) {
                return false;
            }
        }
        return true;
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
