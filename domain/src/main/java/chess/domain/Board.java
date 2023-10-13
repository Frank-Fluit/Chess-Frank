package chess.domain;

public class Board {
    Square[][] squares;

    public Board() {
        squares = new Square[8][8];

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                squares[row][col] = new Square();

                if (row == 1 || row == 6) {
                    // Set up pawns in the second and seventh rows
                    squares[row][col] = new Square(new Pawn(row,col,this));
                }
            }
        }
    }

    public Square getSquares(int row, int col) {
        return squares[row][col];
    }
}
