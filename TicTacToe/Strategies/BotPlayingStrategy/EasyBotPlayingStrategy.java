package TicTacToe.Strategies.BotPlayingStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Cell;
import TicTacToe.Models.Move;

import java.util.List;
import java.util.Random;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move botPlay(Board gameBoard){
        List<List<Move>> board=gameBoard.getBoard();
        Move nextMove= randomNextMove(board.size(),board.get(0).size());
        if(board.get(nextMove.getCell().getI()).get(nextMove.getCell().getJ()).getPlayer()==null)
            return nextMove;
        System.out.println("randomizing further");
        return botPlay(gameBoard);
    }

    private Move randomNextMove(int row, int col) {
        Random rand=new Random();
        int i=rand.nextInt(row);
        int j=rand.nextInt(col);
        Move nextMove=new Move(new Cell(i,j));
        return nextMove;
    }
}
