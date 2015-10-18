package com.code2coda.battleship.game;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

import com.code2coda.battleship.display.FieldDisplay;
import com.code2coda.battleship.gameboard.BattleField;
import com.code2coda.battleship.gameboard.Point;
import com.code2coda.battleship.shipdistribution.ShipDistributor;
import com.code2coda.battleship.shipdistribution.CliShipDistributor;
import com.code2coda.battleship.shipdistribution.RandomShipDistributor;

public class Game {

    private boolean mShowEnemyShips;
    private int mBoardSize;

    private FieldDisplay mPlayerDisplay;
    private FieldDisplay mComputerDisplay;

    private BattleField mPlayerField;
    private BattleField mComputerField;

    private Set<Point> mPlayerGuesses;

    private static Scanner mScanner;

    public Game() {
        this(10, false);
    }

    public Game(int boardSize, boolean showEnemyShips) {
        mBoardSize = boardSize;
        mShowEnemyShips = showEnemyShips;
        mPlayerGuesses = new HashSet<>();
        startGame();
    }

    /**
     * gets a scanner instance
     * @TODO: code smell - we should use one central scanner for the whole app,
     * @TODO: this input should somehow be separate from game logic
     */
    private synchronized Scanner scannerInstance() {
        if (mScanner == null) {
            mScanner = new Scanner(System.in);
        }

        return mScanner;
    }

    private void startGame() {
        initPlayer();
        initComputer();

        do {
            displayField("Player 1", mPlayerDisplay);
            displayField("Computer", mComputerDisplay);
        } while (takeTurn());
    }

    /**
     * Have the player take a turn, returns true if we should keep going
     *
     * @TODO: separate out player turns from computer turns using different
     *        classes with similar interfaces for takeTurn().
     */
    private boolean takeTurn() {
        System.out.println("Guess a location:");
        //@TODO: maybe something for parse point should be paired with input?
        Point location;
        boolean isInBounds = false;
        do {
            location = Point.parsePoint(scannerInstance().nextLine());
            isInBounds = mComputerField.isPointInBounds(location);
            if (!isInBounds) {
                System.out.println("That's not in the ocean, try again!");
            }
            else {
                if (mPlayerGuesses.add(location)) {
                    //@TODO: good location to separate firing a shot for radar
                    //@TODO: take result of isShipAtLocation() and track the miss on
                    //       a radar object.
                    if (mComputerField.fire(location)) {
                        System.out.println("Direct hit!");
                        if (mComputerField.areAllShipsDestroyed()) {
                            gameOver("Player");
                            return false;
                        }
                    }
                    else {
                        System.out.println("You missed :(");
                    }
                }
                else {
                    System.out.println(String.format("You already guessed %s, try again", location));
                }
            }
        } while (!isInBounds);

        return true;
    }

    private void initPlayer() {
        mPlayerField = new BattleField(mBoardSize);
        placeShips(mPlayerField, false);
        mPlayerDisplay = new FieldDisplay(mPlayerField, true);
    }

    private void initComputer() {
        mComputerField = new BattleField(mBoardSize);
        placeShips(mComputerField, true);
        mComputerDisplay = new FieldDisplay(mComputerField, mShowEnemyShips);
    }

    private void displayField(String playerName, FieldDisplay fieldDisplay) {
        System.out.println(playerName);
        fieldDisplay.render();
    }

    private void placeShips(BattleField field, boolean isComputer) {
        ShipDistributor distributor;
        if (isComputer) {
            distributor = new RandomShipDistributor(field);
        }
        else {
            distributor = new CliShipDistributor(field);
        }

        distributor.placeShips();
    }

    void gameOver(String winner) {
        System.out.println("Game Over!");
        System.out.println(winner + " wins!");
    }
}