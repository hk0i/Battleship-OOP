import java.util.Scanner;

public class Battleship {

    public static void main(String[] args) {
        BattleField playerField = new BattleField(10);

        System.out.println("Get ready to place your ships.");
        //@TODO: replace the number 5 with the constant MAX_SHIPS
        System.out.println("You get 5 ships, place them wisely");
        Scanner keyboard = new Scanner(System.in);

        Point shipLocation = null;
        for (int i = 0; i < ShipDistributor.MAX_SHIPS; i++) {
            do {
                System.out.print(String.format("Enter coordinates for Ship %s: ", i));
                String coordinates = keyboard.nextLine();
                shipLocation = getPoint(coordinates);
                
                if (playerField.isShipAtLocation(shipLocation)) {
                    System.out.println("You have already placed a ship at " + coordinates + ", try again.");
                }
                else if (!isValidShipLocation(shipLocation, playerField)) {
                    System.out.println(coordinates + " is not a valid ship location, please try again");
                }
                else {
                    playerField.addShip(shipLocation.getX(), shipLocation.getY());
                    break;
                }
            } while (!isValidShipLocation(shipLocation, playerField));
        }
        

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
    
    private static boolean isValidShipLocation(Point shipLocation, BattleField field) {
        int fieldSize = field.size();
        int x = shipLocation.getX();
        int y = shipLocation.getY();
        
        return shipLocation != Point.INVALID_POINT
                && x < fieldSize && x >= 0
                && y < fieldSize && y >= 0
                && !field.isShipAtLocation(shipLocation);
    }

    /**
     * Converts coordinates from A1 to (0, 0)
     * TODO: handle coordinate values >= 10
     */
    private static Point getPoint(String coordinate) {
        coordinate = coordinate.toUpperCase();

        if (coordinate.length() <= 3) {
            
            char letter = coordinate.charAt(0);
            String number = coordinate.substring(1);

            int x = (letter - 'A');
            int y = Integer.parseInt(number) - 1;

            return new Point(x, y);
        }
        else {
            return Point.INVALID_POINT;
        }
    }

}
