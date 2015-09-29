import junit.framework.TestCase;

/**
 * Created by Lander Brandt on 9/28/15.
 */
public class SquareArrayHelperTest extends TestCase {
    private SquareArrayHelper<Integer> helper;


    public void setUp() throws Exception {
        super.setUp();

        helper = new SquareArrayHelper<Integer>(new Integer[][]{
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        });
    }

    public void testGet() throws Exception {
        assertEquals(2, (int)helper.get(SquareArrayHelper.Location.CENTER, 2, 0));
        assertEquals(5, (int)helper.get(SquareArrayHelper.Location.UP_LEFT_CORNER, 2, 2));
        assertEquals(15, (int)helper.get(SquareArrayHelper.Location.DOWN_RIGHT_CORNER, 2, 2));
        assertEquals(13, (int)helper.get(SquareArrayHelper.Location.DOWN_LEFT_CORNER, 2, 2));
        assertEquals(7, (int)helper.get(SquareArrayHelper.Location.UP_RIGHT_CORNER, 2, 2));
        assertEquals(6, (int)helper.get(SquareArrayHelper.Location.UP, 2, 2));
        assertEquals(14, (int)helper.get(SquareArrayHelper.Location.DOWN, 2, 2));
        assertEquals(9, (int)helper.get(SquareArrayHelper.Location.LEFT, 2, 2));
        assertEquals(11, (int)helper.get(SquareArrayHelper.Location.RIGHT, 2, 2));
    }

    public void testSet() throws Exception {
        // todo: test more cases here
        helper.set(SquareArrayHelper.Location.DOWN_LEFT_CORNER, 2, 2, 30);
        assertEquals(30, (int) helper.get(SquareArrayHelper.Location.DOWN_LEFT_CORNER, 2, 2));
        helper.set(SquareArrayHelper.Location.DOWN_LEFT_CORNER, 2, 2, 13);
        assertEquals(13, (int) helper.get(SquareArrayHelper.Location.DOWN_LEFT_CORNER, 2, 2));
    }

    public void testHas() throws Exception {
        // todo: test more cases. though if the testGet() succeeds, we can assume this method is working
        // properly since both get and set call has

        assertEquals(false, helper.has(SquareArrayHelper.Location.LEFT, 0, 0));
    }
}
