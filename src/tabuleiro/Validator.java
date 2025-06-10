package tabuleiro;

public class Validator {

    /**
     * Verifica se um valor pode ser inserido numa posição específica do tabuleiro.
     * A validação considera três critérios:
     * <ul>
     *     <li>O valor não pode estar repetido na linha (validação horizontal)</li>
     *     <li>O valor não pode estar repetido na coluna (validação vertical)</li>
     *     <li>O valor não pode estar presente no bloco 3x3 correspondente</li>
     * </ul>
     *
     * @param board        O tabuleiro atual.
     * @param indexColumn  Índice da coluna onde o valor será inserido.
     * @param randomValue  Valor numérico (como "String") a ser inserido.
     * @param indexRow     Índice da linha onde o valor será inserido.
     * @return {@code true} se o valor for válido em todas as validações; {@code false} caso contrário.
     */
    public static boolean isValid(String[][] board, int indexColumn, String randomValue, int indexRow) {
        boolean horizontal = horizontalValidator(board, indexRow, randomValue);

        boolean Vertical = verticalValidator(board, indexColumn, randomValue);

        boolean block = blockValidator(board, indexColumn, indexRow, randomValue);
        
        return 
    }

    /**
     * Verifica se o valor já está presente na linha especificada do tabuleiro.
     *
     * @param board        O tabuleiro completo.
     * @param indexRow     O índice da linha a ser verificada.
     * @param randomValue  O valor a ser validado.
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
     * @param board        O tabuleiro completo.
     * @param indexColumn  O índice da coluna a ser verificada.
     * @param randomValue  O valor a ser validado.
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
     * O bloco é determinado com base na linha e coluna fornecidas.
     *
     * @param board        O tabuleiro completo.
     * @param indexColumn  O índice da coluna da célula onde o valor será inserido.
     * @param indexRow     O índice da linha da célula onde o valor será inserido.
     * @param randomValue  O valor a ser validado.
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
