/**
 * Created by Lander Brandt on 9/25/15.
 */
public class Minefield {
    final int MINE = -1;
    final int EMPTY = 0;
    private Integer[][] minefield;

    /**
     *
     * @param minefield should be a square two-dimensional array consisting of dots and stars.
     *                  stars represent mines, dots represents "safe" spots.
     *                  e.g.:
     *                  <pre>
     *                      ...
     *                      ..*
     *                      *..
     *                  </pre>
     */
    public Minefield(Character[][] minefield) {
        this.minefield = new Integer[minefield.length][minefield[0].length];

        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[i].length; j++) {
                this.minefield[i][j] = minefield[i][j] == '*' ? MINE : EMPTY;
            }
        }
    }

    public Character[][] solve() {
        Integer[][] minefieldCopy = new Integer[minefield.length][minefield[0].length];
        for (int i = 0; i < minefield.length; i++) {
            System.arraycopy(minefield[i], 0, minefieldCopy[i], 0, minefieldCopy[i].length);
        }

        SquareArrayHelper<Integer> array = new SquareArrayHelper<Integer>(minefieldCopy);

        /*
        Iterate over every index in the array. The purpose of this is to find
        mines and increment all values surrounding if they're not mines as well.
        */
        for (int y = 0; y < minefieldCopy.length; y++) {
            for (int x = 0; x < minefieldCopy[y].length; x++) {
                if (minefieldCopy[y][x] != MINE) {
                    continue;
                }

                // We hit a mine, so increment all surrounding locations except for center
                for (SquareArrayHelper.Location loc : SquareArrayHelper.locations) {
                    if (loc == SquareArrayHelper.Location.CENTER || !array.has(loc, x, y )) {
                        continue;
                    }

                    Integer currentValue = array.get(loc, x, y);
                    if (currentValue != MINE) {
                        array.set(loc, x, y, currentValue + 1);
                    }
                }
            }
        }

        Character[][] returnValue = new Character[minefieldCopy.length][minefieldCopy[0].length];

        for (int y = 0; y < minefieldCopy.length; y++) {
            for (int x = 0; x < minefieldCopy[y].length; x++) {
                Integer value = minefieldCopy[y][x];

                if (value == MINE) {
                    returnValue[y][x] = '*';
                } else {
                    // we can safely convert this to a char and take index 0 since we'll
                    // never have more than 8 mines surrounding one location
                    returnValue[y][x] = value.toString().toCharArray()[0];
                }
            }
        }

        return returnValue;
    }
}
