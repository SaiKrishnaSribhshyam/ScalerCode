package TicTacToe.Factories;

import TicTacToe.Models.BotDifficultyLevel;
import TicTacToe.Strategies.BotPlayingStrategy.BotPlayingStrategy;
import TicTacToe.Strategies.BotPlayingStrategy.EasyBotPlayingStrategy;
import TicTacToe.Strategies.BotPlayingStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        BotPlayingStrategy botPlayingStrategy;
        switch(botDifficultyLevel){
            case HARD:   botPlayingStrategy=new MediumBotPlayingStrategy();
                        break;
            case MEDIUM: botPlayingStrategy=new MediumBotPlayingStrategy();
                            break;
            default: botPlayingStrategy=new EasyBotPlayingStrategy();
        }
        return botPlayingStrategy;
    }
}
