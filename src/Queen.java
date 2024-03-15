public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return   // проверка вертикали и диагонали
                (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
                        (line == toLine && column != toColumn)) ||
                        (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
                                (line != toLine && column == toColumn))
                        ||
                        // проверка диагонали
                        chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
                                (line != toLine && column != toColumn) &&
                                (Math.abs(toLine - line) == Math.abs(toColumn - column));
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
