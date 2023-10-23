package chess.domain;

public class Board {
    Square[] squares;
    private Player playerWhite;



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

    
    //constructor used for testing
    public Board(String buildString){

        this.playerWhite = new Player("white");
        squares = new Square[64];

        for (int count = 0; count < 64; count++) {
            int row = count / 8;
            int col = count % 8;
            int[] location = {row, col};
            char pieceToBuild = buildString.charAt(count);
            squares[count] = new Square(location,this, playerWhite, pieceToBuild);
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

    public Player getPlayerWhite() {
        return playerWhite;
    }
}
