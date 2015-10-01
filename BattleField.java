public class BattleField {

    //@TODO: Ocean, Miss and Hit are actually properties of the display.
    //Move these into the display class. The battlefield should only be
    //responsible for knowing the locations of the ships and nothing else.
    public enum Tile {
        Ocean,
        Miss,
        Hit
    }

    //@TODO: split out player's own field from the radar,
    //players should only be able to see their own ships.

    private Tile[][] mBattleField; //@TODO: remove and replace with mShipLocations
    /**
     * true means there's a ship in the location, false means there is not
     */
    private boolean[][] mShipLocations;

    private static int MINIMUM_SIZE = 5;

    public BattleField(int size) {
        if (size >= MINIMUM_SIZE) {
            mBattleField = new Tile[size][size];
            mShipLocations = new boolean[size][size];
            initBoard();
        }
        else {
            throw new IllegalArgumentException(
                    String.format("Gameboard has to be at least %dx%d",
                        MINIMUM_SIZE, MINIMUM_SIZE));
        }
    }

    private void initBoard() {
        int size = size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mBattleField[i][j] = Tile.Ocean;
            }
        }
    }

    public int size() {
        return mBattleField.length;
    }

    /**
     * Returns the {@link Tile} in the tile mBattleField[x][y]
     * @return Returns a '?' if the coordinate is out of bounds.
     */
    public Tile tileAt(int x, int y) {
        return mBattleField[x][y];
    }

    /**
     * Returns true when a ship is located in the position (x, y).
     * @return true if ship is in location, false if it is not
     */
    public boolean isShipAtLocation(int x, int y) {
        return mShipLocations[x][y];
    }

    /**
     * Places a 1x1 ship at the coordinate (x, y)
     * @return returns true if the ship was successfully placed,
     *     false if there was a problem placing the ship.
     */
    public boolean addShip(int x, int y) {
        if (isShipAtLocation(x, y)) {
            return false;
        }

        mShipLocations[x][y] = true;
        return true;
    }
}
