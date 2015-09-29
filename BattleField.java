public class BattleField {

    private char[][] mBattleField;

    private static int MINIMUM_SIZE = 5;

    public BattleField(int size) {
        if (size >= MINIMUM_SIZE) {
            mBattleField = new char[size][size];
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
                mBattleField[i][j] = '~';
            }
        }
    }

    public int size() {
        return mBattleField.length;
    }

    /**
     * Returns the character in the tile mBattleField[x][y]
     * @return Returns a '?' if the coordinate is out of bounds.
     */
    public char tileAt(int x, int y) {
        if (x < mBattleField.length && y < mBattleField[0].length) {
            return mBattleField[x][y];
        }

        return '?';
    }
}
