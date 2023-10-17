package chess.domain;

public class Player{
    private Boolean hasTurn;
    private Player opponent;

    private String colour;



    public Player(String colour) {

        this.hasTurn = true;
        this.opponent = new Player(false, this, "black");
        this.colour = colour;

    }

    public Player(Boolean hasTurn, Player opponent, String colour){
        this.hasTurn = hasTurn;
        this.opponent = opponent;
        this.colour = colour;
    }


    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Player getOpponent(){
        return opponent;
    }
    public Boolean getHasTurn(){
        return hasTurn;
    }

    public String getColour(){
        return this.colour;
    }

    public void switchTurn(){
        if(hasTurn){
            hasTurn = false;
            opponent.hasTurn = true;
        }
        else {
            hasTurn = true;
            opponent.hasTurn = false;


        }

    }



}


