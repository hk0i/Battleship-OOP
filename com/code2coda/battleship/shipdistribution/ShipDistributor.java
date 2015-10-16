package com.code2coda.battleship.shipdistribution;

public interface ShipDistributor {

    public static final int MAX_SHIPS = 5;

    /**
     * implementation specific method to place ships on the map
     */
    void placeShips();
}