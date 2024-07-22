public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        return horizontalAndVerticalCanMove(chessBoard, line, column, toLine, toColumn) &&
                canEat(chessBoard, toLine, toColumn);
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
