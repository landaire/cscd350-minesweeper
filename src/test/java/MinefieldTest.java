import junit.framework.TestCase;

/**
 * Created by Lander Brandt on 9/29/15.
 */
public class MinefieldTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();


    }

    public void testSolve() throws Exception {
        Character[][] testcase = MinefieldTestcases.maxArray();

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

//        SquareArrayHelper.print(result);
    }
}
