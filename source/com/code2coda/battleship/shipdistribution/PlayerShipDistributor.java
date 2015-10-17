package com.code2coda.battleship.shipdistribution;

import com.code2coda.battleship.gameboard.BattleField;
import com.code2coda.battleship.gameboard.Point;

public abstract class PlayerShipDistributor extends BaseShipDistributor {

    /**
     * Defines how to display a message on the screen
     */
    protected abstract void displayMessage(String message);

    public PlayerShipDistributor(BattleField field) {
        super(field);
    }

    @Override
    protected boolean placeSingleShip(Point shipLocation) {

        //to distinguish between different errors
        //check first if there's a ship location
        if (mBattleField.isShipAtLocation(shipLocation)) {
            displayMessage("You have already placed a ship there, try again.");
        }
        //otherwise check if the ship is not in bounds
        else if (!mBattleField.isPointInBounds(shipLocation)) {
            displayMessage("That is not a valid ship location, please try again");
        }
        else {
            mBattleField.addShip(shipLocation.getX(), shipLocation.getY());
            return true;
        }

        return false;
    }

    @Override
    public void placeShips() {
        displayMessage("Get ready to place your ships.");
        displayMessage(String.format("You get %d ships, place them wisely",
            ShipDistributor.MAX_SHIPS));

        super.placeShips();
    }
}