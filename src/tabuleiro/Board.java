package tabuleiro;
import java.util.Arrays;
import java.util.Random;

public class Board {
    private final String[][] standardBoard = new String[9][9];
    private String[][] board;

    // Inicializa o jogo atribuindo o tabuleiro padrão à variável de jogo e o preenche com valores
    public void startingGame(){
        board = standardBoard;
        popularBoard();
    }

    /*
    *Função usada para "popular" o tabuleiro, preenchendo cada linha com 4 valores distintos
    * */
    private void popularBoard() {
        Random numericalGenerator = new Random();
        for (String[] strings : board) {

            Arrays.fill(strings, "     ");
            int count = 0;

            while (count < 4) {
                int randomFilling = numericalGenerator.nextInt(9);
                String randomValue = String.valueOf(numericalGenerator.nextInt(10));

                boolean horizontalValidator = true;

                for (String string : strings) {
                    if (string.contains(randomValue)) {
                        horizontalValidator = false;
                        break;
                    }
                }
                if (strings[randomFilling].isBlank() && horizontalValidator) {
                    strings[randomFilling] = "  " + randomValue + "  ";
                    count++;
                }

            }

        }
    }

    // Imprime o tabuleiro no console com divisões visuais entre os blocos 3x3
    public void printBoard() {
        for (int l = 0; l < 9; l++) {

            for (int c = 0; c < 9; c++) {
                System.out.print(board[l][c]+"|");

                if (c == 8 && (l != 2 && l != 5 && l != 8)){
                    System.out.println("\n------------------------------------------------------");
                }
            }
            switch (l) {
                case 2, 5 -> {
                    System.out.println("\n======================================================");
                }
            }
        }
    }

}
