package tabuleiro;

import java.util.Arrays;
import java.util.Random;

public class Board {
    private String[][] board  = new String[9][9];
    private String[][] defaultBoard;

    /**
     * Inicia o jogo preenchendo o tabuleiro com valores válidos aleatórios
     * e salva uma cópia do estado inicial para reinicialização futura.
     */
    public void startingGame(){
        popularBoard();
        defaultBoard = Arrays.stream(board)
                .map(String[]::clone)
                .toArray(String[][]::new);
        ;
    }

    /**
     * Limpa o tabuleiro preenchendo todas as posições com espaços em branco.
     * Deve ser chamada antes de qualquer nova configuração.
     */
    public void zerarTabuleiro() {
        for (String[] rows : board) {
            Arrays.fill(rows, "     ");
        }
    }

    /**
     * Restaura o tabuleiro para o estado inicial salvo no início do jogo,
     * copiando os valores da matriz {@code defaultBoard}.
     * Isso permite ao jogador recomeçar a partir do layout inicial gerado.
     */
    public void reiniciarTabuleiro() {
        board = defaultBoard;
    }

    /**
     * Preenche o tabuleiro com 4 números aleatórios distintos em cada linha.
     * Garante que:
     * <ul>
     *   <li>Não haja repetição na linha (horizontal)</li>
     *   <li>Não haja repetição na coluna (vertical)</li>
     *   <li>Não haja repetição no bloco 3x3 correspondente</li>
     * </ul>
     * Os números são validados com a classe {@link Validator}.
     * @return void - Este método não retorna nenhum valor.
     * Método privado, utilizado apenas internamente em {@link #startingGame()}.
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

                Mensagem valid = Validator.isValid(board, randomFilling, randomValue, rowIndex);

                if (board[rowIndex][randomFilling].isBlank() && valid.isValor()) {
                    board[rowIndex][randomFilling] = "  " + randomValue + "  ";
                    count++;
                }

            }
        }
    }

    /**
     * Tenta adicionar um número no tabuleiro na posição especificada,
     * desde que ele passe pelas validações de linha, coluna e bloco.
     *
     * @param row   {@code int} - Índice da linha onde o número será inserido (0 a 8).
     * @param col   {@code int} - Índice da coluna onde o número será inserido (0 a 8).
     * @param value {@code String} - Valor numérico (em string) que será inserido.
     * @return void - Este método não retorna valor, mas imprime mensagens de erro se a validação falhar.
     */
    public void addNumber(int row, int col, String value) {
        Mensagem validNumber = validateNumber(row, col, value);
        if (validNumber.isValor()) {
            board[row][col] = "  " + value + "  ";
            System.out.println(validNumber.getDescricao());
        } else {
            System.out.println(validNumber.getDescricao());

        }
    }

    /**
     * Valida se um número pode ser inserido em determinada posição do tabuleiro.
     * Assegura que o valor não viole regras de linha, coluna ou bloco.
     * @param row   {@code int} - Índice da linha a ser validada.
     * @param col   {@code int} - Índice da coluna a ser validada.
     * @param value {@code String} - Valor numérico a ser testado.
     * @return {@code Mensagem} - Enum indicando se a inserção é válida ou qual regra foi violada.
     * Método privado utilizado por {@link #addNumber(int, int, String)}.
     */
    private Mensagem validateNumber(int row, int col, String value) {
        return Validator.isValid(board, col, value, row);
    }

    /**
     * Exibe o tabuleiro no console, formatado com divisores para facilitar
     * a visualização dos blocos 3x3 do estilo Sudoku.
     * @return void - Este método apenas imprime no console e não retorna valor.
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
        System.out.println("\n\n");
    }





    public void popularBoardTeste() {
        zerarTabuleiro();
        Random numericalGenerator = new Random();
        int row = 0;
        while (row < 9) {
            int col = 0;
            while (col < 9) {
                String randomValue = String.valueOf(numericalGenerator.nextInt(10));

                Mensagem valid = Validator.isValid(board, col, randomValue, row);
                if (board[row][col].isBlank() && valid.isValor()) {
                    board[row][col] = "  " + randomValue + "  ";
                    col++;
                    printBoard();
                }
            }
            row++;
        }
    }
    public boolean testeFim() {
        return Validator.isValidEndGame(board);
    }
}
