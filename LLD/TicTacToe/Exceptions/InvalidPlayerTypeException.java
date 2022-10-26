package TicTacToe.Exceptions;

public class InvalidPlayerTypeException extends RuntimeException{
    private String playerType;
    public InvalidPlayerTypeException(String playerType){
        this.playerType=playerType;
    }
    public String toString(){
        return this.playerType +"is not a valid type";
    }
}
