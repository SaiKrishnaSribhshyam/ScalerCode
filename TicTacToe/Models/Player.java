package TicTacToe.Models;

import java.util.List;

public abstract class Player {
    private String Name;
    private Symbol symbol;
    public abstract Move play(Board board);

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public boolean equals(Object other){
        if(this==other)
            return true;
        if(other==null || !(other instanceof Player))
            return false;
        Player otherPlayer=(Player) other;
        return this.getName().equals(otherPlayer.getName());

    }
}
