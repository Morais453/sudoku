package teste;
import java.util.Arrays;
import java.util.Random;

public class BoardTest {
    private String[][] board = new String[3][3];

    /*
    *function used to "populate" the table taking into account the filling of 4 distinct values per line
    * */
    public void popularBoard() {
        Random numericalGenerator = new Random();
        for (String[] stringsArray : board) {

            Arrays.fill(stringsArray, "     ");
            int count = 0;

            while (count < 3) {
                int randomFilling = numericalGenerator.nextInt(3);
                var randomValue = String.valueOf(numericalGenerator.nextInt(4));

                var horizontalValidator = true;

                for (String string : stringsArray) {
                    if (string.contains(randomValue)) {
                        horizontalValidator = false;
                        break;
                    }
                }
                if (stringsArray[randomFilling].isBlank() && horizontalValidator) {
                    stringsArray[randomFilling] = "  " + randomValue + "  ";
                    count++;
                }

            }

        }
    }
    public void printBoard() {
        for (int l = 0; l < 3; l++) {

            for (int c = 0; c < 3; c++) {
                System.out.print(board[l][c]+"|");

                if (c == 2 ){
                    System.out.println("\n------------------------------------------------------");
                }
            }
        }
    }

}
