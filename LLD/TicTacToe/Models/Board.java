package TicTacToe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Move>> board;
    private List<Move> moves;
    //private List<Move> validMoves;

    public Board(List<List<Move>> board) {
        this.moves=new ArrayList<>();
        this.board = board;
        //this.validMoves=new ArrayList<>();
    }

    public List<List<Move>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Move>> board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }


    public void updateMove(Move nextMove) {
        int i=nextMove.getCell().getI();
        int j=nextMove.getCell().getJ();
        board.get(i).set(j,nextMove);
        moves.add(nextMove);
    }

    public void printBoard(){
        int rows=board.size();
        int cols=board.get(0).size();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                Player p=board.get(i).get(j).getPlayer();
                if(p==null)
                    System.out.print("_ ");
                else
                    System.out.print(p.getSymbol().getSymbol()+" ");
            }
            System.out.println();
        }
    }
}
