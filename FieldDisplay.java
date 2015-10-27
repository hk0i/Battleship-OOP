public class FieldDisplay {

    private BattleField mField;
    private boolean mShowShips;

    /**
     * Constructs a FieldDisplay object that can show the radar or the player's
     * ships
     */
    public FieldDisplay(BattleField field, boolean showShips) {
        mField = field;
        mShowShips = showShips;
    }

    public void render() {
        int size = mField.size();
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < size; i++) {
            System.out.print((char)(i + ('A')) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(String.format("%c ", tileToChar(i, j)));
            }

            System.out.println();
        }
    }

    public char tileToChar(int x, int y) {
        char retChar = '?';
        BattleField.Tile tile = mField.tileAt(x, y);

        switch (tile) {
            case Ocean:
                retChar = '~';
                break;

            case Miss:
                retChar = 'O';
                break;

            case Hit:
                retChar = 'X';
                break;

        }

        if (mShowShips && tile != BattleField.Tile.Hit
                && mField.isShipAtLocation(x, y)) {
            retChar = '$';
        }

        return retChar;
    }
}
