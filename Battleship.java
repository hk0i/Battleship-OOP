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
        ShipDistributor.randomlyPlaceShips(computerField);

        System.out.println();
        System.out.println("Computer's Field:");
        boolean showComputerShips = (args.length > 0 && args[0].equals("--show-computer-ships"));
        FieldDisplay computerDisplay = new FieldDisplay(computerField, showComputerShips);
        computerDisplay.render();

    }

}
