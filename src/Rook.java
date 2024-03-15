public class Rook extends ChessPiece{
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) && (line == toLine && column != toColumn)) ||
                (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) && (line != toLine && column == toColumn));
    }

    @Override
    public String getSymbol() {
        return "R";}
}
