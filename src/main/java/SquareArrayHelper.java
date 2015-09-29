/**
 * Created by Lander Brandt on 9/28/15.
 */

class SquareArrayHelper<T> {
    public enum Location {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        UP_RIGHT_CORNER,
        UP_LEFT_CORNER,
        DOWN_LEFT_CORNER,
        DOWN_RIGHT_CORNER,
        CENTER,
    }

    public static final Location[] locations = new Location[] {
            Location.UP,                Location.DOWN,                  Location.LEFT,              Location.RIGHT,
            Location.UP_RIGHT_CORNER,   Location.UP_LEFT_CORNER,        Location.DOWN_LEFT_CORNER,  Location.DOWN_RIGHT_CORNER,
            Location.CENTER,
    };

    private T[][] array;

    SquareArrayHelper(T[][] input) {
        array = input;
    }

    /**
     * @param loc location relative to x and y to get
     * @param x x index
     * @param y y index
     * @return value at loc relative to x and y
     */
    T get(Location loc, int x, int y) {
        if (!has(loc, x, y)) {
            throw new IllegalArgumentException(String.format("index at x %d and y %d does not exist", x, y));
        }

        switch (loc) {
            case UP:
                return array[y - 1][x];
            case DOWN:
                return array[y + 1][x];
            case LEFT:
                return array[y][x - 1];
            case RIGHT:
                return array[y][x + 1];
            case UP_RIGHT_CORNER:
                return array[y - 1][x + 1];
            case UP_LEFT_CORNER:
                return array[y - 1][x - 1];
            case DOWN_LEFT_CORNER:
                return array[y + 1][x - 1];
            case DOWN_RIGHT_CORNER:
                return array[y + 1][x + 1];
            case CENTER:
                return array[y][x];
            default:
                throw new IllegalArgumentException("unknown loc");
        }
    }

    /**
     * Sets the specified index relative to x and y to value
     *
     * @param loc location relative to x and y to set
     * @param x x index
     * @param y y index
     * @param value value to set
     */
    void set(Location loc, int x, int y, T value) {
        if (!has(loc, x, y)) {
            return;
        }

        switch (loc) {
            case UP:
                array[y - 1][x] = value;
                break;
            case DOWN:
                array[y + 1][x] = value;
                break;
            case LEFT:
                array[y][x - 1] = value;
                break;
            case RIGHT:
                array[y][x + 1] = value;
                break;
            case UP_RIGHT_CORNER:
                array[y - 1][x + 1] = value;
                break;
            case UP_LEFT_CORNER:
                array[y - 1][x - 1] = value;
                break;
            case DOWN_LEFT_CORNER:
                array[y + 1][x - 1] = value;
                break;
            case DOWN_RIGHT_CORNER:
                array[y + 1][x + 1] = value;
                break;
            case CENTER:
                array[y][x] = value;
                break;
        }
    }

    /**
     * @param loc location to check relative to x and y
     * @param x x index for the array
     * @param y y index for the array
     * @return boolean indicating whether or not the location relative to the x and y exist
     */
    boolean has(Location loc, int x, int y) {
        switch (loc) {
            case UP:
                return y > 0;
            case DOWN:
                return y < array.length - 1;
            case LEFT:
                return x > 0;
            case RIGHT:
                return x < array[y].length - 1;
            case UP_RIGHT_CORNER:
                return y > 0 && x < array[y].length - 1;
            case UP_LEFT_CORNER:
                return y > 0 && x > 0;
            case DOWN_LEFT_CORNER:
                return y < array.length - 1 && x > 0;
            case DOWN_RIGHT_CORNER:
                return y < array.length - 1 && x < array[y].length - 1;
            case CENTER:
                return y >= 0 && x >= 0 && y < array.length && x < array[y].length;
            default:
                throw new IllegalArgumentException("unknown loc");
        }
    }

    /**
     * @return the backing array
     */
    public T[][] getArray() {
        return array;
    }
}
