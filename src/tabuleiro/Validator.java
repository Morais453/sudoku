package tabuleiro;

public class Validator {

    /**
     * Verifica se um valor pode ser inserido em uma posição específica do tabuleiro.
     * A validação considera três critérios:
     * - O valor não pode estar repetido na linha (validação horizontal),
     * - O valor não pode estar repetido na coluna (validação vertical),
     * - O valor não pode estar presente no bloco 3x3 correspondente.
     *
     * @param board        O tabuleiro atual.
     * @param indexColumn  Índice da coluna onde o valor será inserido.
     * @param randomValue  Valor numérico (como string) a ser inserido.
     * @param indexRow     Índice da linha onde o valor será inserido.
     * @return {@code true} se o valor for válido em todas as validações; {@code false} caso contrário.
     */
    public static boolean isValid(String[][] board, int indexColumn, String randomValue, int indexRow) {
        boolean horizontalVertical = horizontalValidator(board, indexRow, randomValue) && verticalValidator(board, indexColumn, randomValue);

        return horizontalVertical && blockValidator(board, indexColumn, indexRow, randomValue);
    }

    /**
     * Verifica se o valor já está presente na linha especificada do tabuleiro.
     *
     * @param board        Tabuleiro completo.
     * @param indexRow     Índice da linha a ser verificada.
     * @param randomValue  Valor a ser validado.
     * @return {@code true} se o valor não estiver presente na linha; {@code false} caso contrário.
     */
    private static boolean horizontalValidator(String[][] board, int indexRow, String randomValue) {
        for (String item : board[indexRow]) {
            if (item.contains(randomValue)) {
                return false;
            }
        }

        return true;
    }


    /**
     * Verifica se o valor já está presente na coluna especificada do tabuleiro.
     *
     * @param board        Tabuleiro completo.
     * @param indexColumn  Índice da coluna a ser verificada.
     * @param randomValue  Valor a ser validado.
     * @return {@code true} se o valor não estiver presente na coluna; {@code false} caso contrário.
     */
    private static boolean verticalValidator(String[][] board, int indexColumn, String randomValue) {
        for (String[] rows : board) {
            if (rows[indexColumn].contains(randomValue)) {
                return false;
            }
        }

        return true;
    }


    /**
     * Verifica se o valor já está presente no bloco 3x3 correspondente à posição indicada.
     *
     * @param board        Tabuleiro completo.
     * @param indexColumn  Índice da coluna da célula onde o valor será inserido.
     * @param indexRow     Índice da linha da célula onde o valor será inserido.
     * @param randomValue  Valor a ser validado.
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
