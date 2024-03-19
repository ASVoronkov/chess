public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
       if((chessBoard.checkPos(toLine) &&
                        (line == toLine && column != toColumn)) ||
                        (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
                                (line != toLine && column == toColumn))
                        ||
                        chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
                                (line != toLine && column != toColumn) &&
                                (Math.abs(toLine - line) == Math.abs(toColumn - column))&&
                                (!chessBoard.board[toLine][toColumn].color.equals(this.color)))
           return chessBoard.board[toLine][toColumn] == null ||
                   !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        return false;
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
