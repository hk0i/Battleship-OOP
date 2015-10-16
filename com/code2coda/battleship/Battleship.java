package com.code2coda.battleship;

import com.code2coda.battleship.display.FieldDisplay;

import com.code2coda.battleship.gameboard.BattleField;

import com.code2coda.battleship.shipdistribution.ShipDistributor;
import com.code2coda.battleship.shipdistribution.CliShipDistributor;
import com.code2coda.battleship.shipdistribution.RandomShipDistributor;

public class Battleship {

    public static void main(String[] args) {
        final int fieldSize = 10;
        BattleField playerField = new BattleField(fieldSize);

        System.out.println("Get ready to place your ships.");
        System.out.println(String.format("You get %d ships, place them wisely",
            ShipDistributor.MAX_SHIPS));

        ShipDistributor playerDistributor = new CliShipDistributor(playerField);
        playerDistributor.placeShips();

        System.out.println("Player's Field:");
        FieldDisplay playerDisplay = new FieldDisplay(playerField, true);
        playerDisplay.render();

        BattleField computerField = new BattleField(fieldSize);

        ShipDistributor computerDistributor
            = new RandomShipDistributor(computerField);
        computerDistributor.placeShips();

        System.out.println();
        System.out.println("Computer's Field:");
        boolean showComputerShips = (args.length > 0 && args[0].equals("--show-computer-ships"));
        FieldDisplay computerDisplay = new FieldDisplay(computerField, showComputerShips);
        computerDisplay.render();
    }

}
