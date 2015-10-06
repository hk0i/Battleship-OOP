public class Point {

    public static Point INVALID_POINT = new Point(-1, -1);

    private final int mX;
    private final int mY;

    public Point(int x, int y) {
        mX = x;
        mY = y;
    }

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }
}
