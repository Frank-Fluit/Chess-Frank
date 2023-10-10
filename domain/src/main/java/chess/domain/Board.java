package chess.domain;

public class Board {
    Square[][] squares;

    public Board(){
        squares = new Square[8][8];
        squares[0][0]= new Square();
        squares[0][1]= new Square();
        squares[0][2]= new Square();
        squares[0][3]= new Square();
        squares[0][4]= new Square();
        squares[0][5]= new Square();
        squares[0][6]= new Square();
        squares[0][7]= new Square();

        squares[1][0]= new Square( new Pawn());
        squares[1][1]= new Square( new Pawn());
        squares[1][2]= new Square( new Pawn());
        squares[1][3]= new Square( new Pawn());
        squares[1][4]= new Square( new Pawn());
        squares[1][5]= new Square( new Pawn());
        squares[1][6]= new Square( new Pawn());
        squares[1][7]= new Square( new Pawn());

    }
}
