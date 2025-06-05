package tabuleiro;
import java.util.Arrays;

public class Board {
    private String[][] board = new String[9][9];



    public void popularBoard() {
        for (String[] strings : board) {
            Arrays.fill(strings, "    ");
        }
    }
    public void printBoard() {
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]+"|");

                if (j == 8 && (i != 2 && i != 5 && i != 8)){
                    System.out.println("\n---------------------------------------------");
                }
            }
            switch (i) {
                case 2, 5 -> {
                    System.out.println("\n=============================================");
                }
            }
        }
    }

}
