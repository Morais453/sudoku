import tabuleiro.Board;
import teste.BoardTest;

public class Game {
    public static void main(String[] args) {
        Board tab = new Board();
        tab.startingGame();
        tab.printBoard();

        /*BoardTest boardTest = new BoardTest();
        boardTest.startingGame();
        boardTest.printBoard();*/

    }
}