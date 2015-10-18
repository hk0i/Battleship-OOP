package com.code2coda.battleship.shipdistribution;

import com.code2coda.battleship.gameboard.BattleField;
import com.code2coda.battleship.gameboard.Point;

import java.util.Random;

/**
 * Distributes ships randomly across a {@link BattleField}
 */
public class RandomShipDistributor extends BaseShipDistributor {

    public RandomShipDistributor(BattleField field) {
        super(field);
    }

    @Override
    protected Point requestShipCoordinates(int shipNumber) {
        int fieldSize = mBattleField.size();
        Random r = new Random();
        int randomX = r.nextInt(fieldSize);
        int randomY = r.nextInt(fieldSize);

        return new Point(randomX, randomY);
    }

    /**
     * Attempts to place a ship at a random location in the battlefield.
     */
    @Override
    protected boolean placeSingleShip(Point shipLocation) {
        return mBattleField.addShip(shipLocation);
    }
}
