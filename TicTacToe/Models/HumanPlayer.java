package TicTacToe.Models;

import TicTacToe.Exceptions.InvalidMoveException;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player {

    public Move play(Board gameBoard) throws InvalidMoveException{
        List<List<Move>> board=gameBoard.getBoard();
        Scanner cin=new Scanner(System.in);
        System.out.println("Enter Row and col index:");
        int i=cin.nextInt();
        System.out.println("Enter column:");
        int j=cin.nextInt();
        if(i>=board.size() || j>=board.get(0).size())
            throw new InvalidMoveException();
        System.out.println("Selected row and col for"+this.getSymbol().getSymbol()+i +","+j);
        Move nextMove=new Move(this,new Cell(i,j));
        //cin.close();
        if(board.get(i).get(j).getPlayer()==null)
            return nextMove;
        System.out.println("Invalid move");
        return play(gameBoard);
    }
}
