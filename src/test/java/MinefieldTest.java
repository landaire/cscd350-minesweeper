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
        array.set(SquareArrayHelper.Location.CENTER, (testcase.length - 2) / 2, (testcase.length - 2) / 2, '*');

        Minefield minefield = new Minefield(testcase);
        Character[][] result = minefield.solve();
    }
}
