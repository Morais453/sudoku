import tabuleiro.Board;
import teste.BoardTest;

public class Main {
    public static void main(String[] args) {
        /*BoardTest board = new BoardTest();
        board.popularBoard();
        board.printBoard();*/

        Board boardPrincipal = new Board();
        boardPrincipal.startingGame();
        boardPrincipal.printBoard();
    }
}