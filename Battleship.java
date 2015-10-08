import java.util.Scanner;

public class Battleship {

    public static void main(String[] args) {
        BattleField playerField = new BattleField(10);

        System.out.println("Get ready to place your ships.");
        System.out.println(String.format("You get %d ships, place them wisely",
            ShipDistributor.MAX_SHIPS));
        Scanner keyboard = new Scanner(System.in);

        Point shipLocation = null;
        for (int i = 0; i < ShipDistributor.MAX_SHIPS; i++) {
            do {
                System.out.print(String.format("Enter coordinates for Ship %s: ", i));
                String coordinates = keyboard.nextLine();
                shipLocation = Point.parsePoint(coordinates);
                
                if (playerField.isShipAtLocation(shipLocation)) {
                    System.out.println("You have already placed a ship at " + coordinates + ", try again.");
                }
                else if (!playerField.isValidShipLocation(shipLocation)) {
                    System.out.println(coordinates + " is not a valid ship location, please try again");
                }
                else {
                    playerField.addShip(shipLocation.getX(), shipLocation.getY());
                    break;
                }
            } while (!playerField.isValidShipLocation(shipLocation));
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
    
}
