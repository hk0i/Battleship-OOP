import java.util.Scanner;
import java.util.Arrays;

public class Battleship {

    public static void main(String[] args) {
        BattleField playerField = new BattleField(10);

        System.out.println("Get ready to place your ships.");
        System.out.println("You get " + ShipDistributor.MAX_SHIPS + " ships, place them wisely");
        Scanner keyboard = new Scanner(System.in);

        for (int i = 0; i < ShipDistributor.MAX_SHIPS; i++) {
            boolean fact = false;
            while (fact != true) {
                System.out.print("Enter coordinates for Ship " + (i+1) + ": ");
                String coordinates = keyboard.nextLine();

                Point shipLocation = getPoint(coordinates);
                //TODO: Check if shipLocation is Point.INVALID_POINT (done)

                if (shipLocation == Point.INVALID_POINT) {
            	    System.out.println("you can't go there thats not on the map!");
                    }
                else {
                    playerField.addShip(shipLocation.getX(), shipLocation.getY());
                    fact = true;
                    }
                /**need to add a loop if player places INVALID_POINT we need to ask
                *Payeer 5 markers
                */

            }
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

    /**
     * Converts coordinates from A1 to (0, 0)
     * TODO: handle coordinate values >= 10
     */
    private static Point getPoint(String coordinate) {
        coordinate = coordinate.toUpperCase();

        if (coordinate.length() == 2) {
            char letter = coordinate.charAt(0);
            char number = coordinate.charAt(1);
           // char number10 = coordinate.charAt(2);
            int x = (letter - 'A');
            int y = Character.getNumericValue(number) - 1;

            if (x < 0 || y < 0){
                return Point.INVALID_POINT;
            }

            return new Point(x, y);
        }
        else if (coordinate.length() == 3) {
            char letter = coordinate.charAt(0);
            char number = coordinate.charAt(1);
            char number10 = coordinate.charAt(2);
            int x = (letter - 'A');
            int y;
            try {
                y = Integer.parseInt(coordinate.substring(1)) - 1;
            } catch (NumberFormatException e) {
                return Point.INVALID_POINT;
            }
            //int y10 = Character.getNumericValue(number10) - 1;
            if (x < 0 || y < 0){
                return Point.INVALID_POINT;
            }

            return new Point(x, y);
            //check if x or y are is less then 0 then return invalid point
        }
        else {
            return Point.INVALID_POINT;
        }

    }

}
