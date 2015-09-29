/**
 * Created by Lander Brandt on 9/29/15.
 */
public class MinefieldTestcases {
    final static int maxSize = 100;

    public static Character[][] maxArray() {
        Character[][] output = new Character[maxSize][maxSize];

        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                output[i][j] = '.';
            }
        }

        return output;
    }
}
