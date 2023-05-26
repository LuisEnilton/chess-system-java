package BoardLayer;
public class Board {
    
    private int rows;
    private int columns;
    private Piece[][] pieces;
    public Board(int rows, int columns) {
        if(rows < 0 || columns < 0) {
            throw new BoardException("Error creating Board: there must  be at least one row and one column");
        }
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }
    public int getRows() {
        return rows;
    }
    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if(!positionExists(row, column)) {
            throw new BoardException("Positon not in the board");
        }
        return pieces[row][column];
    } 

    public Piece piece(Position position){
        return piece(position.getRow(),position.getColumn());
    }

    public void placePiece(Piece piece , Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("There is already a piece in position: " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
    }

    private boolean positionExists(int row, int column){
        return row >= 0 && column >= 0 && row < this.rows && column < this.columns;
    }
    
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)) {
            throw new BoardException("Position not in the board");
        }
        return piece(position) != null;
    }

    public Piece removePiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Position not in the board");
        }
        if(piece(position) == null){
            return null;
        }
        Piece aux = piece(position);
        aux.setPosition(null);
        pieces[position.getRow()][position.getColumn()]= null;
        return aux;
    }
}
