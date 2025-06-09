package teste;

public class ValidatorTeste {

    /**
     * Verifica se um valor pode ser inserido em determinada posição do tabuleiro.
     * A validação é feita em três níveis: linha (horizontal), coluna (vertical)
     * e bloco 3x3, garantindo que o valor não esteja presente em nenhuma dessas regiões.
     *
     * @param board        O tabuleiro atual.
     * @param row         A linha onde o valor será inserido.
     * @param indexColumn  Índice da coluna onde o valor será inserido.
     * @param randomValue  O valor a ser inserido (como String).
     * @param indexRow     Índice da linha onde o valor será inserido.
     * @return {@code true} se o valor for válido em todas as direções; {@code false} caso contrário.
     */
    public static boolean isValid(String[][] board, int indexColumn, String randomValue, int indexRow) {
        boolean horizontalVertical = horizontalValidator(board, indexRow, randomValue) && verticalValidator(board, indexColumn, randomValue);

        return horizontalVertical && blockValidator(board, indexColumn, indexRow, randomValue);
    }

    /**
     * Valida se o valor não está presente na linha atual.
     * @param board        Tabuleiro
     * @param indexRow     Indice da linha atual do tabuleiro.
     * @param randomValue  Valor a ser verificado.
     * @return {@code true} se o valor não estiver presente; {@code false} caso contrário.
     */
    private static boolean horizontalValidator(String[][] board, int indexRow, String randomValue) {
        for (String string : board[indexRow]) {
            if (string.contains(randomValue)) {
                return false;
            }
        }

        return true;
    }


    /**
     * Valida se o valor não está presente na coluna atual.
     *
     * @param board        Tabuleiro completo.
     * @param indexColumn  Índice da coluna a ser verificada.
     * @param randomValue  Valor a ser verificado.
     * @return {@code true} se o valor não estiver presente; {@code false} caso contrário.
     */
    private static boolean verticalValidator(String[][] board, int indexColumn, String randomValue) {
        for (String[] strings : board) {
            if (strings[indexColumn].contains(randomValue)) {
                return false;
            }
        }

        return true;
    }


    /**
     * Valida se o valor não está presente no bloco 3x3 correspondente à posição.
     *
     * @param board        Tabuleiro completo.
     * @param indexColumn  Índice da coluna da célula-alvo.
     * @param indexRow     Índice da linha da célula-alvo.
     * @param randomValue  Valor a ser verificado.
     * @return {@code true} se o valor não estiver presente no bloco 3x3; {@code false} caso contrário.
     */
    private static boolean blockValidator(String[][] board, int indexColumn, int indexRow, String randomValue) {
        // Calcula o início do bloco 3x3
        int startRow = (indexRow / 3) * 3;
        int startCol = (indexColumn / 3) * 3;

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
