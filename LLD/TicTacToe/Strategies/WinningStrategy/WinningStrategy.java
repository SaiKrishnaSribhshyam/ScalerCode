package TicTacToe.Strategies.WinningStrategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Player;

public interface WinningStrategy {
    public Player checkVictory(Board board);
}
