import junit.framework.TestCase;

/**
 * Created by Lander Brandt on 9/29/15.
 */
public class MinefieldTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();


    }

    public void testSolveLarge() throws Exception {
        Character[][] testcase = maxArray();

        SquareArrayHelper<Character> array = new SquareArrayHelper<Character>(testcase);
        // set the bombs at all corners
        array.set(SquareArrayHelper.Location.CENTER, 0, 0, '*');
        array.set(SquareArrayHelper.Location.CENTER, testcase.length - 1, 0, '*');
        array.set(SquareArrayHelper.Location.CENTER, testcase.length - 1, testcase.length - 1, '*');
        array.set(SquareArrayHelper.Location.CENTER, 0, testcase.length - 1, '*');

        // set two bombs in the middle
        array.set(SquareArrayHelper.Location.CENTER, (testcase.length - 1) / 2, (testcase.length - 1) / 2, '*');
        array.set(SquareArrayHelper.Location.CENTER, ((testcase.length - 1) / 2) - 1, ((testcase.length - 1) / 2) - 1, '*');

        Minefield minefield = new Minefield(testcase);
        Character[][] result = minefield.solve();


        Integer[][] testCaseResults = new Integer[][] {
                // x, y, value

                // upper-left corner
                {1, 0, 1},
                {0, 1, 1},
                {1, 1, 1},

                // upper-right corner
                {testcase.length - 2, 0, 1},
                {testcase.length - 2, 1, 1},
                {testcase.length - 1, 1, 1},

                // lower-left corner
                {0, testcase.length - 2, 1},
                {1, testcase.length - 2, 1},
                {1, testcase.length - 1, 1},

                // lower-right corner
                {testcase.length - 2, testcase.length - 1, 1},
                {testcase.length - 2, testcase.length - 2, 1},
                {testcase.length - 1, testcase.length - 2, 1},

                // center. this doesn't cover all values, but is good enough
                {((testcase.length - 1) / 2), ((testcase.length - 1) / 2) - 1, 2},
                {((testcase.length - 1) / 2) - 1, ((testcase.length - 1) / 2), 2},
                {((testcase.length - 1) / 2), ((testcase.length - 1) / 2) + 1, 1},
                {((testcase.length - 1) / 2) - 2, ((testcase.length - 1) / 2), 1},
        };

        for (Integer[] values : testCaseResults) {
            // use strings here since we're comparing ints and chars originally
            assertEquals(values[2].toString(), result[values[1]][values[0]].toString());
        }
    }

    public void testSolveMin() throws Exception {
        Minefield field = new Minefield(minArray());
        Character[][] result = field.solve();

        assertEquals((Character)'0', result[0][0]);
    }

    private static Character[][] maxArray() {
        final int maxSize = 100;
        return genArray(maxSize, maxSize);
    }

    private static Character[][] minArray() {
        final int minSize = 1;
        return genArray(minSize, minSize);
    }

    private static Character[][] genArray(int rows, int cols) {
        Character[][] output = new Character[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                output[i][j] = '.';
            }
        }

        return output;
    }
}
