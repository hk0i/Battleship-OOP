public abstract class BaseShipDistributor implements ShipDistributor {

    protected BattleField mBattleField;

    public BaseShipDistributor(BattleField field) {
        mBattleField = field;
    }

    /**
     * Defines how to display a message on the screen
     */
    protected abstract void displayMessage(String message);

    /**
     * Returns the coordinates of where the user would like to place the ship
     */
    protected abstract Point requestShipCoordinates();

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
                displayMessage(String.format("Enter coordinates for Ship %s: ", i));
                shipLocation = requestShipCoordinates();

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
                    break;
                }
            } while (!mBattleField.isValidShipLocation(shipLocation));
        }
    }

}