import java.util.Random;

/**
 * Distributes ships randomly across a {@link BattleField}
 */
public class RandomShipDistributor extends BaseShipDistributor {

    public RandomShipDistributor(BattleField field) {
        super(field);
    }
    
    @Override
    protected Point requestShipCoordinates() {
        int fieldSize = mBattleField.size();
        Random r = new Random();
        int randomX = r.nextInt(fieldSize);
        int randomY = r.nextInt(fieldSize);
        
        return new Point(randomX, randomY);
    }

    /**
     * Attempts to place a ship at a random location in the battlefield.
     * @TODO: move these random placement methods into a ComputerBattleField subclass
     */
    @Override
    protected boolean placeSingleShip(int shipNumber, Point shipLocation) {
        return mBattleField.addShip(shipLocation);
    }
}
