package TicTacToe.Strategies.BotPlayingStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Cell;
import TicTacToe.Models.Move;

import java.util.List;
import java.util.Random;

public class MediumBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move botPlay(Board gameBoard) {
        int rows=gameBoard.getBoard().size();
        int cols=gameBoard.getBoard().get(0).size();
        List<List<Move>> board=gameBoard.getBoard();
        Move newMove=null;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                Move currMove=board.get(i).get(j);
                if(currMove.getPlayer()==null){
                    newMove=new Move(new Cell(i,j));
                    return newMove;
                }
            }
        }
        return newMove;
    }
}
