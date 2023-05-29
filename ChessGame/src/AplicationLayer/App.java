package AplicationLayer;

import BoardLayer.Board;
import ChessLayer.ChessException;
import ChessLayer.ChessMatch;
import ChessLayer.ChessPiece;
import ChessLayer.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Board board = new Board(8,8);
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch(board);
        while(true){
            try {

            UI.clearScreen();
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.println("Source:");
            ChessPosition source = UI.readChessPosition(sc);
            System.out.println();
            System.out.println("Target:");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturePiece = chessMatch.performChessMove(source,target);
            System.out.println(capturePiece);
            }catch (ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
