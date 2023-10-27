package chess.domain;

public class Queen extends Piece{

    public Queen(Square square,Board board, Player owner) {
        this.square = square;
        this.board = board;
        this.owner = owner;
    }

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


        if(absColDifference != absRowDifference && absColDifference != 0 && absRowDifference!= 0)
            return false;

        if(absColDifference >1 && absColDifference == absRowDifference){
            return checkIfDiagonalIsEmpty(this.getParentSquare().getLocation(), targetRow,targetCol);
        }

        if(absColDifference >1 && absRowDifference ==0){
            return checkIfRowIsEmpty(this.getParentSquare().getLocation(), targetCol);
        }

        if(absRowDifference >1 && absColDifference ==0){
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
            if (this.board.getSquares(rowToCheck, col).checkIfContainsPiece()) {
                return false;
            }
        }
        return true;
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
