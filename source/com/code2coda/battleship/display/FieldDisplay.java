package com.code2coda.battleship.display;

import com.code2coda.battleship.gameboard.BattleField;

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
        System.out.print(" ");
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0) {
                    System.out.print(" " + j);
                }
                else {
                    System.out.print(String.format("%c ", tileToChar(i - 1, j)));
                }
            }
            System.out.println();
            if (i < mField.size()) System.out.print(String.format("%c ", 'A' + i));
            else System.out.println();
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
                //@TODO: this is a code smell / SRP violation
                //only show misses when we don't show ships :)
                if (!mShowShips) {
                    retChar = 'O';
                }
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
