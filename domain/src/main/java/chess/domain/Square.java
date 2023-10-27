package chess.domain;

public class Square {
    Piece piece;
    int[] location;
    Board board;
    Player owner;

    public Square(){

    }

    public Square(int[] location, Board board, Player playerWhite) {
        this.location = location;
        this.board = board;
        this.piece = null;
        initializePiece(playerWhite);
    }

    public Square(int[] location, Board board, Player playerWhite, char pieceToBuild){
        this.location = location;
        this.board = board;
        if(Character.toString(pieceToBuild).equals("E")){
            this.piece = null;
        }
        if(Character.toString(pieceToBuild).equals("R")){
            this.piece = new Rook(this, board, playerWhite);
        }
        if(Character.toString(pieceToBuild).equals("H")){
            this.piece = new Knight(this, board, playerWhite);
        }
        if(Character.toString(pieceToBuild).equals("B")){
            this.piece = new Bisshop(this, board, playerWhite);
        }
        if(Character.toString(pieceToBuild).equals("Q")){
            this.piece = new Queen(this, board, playerWhite);
        }
        if(Character.toString(pieceToBuild).equals("K")){
            this.piece = new King(this, board, playerWhite);
        }
        if(Character.toString(pieceToBuild).equals("P")){
            this.piece = new Pawn(this, board, playerWhite);
        }
        if(Character.toString(pieceToBuild).equals("X")){
            this.piece = new Rook(this, board, playerWhite.getOpponent());
        }
        if(Character.toString(pieceToBuild).equals("Y")){
            this.piece = new Knight(this, board, playerWhite.getOpponent());
        }
        if(Character.toString(pieceToBuild).equals("Z")){
            this.piece = new Bisshop(this, board, playerWhite.getOpponent());
        }
        if(Character.toString(pieceToBuild).equals("U")){
            this.piece = new Queen(this, board, playerWhite.getOpponent());
        }
        if(Character.toString(pieceToBuild).equals("V")){
            this.piece = new King(this, board, playerWhite.getOpponent());
        }
        if(Character.toString(pieceToBuild).equals("W")){
            this.piece = new Pawn(this, board, playerWhite.getOpponent());
        }



    }

    private void initializePiece(Player playerWhite) {
        int row = location[0];
        int col = location[1];

        if (row == 1) {

            piece = new Pawn(this,board,playerWhite);
        } else if (row == 6) {

            piece = new Pawn(this,board,playerWhite.getOpponent());
        } else if (row == 0 || row == 7) {

            if (col == 0 || col == 7) {
                piece = new Rook(this,board,row == 0 ? playerWhite : playerWhite.getOpponent());
            } else if (col == 1 || col == 6) {
                piece = new Knight(this,board,row == 0 ? playerWhite : playerWhite.getOpponent());
            } else if (col == 2 || col == 5) {
                piece = new Bisshop(this,board,row == 0 ? playerWhite : playerWhite.getOpponent());
            } else if (col == 3) {
                piece = new Queen(this,board,row == 0 ? playerWhite : playerWhite.getOpponent());
            } else if (col == 4) {
                piece = new King(this,board,row == 0 ? playerWhite : playerWhite.getOpponent());

            }
        }
    }

    public Square(Piece piece){
        this.piece = piece;
    }

    protected Piece getPiece() {
        return this.piece;
    }

    protected int[] getLocation(){
        return this.location;
    }

    public void empty(){
        this.piece = null;
    }

    public Boolean checkIfContainsPiece() {
        return this.getPiece() != null;
    }

    public void update(Piece piece, int[] location){
        this.piece = piece;
        this.location = location;
    }


    public void pieceGetsTaken() {
        this.piece = null;
    }
}