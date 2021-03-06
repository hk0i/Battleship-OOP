package com.code2coda.battleship.shipdistribution;

import com.code2coda.battleship.gameboard.BattleField;
import com.code2coda.battleship.gameboard.Point;


public abstract class BaseShipDistributor implements ShipDistributor {

    protected BattleField mBattleField;

    public BaseShipDistributor(BattleField field) {
        mBattleField = field;
    }

    /**
     * Returns the coordinates of where the user would like to place the ship
     */
    protected abstract Point requestShipCoordinates(int shipNumber);

    /**
     * Places a single ship on the map
     */
    protected abstract boolean placeSingleShip(Point shipLocation);

    /**
     * Places ships on the {@link BattleField} by getting input
     * from {@link #requestShipCoordinates} and takes care of most ship placement
     * logic and error handling.
     */
    @Override
    public void placeShips() {
        Point shipLocation = null;
        for (int i = 0; i < ShipDistributor.MAX_SHIPS; i++) {
            do {
                shipLocation = requestShipCoordinates(i + 1);
                boolean shipWasAdded = placeSingleShip(shipLocation);
                if (shipWasAdded) {
                    break;
                }
            } while (!mBattleField.isValidShipLocation(shipLocation));
        }
    }

}