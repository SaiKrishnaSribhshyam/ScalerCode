package TicTacToe.Factories;

import TicTacToe.Models.BotDifficultyLevel;
import TicTacToe.Models.BotPlayer;
import TicTacToe.Models.HumanPlayer;
import TicTacToe.Models.Player;

import java.util.Scanner;

public class PlayerFactory {
    public static Player getPlayer(String playerType){
        Player p=null;
        if(playerType.equals("Human"))
            p=getHumanPlayer();
        else if(playerType.equals("Bot"))
            p=getBOTPlayer();
        return p;
    }

    public static Player getHumanPlayer(){
        return new HumanPlayer();
    }

    public static Player getBOTPlayer(){
        Scanner cin=new Scanner(System.in);
        System.out.println("Enter Bot difficulty level");
        String botDifficulty=cin.nextLine();
        BotPlayer bot=new BotPlayer();
        bot.setBotDifficultyLevel(getBotDifficultyLevelFromInput(botDifficulty));
        bot.setBotPlayingStrategy();
        return bot;
    }

    private static BotDifficultyLevel getBotDifficultyLevelFromInput(String botDifficulty) {
        BotDifficultyLevel botDifficultyLevel;
        switch(botDifficulty) {
            case "Hard":
                botDifficultyLevel=BotDifficultyLevel.HARD;
                break;

            case "Medium":
                botDifficultyLevel=BotDifficultyLevel.MEDIUM;
                break;
            default:
                botDifficultyLevel=BotDifficultyLevel.EASY;
        }
        return botDifficultyLevel;
    }
}
