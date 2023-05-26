package ChessLayer;

import BoardLayer.Board;
import BoardLayer.Piece;
import BoardLayer.Position;
import ChessLayer.Pieces.King;
import ChessLayer.Pieces.Rook;
import org.jetbrains.annotations.NotNull;

public class ChessMatch {
    private int turn;

    private Board board;

    public ChessMatch(Board board) {
        this.board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }

    private void validateSourcePosition(Position source) {
        if (!board.thereIsAPiece(source)) {
            throw new ChessException("There is no piece on source position");
        }

    }

    private Piece makeMove(Position source, Position target) {
        Piece capturedPiece = board.removePiece(target);
        Piece p = board.removePiece(source);
        board.placePiece(p, target);
        return capturedPiece;
    }

    public ChessPiece performChessMove(@NotNull ChessPosition sourcePos, ChessPosition targetPos) {
        Position source = sourcePos.toPosition();
        Position target = targetPos.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);

        return (ChessPiece) capturedPiece;

    }
}
