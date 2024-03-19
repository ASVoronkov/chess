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
        if ((chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) && chessBoard.checkPos(line) && chessBoard.checkPos(column))&&
                ((line == toLine && column != toColumn)) || (line != toLine && column == toColumn))
            return chessBoard.board[toLine][toColumn] == null ||
                    !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";}
}
