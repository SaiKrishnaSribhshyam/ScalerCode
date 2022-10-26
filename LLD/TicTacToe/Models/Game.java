package TicTacToe.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import TicTacToe.Exceptions.InvalidPlayerTypeException;
import TicTacToe.Factories.PlayerFactory;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerIndex;
    private GameStatus gameStatus;
    private Builder builder;

    public Game(Builder builder) {
        this.board = builder.board;
        this.players = builder.players;
        this.nextPlayerIndex = builder.nextPlayerIndex;
        this.gameStatus = builder.gameStatus;
    }

    public static Builder getBuilder(){
        //this.builder=new Builder();
        return new Builder();
    }

    public Player checkVictory(){
        Player lastPlayer=null;
        int rows=board.getBoard().size();
        int cols=board.getBoard().get(0).size();
        boolean isDifferentSymbol=false;
        for(int i=0;i<rows;i++){
            lastPlayer=board.getBoard().get(i).get(0).player;
            isDifferentSymbol=false;
            for(int j=1;j<cols;j++){
                Player currPlayer=board.getBoard().get(i).get(j).player;
                if(lastPlayer==null || currPlayer==null ||  !lastPlayer.equals(currPlayer)) {
                    isDifferentSymbol=true;
                    break;
                }
            }
            if(!isDifferentSymbol) {
                this.gameStatus=GameStatus.Completed;
                return lastPlayer;
            }
        }
        return null;
    }

    public void start(){
        Player winner=null;
        gameStatus=GameStatus.Started;
        while(this.gameStatus!=GameStatus.Completed){
            Move nextMove=players.get(nextPlayerIndex++).play(this.board);
            this.board.updateMove(nextMove);
            winner=checkVictory();
            if(winner!=null)
                break;
            nextPlayerIndex%=players.size();
            this.board.printBoard();
            System.out.println(this.board.getMoves().get(this.board.getMoves().size()-1).getCell().getI()+","
                    +this.board.getMoves().get(this.board.getMoves().size()-1).getCell().getJ());
            if(this.board.getMoves().size()==(this.board.getBoard().size()*this.board.getBoard().get(0).size())) {
                System.out.println("No more moves allowed, Game is a Draw");
                gameStatus=GameStatus.Completed;
            }
        }
        if(winner!=null && gameStatus==GameStatus.Completed){
            System.out.println(winner.getName()+"Won the Game");
        }
    }

    public static class Builder{
        private Board board;
        private List<Player> players;
        private int nextPlayerIndex;
        private GameStatus gameStatus;
        HashSet<Character> symbols=new HashSet();

        public Builder setBoard(int dimension){
            List<List<Move>> board=new ArrayList<>();
            for(int i=0;i<dimension;i++){
                board.add(new ArrayList<Move>());
            }

            for(int i=0;i<dimension;i++){
                for(int j=0;j<dimension;j++){
                    board.get(i).add(new Move(new Cell(i,j)));
                }
            }
            this.board=new Board(board);
            return this;
        }

        public Builder setPlayers(int dimension){
            players=new ArrayList<Player>();
            Scanner cin=new Scanner(System.in);
            for(int i=0;i<dimension;i++){
                Player p;
                System.out.println("Enter playerType as: Human/Bot");
                String playerType=cin.nextLine();
                p= PlayerFactory.getPlayer(playerType);
                if(p==null)
                    throw (new InvalidPlayerTypeException(playerType));
                System.out.println("Enter player name:");
                p.setName(cin.nextLine());
                System.out.println("Enter symbol:");
                Character symbol=cin.nextLine().charAt(0);
                while(symbols.contains(symbol)){
                    System.out.println(symbol + "already exists,enter new Symbol:");
                    symbol=cin.nextLine().charAt(0);
                }
                p.setSymbol(new Symbol(symbol));
                symbols.add(symbol);
                System.out.println(p.getName()+"-"+p.getSymbol().getSymbol());
                this.players.add(p);
            }
            return this;
        }

        public Builder setLastIndex(){
            this.nextPlayerIndex=0;
            return this;
        }

        public Builder setGameStatus(){
            this.gameStatus=GameStatus.Started;
            return this;
        }
        public Game build(){
            return new Game(this);
        }
    }
}
