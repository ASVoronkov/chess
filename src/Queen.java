public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
            return canEat(chessBoard, toLine, toColumn) &&
                    (horizontalAndVerticalCanMove(chessBoard, line, column, toLine, toColumn)||
                    diagonalsCanMove(chessBoard, line, column, toLine, toColumn));
    }



    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }


}

