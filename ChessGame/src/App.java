import BoardLayer.Board;

public class App {
    public static void main(String[] args) throws Exception {
         Board board = new Board(8,8);
         System.out.println(board.getColumns());
    }
}
