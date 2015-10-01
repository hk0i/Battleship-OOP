import java.util.Random;

public class Battleship {
    private static int MAX_SHIPS = 5;

    public static void main(String[] args) {
        BattleField playerField = new BattleField(10);

        playerField.addShip(1, 1);
        playerField.addShip(0, 3);
        playerField.addShip(9, 3);
        playerField.addShip(2, 1);

        System.out.println("Player's Field:");
        FieldDisplay playerDisplay = new FieldDisplay(playerField, true);
        playerDisplay.render();

        BattleField computerField = new BattleField(10);
        randomlyPlaceShips(computerField);

        System.out.println();
        System.out.println("Computer's Field:");
        boolean showComputerShips = (args.length > 0 && args[0].equals("--show-computer-ships"));
        FieldDisplay computerDisplay = new FieldDisplay(computerField, showComputerShips);
        computerDisplay.render();

    }

    /**
     * Attempts to place a ship at a random location in the battlefield.
     * @TODO: move these random placement methods into a ComputerBattleField subclass
     */
    public static boolean addShipAtRandomLocation(BattleField field) {
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
