import java.util.Scanner;

/**
 * Places ships on the {@link BattleField} using the command line interface.
 * Uses {@link java.util.Scanner} for input and {@link System.out.println()}
 * for output
 */
public class CliShipDistributor extends BaseShipDistributor {
    
    private static Scanner mKeyboard;
    
    private Scanner scannerInstance() {
        if (mKeyboard == null) {
            mKeyboard = new Scanner(System.in);
        }
        
        return mKeyboard;
    }

    public CliShipDistributor(BattleField field) {
        super(field);
    }
    
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    @Override
    public Point requestShipCoordinates() {
        return Point.parsePoint(scannerInstance().nextLine());
    }

}