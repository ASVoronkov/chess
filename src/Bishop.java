public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        return diagonalsCanMove(chessBoard, line, column, toLine, toColumn) && canEat(chessBoard, toLine, toColumn);

    }

    @Override
    public String getSymbol() {
        return "B";
    }
}

