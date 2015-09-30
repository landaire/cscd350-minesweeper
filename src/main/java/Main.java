import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        List<Minefield> fields = new ArrayList<Minefield>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Minefield field = getGameboard(scanner);
            if (field == null) {
                break;
            }

            fields.add(field);
        }

        for (int i = 0; i < fields.size(); i++) {
            System.out.printf("Field #%d:\n", i + 1);
            SquareArrayHelper.print(fields.get(i).solve());
            System.out.println();
        }
    }

    /**
     * Reads a gameboard from the given scanner
     *
     * @param scanner input to read
     * @return null|Minefield null is returned when an error occurs or EOF reached
     */
    private static Minefield getGameboard(Scanner scanner) {
        // Read in the rows/columns
        int columns, rows;
        rows = scanner.nextInt();
        columns = scanner.nextInt();

        // discard linefeed. we first check if a next line exists in the case that
        // we are reading from a file and the final line does not have a linefeed
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        // check columns/rows for errors or EOF
        if (columns  == 0 && rows == 0) {
            return null;
        } else if (columns == 0 || rows == 0) {
            System.err.println("X or Y cannot be zero");
            return null;
        }


        Character[][] input = new Character[rows][columns];
        for (int row = 0; row < rows; row++) {
            char[] currRow = scanner.nextLine().toCharArray();

            for (int column = 0; column < columns; column++) {
                input[row][column] = currRow[column];
            }
        }

        return new Minefield(input);
    }
}
