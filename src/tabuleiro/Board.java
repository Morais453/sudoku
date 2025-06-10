package tabuleiro;

import java.util.Arrays;
import java.util.Random;

public class Board {
    private String[][] board  = new String[9][9];
    private String[][] defaultBoard;

    /**
     * Inicia o jogo configurando o tabuleiro com o layout padrão
     * e preenchendo-o com valores aleatórios válidos.
     */
    public void startingGame(){
        popularBoard();
        defaultBoard = Arrays.stream(board)
                .map(String[]::clone)
                .toArray(String[][]::new);
        ;
    }

    /**
     * Preenche todo o tabuleiro com espaços em branco,
     * reiniciando o estado para uma matriz vazia (sem números).
     * Usado antes de iniciar ou reiniciar o preenchimento.
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
     * Preenche o tabuleiro com 4 números aleatórios distintos em cada linha,
     * garantindo que:
     * - Não haja repetição de valores na mesma linha (validação horizontal),
     * - Não haja repetição de valores na mesma coluna (validação vertical),
     * - Não haja repetição no bloco 3x3 correspondente (validação de bloco).
     * Cada valor é inserido numa posição aleatória e formatado com espaços
     * para alinhamento visual durante a impressão.
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

                boolean valid = Validator.isValid(board, randomFilling, randomValue, rowIndex);

                if (board[rowIndex][randomFilling].isBlank() && valid) {
                    board[rowIndex][randomFilling] = "  " + randomValue + "  ";
                    count++;
                }

            }
        }

    }

    /**
     * Tenta adicionar um número no tabuleiro na posição especificada,
     * desde que seja válido segundo as regras do jogo.
     *
     * @param row   Índice da linha onde o número será inserido.
     * @param col   Índice da coluna onde o número será inserido.
     * @param value Valor numérico (como 'string') a ser inserido.
     * @return {@code true} se o número foi inserido com sucesso; {@code false} caso contrário.
     */
    public boolean addNumber(int row, int col, String value) {
        if (validateNumber(row, col, value)) {
            board[row][col] = "  " + value + "  ";
            return true;
        } else {
            System.out.println("Número inválido ou posição já preenchida. Tente novamente!");
    
            return false;
        }
    }

    /**
     * Valida se um número pode ser inserido na posição informada do tabuleiro,
     * verificando as regras de linha, coluna e bloco 3x3.
     *
     * @param row   Índice da linha da célula a ser validada.
     * @param col   Índice da coluna da célula a ser validada.
     * @param value Valor numérico (como 'string') a ser testado.
     * @return {@code true} se o valor for válido na posição; {@code false} caso contrário.
     */
    private boolean validateNumber(int row, int col, String value) {
        return Validator.isValid(board, col, value, row);
    }

    /**
     * Exibe o tabuleiro no console com divisores visuais para destacar
     * os blocos 3x3, facilitando a visualização.
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
}
