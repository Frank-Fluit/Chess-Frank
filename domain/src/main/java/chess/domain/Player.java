package chess.domain;

public class Player{
    private Boolean hasTurn;
    private Player opponent;



    public Player() {

        this.hasTurn = true;
        this.opponent = new Player(false, this);
    }

    public Player(Boolean hasTurn, Player opponent){
        this.hasTurn = hasTurn;
        this.opponent = opponent;
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


