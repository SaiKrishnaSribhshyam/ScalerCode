package TicTacToe.Models;

import TicTacToe.Factories.BotPlayingStrategyFactory;
import TicTacToe.Strategies.BotPlayingStrategy.BotPlayingStrategy;

import java.util.List;
import java.util.Random;

public class BotPlayer extends Player{
    BotPlayingStrategy botPlayingStrategy;
    BotDifficultyLevel botDifficultyLevel;

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy() {
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(this.botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public Move play(Board gameBoard){
        Move nextMove= botPlayingStrategy.botPlay(gameBoard);
        nextMove.setPlayer(this);
        return nextMove;
    }
}
