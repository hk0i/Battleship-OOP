public class BattleField {

    public enum Tile {
        Ocean,
        Miss,
        Hit
    }

    private Tile[][] mBattleField;

    private static int MINIMUM_SIZE = 5;

    public BattleField(int size) {
        if (size >= MINIMUM_SIZE) {
            mBattleField = new Tile[size][size];
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
}
