package com.code2coda.battleship.gameboard;

public class Point extends java.awt.Point {

    public static Point INVALID_POINT = new Point(-1, -1);

    public Point(int x, int y) {
        super(x, y);
    }

    /**
     * Converts coordinates from A1 to (0, 0)
     *
     * @param coordinate String coordinate which is a letter and number
     *    combination such as A1, B3, C10 and as in the original battleship
     *    game
     */
    public static Point parsePoint(String coordinate) {
        coordinate = coordinate.toUpperCase();

        if (coordinate.length() <= 3 && coordinate.length() >= 2) {

            char letter = coordinate.charAt(0);
            String number = coordinate.substring(1);

            int x = (letter - 'A');
            try {
                int y = Integer.parseInt(number) - 1;
                return new Point(x, y);
            }
            catch (NumberFormatException e) {
                return Point.INVALID_POINT;
            }
        }
        else {
            return Point.INVALID_POINT;
        }
    }

    /**
     * Returns the location in standard battleship format A1, A2, etc..
     */
    @Override
    public String toString() {
        return String.format("%c%d", ('A' + x), y + 1);
    }
}
