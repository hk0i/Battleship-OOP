public abstract class BaseShipDistributor implements ShipDistributor {

    protected BattleField mBattleField;

    public BaseShipDistributor(BattleField field) {
        mBattleField = field;
    }

    /**
     * Returns the coordinates of where the user would like to place the ship
     */
    protected abstract Point requestShipCoordinates();

    /**
     * Places a single ship on the map
     */
    protected abstract boolean placeSingleShip(int shipNumber, Point shipLocation);

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
                shipLocation = requestShipCoordinates();
                boolean shipWasAdded = placeSingleShip(i + 1, shipLocation);
                if (shipWasAdded) {
                    break;
                }
            } while (!mBattleField.isValidShipLocation(shipLocation));
        }
    }

}