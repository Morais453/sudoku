import tabuleiro.Board;
import tabuleiro.ErroNum;

import java.util.Scanner;

/**
 * Classe principal que inicializa e gerencia o jogo Sudoku.
 * Responsável por interagir com o usuário via terminal.
 */
public class Game {

    /**
     * Ponto de entrada do jogo. Controla o loop principal de interação,
     * gerencia as opções de reinício, ajuda, desistência e jogadas do jogador.
     *
     * @param args Parâmetros de linha de comando (não utilizados).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao Sudoku!");
        System.out.print("Qual o seu nome? ");
        String player = sc.nextLine();

        System.out.printf("Olá %s, tudo bem? Iremos iniciar nosso jogo!", player);
        System.out.println("""
                
                \n\nPrimeiro vamos às instruções:
                Como o jogo funciona?
                    O tabuleiro será preenchido de forma aleatória e sua função será 
                    completá-lo com números de 1 a 9, sem repeti-los 
                    na mesma linha, coluna ou bloco 3x3.
                    
                Como jogar?
                    Você deverá informar 3 valores numéricos:
                    Linha - Coluna - Valor
                    Nesta ordem. Lembrando que os valores válidos vão de 1 a 9.
                    
                Você poderá reiniciar o jogo com o mesmo tabuleiro
                (remove apenas os valores que você preencheu),
                ou gerar um novo tabuleiro.
                
                Vamos começar!
                """);

        boolean gameOver = false;
        Board board = new Board();
        board.startingGame();

        while (!gameOver) {
            board.printBoard(); // Mostra o tabuleiro a cada rodada

            System.out.println("""
                    Informe a opção desejada: 
                    1 - Continuar jogo
                    2 - Reiniciar o Jogo
                    3 - Ajuda
                    4 - Desistir do Jogo
                    """);

            String op = sc.nextLine();

            switch (op) {
                case "1" -> {
                    try {
                        System.out.println("Informe qual linha você deseja preencher (0 a 8): ");
                        int linha = sc.nextInt();
                        System.out.println("Informe qual coluna deseja preencher (0 a 8): ");
                        int coluna = sc.nextInt();
                        sc.nextLine(); // limpar buffer
                        System.out.println("Informe qual valor da linha (1 a 9): ");
                        String valor = sc.nextLine();

                        board.addNumber(linha, coluna, valor);

                    } catch (ErroNum e) {
                        // Captura e exibe mensagem de erro personalizada para valores fora do intervalo permitido
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        // Trata entradas inválidas que podem causar falhas no Scanner
                        System.out.println("Entrada inválida! Por favor, insira valores corretos.");
                        sc.nextLine(); // limpa buffer e evita loop infinito
                    }
                }
                case "2" -> {
                    System.out.println("""
                            Qual tipo de reinício?
                            1 - Mesmo tabuleiro (remove apenas os valores que você preencheu)
                            2 - Novo tabuleiro
                            """);
                    String restartOp = sc.nextLine();
                    if (restartOp.equals("1")) {
                        board.reiniciarTabuleiro();
                    } else if (restartOp.equals("2")) {
                        board.startingGame();
                    } else {
                        System.out.println("Opção inválida.");
                    }
                }
                case "3" -> {
                    board.help();
                }
                case "4" -> {
                    gameOver = true;
                    System.out.println("Você desistiu do jogo. Até a próxima!");
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
