package AplicationLayer;

import BoardLayer.Board;
import ChessLayer.ChessMatch;

public class App {
    public static void main(String[] args) throws Exception {
        Board board = new Board(8,8);
        ChessMatch match = new ChessMatch(board);
        UI.printBoard(match.getPieces());
    }
}
