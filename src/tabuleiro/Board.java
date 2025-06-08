package tabuleiro;
import teste.ValidatorTeste;

import java.util.Arrays;
import java.util.Random;

public class Board {
    private final String[][] standardBoard = new String[9][9];
    private String[][] board;

    /**
     * Inicializa o jogo atribuindo o tabuleiro padrão à variável de jogo
     * e preenche o tabuleiro com valores aleatórios.
     */
    public void startingGame(){
        board = standardBoard;
        popularBoard();
    }

    /**
     * Popula o tabuleiro preenchendo cada linha com 4 valores numéricos distintos.
     * Garante que os valores não se repitam na mesma linha (horizontal) nem na mesma coluna (vertical),
     * utilizando validadores externos.
     */
    private void popularBoard() {
        Random numericalGenerator = new Random();
        int count = 0;
        int row = 0;
        for (String[] strings : board) {
            Arrays.fill(strings, "     ");

        }
        for (String[] strings : board) {
            while (count < 4) {
                int randomFilling = numericalGenerator.nextInt(9);
                String randomValue = String.valueOf(numericalGenerator.nextInt(10));

                boolean valid = Validator.isValid(board, strings, randomFilling, randomValue, row);

                if (strings[randomFilling].isBlank() && valid) {
                    strings[randomFilling] = "  " + randomValue + "  ";
                    count++;
                }

            }
            row++;
        }

    }

    /**
     * Imprime o tabuleiro no console, com divisões visuais entre os blocos 3x3
     * para facilitar a leitura da estrutura do jogo.
     */
    public void printBoard() {
        for (int l = 0; l < 9; l++) {

            for (int c = 0; c < 9; c++) {
                System.out.print(board[l][c]+"|");

                if (c == 8 && (l != 2 && l != 5 && l != 8)){
                    System.out.println("\n------------------------------------------------------");
                }
            }
            switch (l) {
                case 2, 5 -> System.out.println("\n======================================================");
            }
        }
    }

}
