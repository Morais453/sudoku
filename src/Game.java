import tabuleiro.Board;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        board.startingGame();

        board.printBoard();
        board.addNumber(0, 0, "5");
        board.addNumber(0, 1, "3");
        board.printBoard();
    }
}