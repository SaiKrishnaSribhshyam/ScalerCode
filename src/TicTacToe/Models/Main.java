package TicTacToe.Models;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        System.out.println("Enter number of Players;");
        int players=cin.nextInt();
        System.out.println("Enter dimension:");
        int dimension=cin.nextInt();
        Game game=Game.getBuilder().setBoard(dimension)
                .setPlayers(players)
                .setGameStatus()
                .setLastIndex().build();
        System.out.println("Starting Game");
        game.start();
    }
}
