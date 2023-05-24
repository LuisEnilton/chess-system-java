package ChessLayer;

import BoardLayer.Board;
import BoardLayer.Position;
import ChessLayer.Pieces.King;
import ChessLayer.Pieces.Rook;

public class ChessMatch {
    private int turn;
    
    private Board board;

    public ChessMatch(Board board) {
        this.board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void initialSetup(){
        board.placePiece(new Rook(board,Color.White), new Position(2,1 ));
        board.placePiece(new King(board, Color.Black), new Position(0,4));
        board.placePiece(new King(board, Color.Black), new Position(7,4));
    }

    
}
