package chess.domain;

public class Board {
    Square[][] squares;

    public Board(){
        squares = new Square[8][8];
        squares[0][0]= new Square();
        squares[1][0]= new Square();
        squares[2][0]= new Square();
        squares[3][0]= new Square();
        squares[4][0]= new Square();
        squares[5][0]= new Square();
        squares[6][0]= new Square();
        squares[7][0]= new Square();

        squares[0][1]= new Square( new Pawn());
        squares[1][1]= new Square( new Pawn());
        squares[2][1]= new Square( new Pawn());
        squares[3][1]= new Square( new Pawn());
        squares[4][1]= new Square( new Pawn());
        squares[5][1]= new Square( new Pawn());
        squares[6][1]= new Square( new Pawn());
        squares[7][1]= new Square( new Pawn());

        squares[0][2]= new Square();
        squares[1][2]= new Square();
        squares[2][2]= new Square();
        squares[3][2]= new Square();
        squares[4][2]= new Square();
        squares[5][2]= new Square();
        squares[6][2]= new Square();
        squares[7][2]= new Square();

        squares[0][3]= new Square();
        squares[1][3]= new Square();
        squares[2][3]= new Square();
        squares[3][3]= new Square();
        squares[4][3]= new Square();
        squares[5][3]= new Square();
        squares[6][3]= new Square();
        squares[7][3]= new Square();


        squares[0][4]= new Square();
        squares[1][4]= new Square();
        squares[2][4]= new Square();
        squares[3][4]= new Square();
        squares[4][4]= new Square();
        squares[5][4]= new Square();
        squares[6][4]= new Square();
        squares[7][4]= new Square();


        squares[0][5]= new Square();
        squares[1][5]= new Square();
        squares[2][5]= new Square();
        squares[3][5]= new Square();
        squares[4][5]= new Square();
        squares[5][5]= new Square();
        squares[6][5]= new Square();
        squares[7][5]= new Square();


        squares[6][0]= new Square( new Pawn());
        squares[6][1]= new Square( new Pawn());
        squares[6][2]= new Square( new Pawn());
        squares[6][3]= new Square( new Pawn());
        squares[6][4]= new Square( new Pawn());
        squares[6][5]= new Square( new Pawn());
        squares[6][6]= new Square( new Pawn());
        squares[6][7]= new Square( new Pawn());

        squares[7][0]= new Square();
        squares[7][1]= new Square();
        squares[7][2]= new Square();
        squares[7][3]= new Square();
        squares[7][4]= new Square();
        squares[7][5]= new Square();
        squares[7][6]= new Square();
        squares[7][7]= new Square();



    }
}
