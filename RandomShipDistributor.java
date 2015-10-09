import java.util.Random;

/**
 * Distributes ships randomly across a {@link BattleField}
 */
public class RandomShipDistributor implements ShipDistributor {
    
    private BattleField mBattleField;

    public RandomShipDistributor(BattleField field) {
        mBattleField = field;
    }

    /**
     * Attempts to place a ship at a random location in the battlefield.
     * @TODO: move these random placement methods into a ComputerBattleField subclass
     */
    private boolean addShipAtRandomLocation() {
        int fieldSize = mBattleField.size();
        Random r = new Random();
        int randomX = r.nextInt(fieldSize);
        int randomY = r.nextInt(fieldSize);

        return mBattleField.addShip(randomX, randomY);
    }

    /**
     * Randomly places {@link MAX_SHIPS} number of ships on the provided field
     */
    private void randomlyPlaceShips() {
        for (int i = 0; i < MAX_SHIPS; i++) {
            boolean shipWasAdded;
            do {
                shipWasAdded = addShipAtRandomLocation();
            } while (!shipWasAdded);
        }
    }

    /**
     * Randomly places ships on the battlefield
     */
    @Override
    public void placeShips() {
        randomlyPlaceShips();
    }
}
