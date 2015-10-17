package com.code2coda.battleship.game;

import com.code2coda.battleship.display.FieldDisplay;
import com.code2coda.battleship.gameboard.BattleField;
import com.code2coda.battleship.shipdistribution.ShipDistributor;
import com.code2coda.battleship.shipdistribution.CliShipDistributor;
import com.code2coda.battleship.shipdistribution.RandomShipDistributor;

public class Game {

    private boolean mShowEnemyShips;
    private int mBoardSize;

    private FieldDisplay mPlayerDisplay;
    private FieldDisplay mComputerDisplay;

    public Game() {
        this(10, false);
    }

    public Game(int boardSize, boolean showEnemyShips) {
        mBoardSize = boardSize;
        mShowEnemyShips = showEnemyShips;
        startGame();
    }

    private void startGame() {
        BattleField playerField = new BattleField(mBoardSize);
        placeShips(playerField, false);
        mPlayerDisplay = new FieldDisplay(playerField, true);

        displayField("Player 1", mPlayerDisplay);

        BattleField computerField = new BattleField(mBoardSize);
        placeShips(computerField, true);

        mComputerDisplay = new FieldDisplay(computerField, mShowEnemyShips);
        displayField("Computer", mComputerDisplay);
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
}