package teste;

public class ValidatorTeste {

    public static boolean isValid(String[][] board, String[] line, int randomFilling, String randomValue, int row) {
        boolean horizontalVertical = horizontalValidator(line, randomValue) && verticalValidator(board, randomFilling, randomValue);
        boolean valid = horizontalVertical && blockValidator(board, randomFilling, row, randomValue);

        return valid;
    }

    /**
     * Verifica se o valor aleatório não está presente na linha fornecida.
     *
     * @param line         A linha do tabuleiro a ser verificada.
     * @param randomValue  O valor aleatório a ser validado.
     * @return {@code true} se o valor não estiver presente na linha, {@code false} caso contrário.
     */
    public static boolean horizontalValidator(String[] line, String randomValue) {
        boolean horizontalValidation = true;

        for (String string : line) {
            if (string.contains(randomValue)) {
                horizontalValidation = false;
                break;
            }
        }

        return horizontalValidation;
    }


    /**
     * Verifica se o valor aleatório não está presente na coluna correspondente no tabuleiro.
     *
     * @param board         O tabuleiro completo.
     * @param randomFilling O índice da coluna a ser verificada.
     * @param randomValue   O valor aleatório a ser validado.
     * @return {@code true} se o valor não estiver presente na coluna, {@code false} caso contrário.
     */
    public static boolean verticalValidator(String[][] board, int randomFilling, String randomValue) {
        boolean verticalValidation = true;

        for (String[] strings : board) {
            if (strings[randomFilling].contains(randomValue)) {
                verticalValidation = false;
                break;
            }
        }

        return verticalValidation;
    }


    /**
     * Verifica se o valor aleatório não está presente no bloco 3x3 correspondente
     * à posição especificada (linha e coluna).
     *
     * @param board         O tabuleiro completo.
     * @param randomFilling O índice da coluna onde o valor será inserido.
     * @param rowIndex           O índice da linha onde o valor será inserido.
     * @param randomValue   O valor aleatório a ser validado.
     * @return {@code true} se o valor não estiver presente no bloco 3x3, {@code false} caso contrário.
     */
    public static boolean blockValidator(String[][] board, int randomFilling, int rowIndex, String randomValue) {
        // Calcula o início do bloco 3x3
        int startRow = (rowIndex / 3) * 3;
        int startCol = (randomFilling / 3) * 3;

        // Verifica o bloco 3x3 correspondente
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j].contains(randomValue)) {
                    return false;
                }
            }
        }

        return true;
    }


}
