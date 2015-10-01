import java.util.Random;

/**
 * Distributes ships randomly across a {@link BattleField}
 */
public class ShipDistributor {

    private static int MAX_SHIPS = 5;

    /**
     * Attempts to place a ship at a random location in the battlefield.
     * @TODO: move these random placement methods into a ComputerBattleField subclass
     */
    private static boolean addShipAtRandomLocation(BattleField field) {
        int fieldSize = field.size();
        Random r = new Random();
        int randomX = r.nextInt(fieldSize);
        int randomY = r.nextInt(fieldSize);

        return field.addShip(randomX, randomY);
    }

    /**
     * Randomly places {@link MAX_SHIPS} number of ships on the provided field
     */
    public static void randomlyPlaceShips(BattleField field) {
        for (int i = 0; i < MAX_SHIPS; i++) {
            boolean shipWasAdded;
            do {
                shipWasAdded = addShipAtRandomLocation(field);
            } while (!shipWasAdded);
        }
    }
}
