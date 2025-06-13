import tabuleiro.Board;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();

        board.popularBoardTeste();

        System.out.println(board.testeFim());
    }
}