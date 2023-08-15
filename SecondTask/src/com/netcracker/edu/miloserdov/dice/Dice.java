package com.netcracker.edu.miloserdov.dice;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Class of games with N players and K cubes.
 * Implements interface of games.
 * Contains the method of playing.
 */

public class Dice implements Game{

    /**
     * parameters of the game
     * { String "Number of players" : int numberOfPlayers , String "Number of cubes" : int numberOfCubes}
      */

    private Map<String,Integer> parameters;

    /**
     * Get Map of parameters from input number of players and number of cubes.
     * @param numberOfPlayers
     * @param numberOfCubes
     * @return Map<String paramName, int paramValue>
     */

    public static Map getGameParameters(int numberOfPlayers, int numberOfCubes) {

        Map<String,Integer>  parameters = new HashMap();
        parameters.put("Number of players", numberOfPlayers);
        parameters.put("Number of cubes", numberOfCubes);

        return parameters;
    }

    /**
     * Get Map of parameters from Scanner.
     * @param scanner
     * @return Map<String paramName, int paramValue>
     */

    public static Map getGameParameters(Scanner scanner) {
        int numberOfPlayers;
        int numberOfCubes;
        try {
            System.out.println("Enter the number of players:");
            numberOfPlayers = scanner.nextInt();
            System.out.println("Enter the number of cubes:");
            numberOfCubes = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Invalid input, try again");
            return null;
        }
        Map<String,Integer>  parameters = new HashMap();
        parameters.put("Number of players", numberOfPlayers);
        parameters.put("Number of cubes", numberOfCubes);

        return parameters;
    }

    @Override
    public void setGameParameters(Map parameters) {
        this.parameters = parameters;
    }

    /**
     * Starts the game.
     */

    @Override
    public void start() {
        int N;
        int K;
        try {
            N = parameters.get("Number of players");

            K = parameters.get("Number of cubes");
        }catch (NullPointerException e){
            System.out.println("Please set game parameters by setGameParameters(Map parameters)");
            return;
        }

        int[] playerDice = new int[N + 1];              // points of players in each game [0 ; K*6]
        int[] playerScore = new int[N + 1];             // points of players in the whole game [0;7]
        int rand;                                       // supporting variable for random number
        int winner = 0;                                 // supporting variable for winner's index in playerDice array
        int game = 1;                                   // game number

        while (Array.findMax(playerScore) != 7) {       // playing until someone reaches 7 points
            int temp = 0;

            /*
            play again until there is only one player with the maximum number left (see line 72)
             */

            while (Array.bubbleSort(playerDice)[playerDice.length - 2] != -1) {
                if (temp == 0) {
                    System.out.println("Game - " + game);
                } else {
                    System.out.println("Extra game for winners");
                }
                if (winner != playerDice.length - 1) {
                    System.out.println(winner + 1 + " Player:");
                } else {
                    System.out.println("Computer:");
                }
                for (int j = 0; j < K; j++) {                              // throwing the dice of the first player
                    rand = (int) (Math.random() * 6) + 1;
                    playerDice[winner] += rand;
                    if (j != 0) {
                        System.out.print("+ ");
                    }
                    System.out.print(rand + " ");
                }
                System.out.println("= " + playerDice[winner]);

                for (int i = 0; i < playerDice.length; i++) {             // throwing the dice of the remaining players
                    if (playerDice[i] == 0) {

                        if (i != playerDice.length - 1) {
                            System.out.println(i + 1 + " Player:");
                        } else {
                            System.out.println("Computer:");
                        }

                        for (int j = 0; j < K; j++) {
                            rand = (int) (Math.random() * 6) + 1;
                            playerDice[i] += rand;
                            if (j != 0) {
                                System.out.print("+ ");
                            }
                            System.out.print(rand + " ");
                        }
                        System.out.println("= " + playerDice[i]);
                    }
                }
                int maxvalue = Array.findMax(playerDice);                  // Maximum value obtained in the game

                /*
                Setting 0 to players with the same maximum value in the game and -1 to other, due to
                separate winners and losers after each game. If there are 2 or more winners in previous
                game, an extra game for winners will start (see line 33).
                 */

                for (int i = 0; i < playerScore.length; i++) {
                    if (playerDice[i] != maxvalue) {
                        playerDice[i] = -1;
                    } else {
                        playerDice[i] = 0;
                    }
                }

                temp++;

                winner = Array.findMaxKey(playerDice);                     // index of winner in playerDice

            }

            System.out.println();

            playerScore[winner]++;

            if (winner == playerScore.length - 1) {
                System.out.println("Player \"Computer\" wins, he has " + playerScore[winner] + " points");
            } else {
                System.out.println("Player \"" + (winner + 1) + "\" wins, he has " + playerScore[winner] + " points");
            }

            for (int i = 0; i < playerScore.length; i++) {
                playerDice[i] = 0;

            }
            game++;                                                        // counter of games
            System.out.println();
        }
        if((Array.findMaxKey(playerScore) != playerScore.length - 1)) {
            System.out.println("Congratulations to Player \"" + (Array.findMaxKey(playerScore) + 1) + "\"");
        }else{
            System.out.println("Congratulations to Computer :)");
        }
    }
}
