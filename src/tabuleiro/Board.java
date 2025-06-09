package tabuleiro;

import teste.ValidatorTeste;

import java.util.Arrays;
import java.util.Random;

public class Board {
    private static final String[][] board  = new String[9][9];

    /**
     * Inicia o jogo configurando o tabuleiro com o layout padrão
     * e preenchendo-o com valores aleatórios válidos.
     */
    public void startingGame(){
        popularBoard();
        String[][] defaultBoard = board;
    }

    /**
     * Preenche o tabuleiro com 4 números aleatórios distintos em cada linha,
     * garantindo que:
     * - Não haja repetição de valores na mesma linha (validação horizontal),
     * - Não haja repetição de valores na mesma coluna (validação vertical),
     * - Não haja repetição no bloco 3x3 correspondente (validação de bloco).
     *
     * Cada valor é inserido em uma posição aleatória e formatado com espaços
     * para alinhamento visual durante a impressão.
     *
     * O processo é repetido linha por linha, utilizando o validador externo
     * (Validator) para garantir as restrições do jogo.
     */
    private void popularBoard() {
        Random numericalGenerator = new Random();

        zerarTabuleiro();

        // Para cada linha, preenche até 4 posições válidas
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            int count = 0;
            while (count < 4) {
                int randomFilling = numericalGenerator.nextInt(9);
                String randomValue = String.valueOf(numericalGenerator.nextInt(10));

                boolean valid = ValidatorTeste.isValid(board, randomFilling, randomValue, rowIndex);

                if (board[rowIndex][randomFilling].isBlank() && valid) {
                    board[rowIndex][randomFilling] = "  " + randomValue + "  ";
                    count++;
                }

            }
        }

    }

    public static void zerarTabuleiro() {
        // Preenche todo o tabuleiro com espaços em branco inicialmente
        for (String[] rows : board) {
            Arrays.fill(rows, "     ");
        }
    }

    /**
     * Exibe o tabuleiro no console com divisores visuais para destacar
     * os blocos 3x3, facilitando a visualização semelhante a um Sudoku.
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
