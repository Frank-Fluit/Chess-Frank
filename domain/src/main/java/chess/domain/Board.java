package chess.domain;

public class Board {
    Square[] squares;
    private Player playerWhite;


//    public Board() {
//        squares = new Square[8][8];
//
//        for (int row = 0; row < 8; row++) {
//            for (int col = 0; col < 8; col++) {
//                squares[row][col] = new Square();
//
//                if (row == 1 || row == 6) {
//                    // Set up pawns in the second and seventh rows
//                    squares[row][col] = new Square(new Pawn(row,col,this));
//                }
//            }
//        }
//    }


    public Player getPlayerWhite() {
        return playerWhite;
    }

    public Board() {

        this.playerWhite = new Player("white");


        squares = new Square[64];
        for (int count = 0; count < 64; count++) {
            int row = count / 8;
            int col = count % 8;
            int[] location = {row, col};
            squares[count] = new Square(location,this, playerWhite);
            }
        }


    public Square getSquares(int row, int col) {

        int index = row*8 + col;

        if(index >= 0 && index < 64){
        return squares[index];}
        else{
            throw new IllegalArgumentException("Wrong input");
        }
    }
}
