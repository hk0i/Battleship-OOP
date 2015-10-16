package com.code2coda.battleship.shipdistribution;

import com.code2coda.battleship.gameboard.BattleField;
import com.code2coda.battleship.gameboard.Point;

import java.util.Scanner;


/**
 * Places ships on the {@link BattleField} using the command line interface.
 * Uses {@link java.util.Scanner} for input and {@link System.out.println()}
 * for output
 */
public class CliShipDistributor extends PlayerShipDistributor {

    private static Scanner mKeyboard;

    private Scanner scannerInstance() {
        if (mKeyboard == null) {
            mKeyboard = new Scanner(System.in);
        }

        return mKeyboard;
    }

    public CliShipDistributor(BattleField field) {
        super(field);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public Point requestShipCoordinates(int shipNumber) {
        displayMessage(String.format("Enter coordinates for Ship %s: ",
            shipNumber));
        return Point.parsePoint(scannerInstance().nextLine());
    }

}