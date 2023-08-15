package com.netcracker.edu.miloserdov.dice;

import java.util.Map;
import java.util.Scanner;

public class Main {

    static public void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Game dice = new Dice();

        Map parameters = Dice.getGameParameters(input);

        dice.setGameParameters(parameters);

        dice.start();

        parameters = Dice.getGameParameters(2, 4);

        dice.setGameParameters(parameters);

        dice.start();

    }
}
