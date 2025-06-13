package tabuleiro;

import java.util.HashSet;
import java.util.Set;

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
     * @return {@code Mensagem} - Enum informando se a inserção foi válida ou indicando qual validação falhou.
     */
    public static Mensagem isValid(String[][] board, int indexColumn, String randomValue, int indexRow) {

        if (!horizontalValidator(board, indexRow, randomValue)) {
            return Mensagem.HorizontalFalse;
        } if (!verticalValidator(board, indexColumn, randomValue)) {
            return Mensagem.VerticalFalse;
        } if (!blockValidator(board, indexColumn, indexRow, randomValue)) {
            return Mensagem.BlocoFalse;
        } else {
            return Mensagem.ValidationTrue;
        }
        

    }

    /**
     * Verifica se o valor está repetido na linha indicada do tabuleiro.
     *
     * @param board       {@code String[][]} - Tabuleiro do jogo.
     * @param indexRow    {@code int} - Índice da linha a ser validada.
     * @param randomValue {@code String} - Valor a ser inserido.
     * @return {@code boolean} - {@code true} se o valor não existir na linha; {@code false} caso contrário.
     * Método auxiliar usado por: {@link #isValid(String[][], int, String, int)}
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
     * Verifica se o valor está repetido na coluna indicada do tabuleiro.
     *
     * @param board       {@code String[][]} - Tabuleiro do jogo.
     * @param indexColumn {@code int} - Índice da coluna a ser validada.
     * @param randomValue {@code String} - Valor a ser inserido.
     * @return {@code boolean} - {@code true} se o valor não existir na coluna; {@code false} caso contrário.
     * Método auxiliar usado por: {@link #isValid(String[][], int, String, int)}
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
     * Método auxiliar usado por: {@link #isValid(String[][], int, String, int)}
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

    /**
     * Verifica se o jogo foi finalizado corretamente, ou seja,
     * se toda a regra de preenchimento está a ser seguida.
     * Combina validações horizontais, verticais e de blocos.
     * @param board {@code String[][]} - Tabuleiro completo preenchido.
     * @return {@code boolean} - Retorna {@code true} se o tabuleiro estiver correto; caso contrário, {@code false}.
     */
    public static boolean isValidEndGame(String[][] board){
        return (horizontalValidatorFinal(board) && verticalValidatorFinal(board)) && blockValidatorFinal(board);
    }

    /**
     * Verifica se há duplicatas em alguma linha do tabuleiro.
     * @param board {@code String[][]} - Tabuleiro completo preenchido.
     * @return {@code boolean} - Retorna {@code true} se todas as linhas tiverem apenas valores únicos; caso contrário, {@code false}.
     * Método auxiliar usado por {@link #isValidEndGame(String[][])}.
     */
    private static boolean horizontalValidatorFinal(String[][] board) {

        for (String[] rows : board){
            Set<String> set = new HashSet<>();
            for (String valor : rows) {
                if (!set.add(valor)) {
                    return false;
                }
            }

        }
        return true; // se não tiver valor duplicado na linha
    }

    /**
     * Verifica se há duplicatas em alguma coluna do tabuleiro.
     * @param board {@code String[][]} - Tabuleiro completo preenchido.
     * @return {@code boolean} - Retorna {@code true} se todas as colunas tiverem apenas valores únicos; caso contrário, {@code false}.
     * Método auxiliar usado por {@link #isValidEndGame(String[][])}.
     */
    private static boolean verticalValidatorFinal(String[][] board) {
        for (int column = 0; column < 9; column++) {
            Set<String> set = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                String value = board[row][column];
                if (!value.isEmpty() && !set.add(value)) {
                    return false; // Duplicata na coluna `coluna`
                }
            }
        }
        return true; // Nenhuma duplicata em nenhuma coluna
    }

    /**
     * Verifica se há duplicatas em algum dos blocos 3x3 do tabuleiro.
     * @param board {@code String[][]} - Tabuleiro completo preenchido.
     * @return {@code boolean} - Retorna {@code true} se todos os blocos 3x3 tiverem apenas valores únicos; caso contrário, {@code false}.
     * Método auxiliar usado por {@link #isValidEndGame(String[][])}.
     */
    private static boolean blockValidatorFinal(String[][] board) {
        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {
                Set<String> set = new HashSet<>();
                // Verifica o bloco 3x3 correspondente
                for (int i = startRow; i < startRow + 3; i++) {
                    for (int j = startCol; j < startCol + 3; j++) {
                        String value = board[i][j];
                        if (!value.isEmpty() && !set.add(value)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
