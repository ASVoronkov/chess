public class King extends ChessPiece{
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
       if (((chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
               (line == toLine && column != toColumn)) ||
               (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
                       (line != toLine && column == toColumn))
               ||
               chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
                       (line != toLine && column != toColumn) &&
                       (Math.abs(toLine - line) == Math.abs(toColumn - column))) &&
               ((Math.abs(toColumn - column)<= 1 && (Math.abs(toLine - column) <=1))))
           return chessBoard.board[toLine][toColumn] == null ||
                   !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        return false;
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (checkPos(line) && checkPos(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }



    @Override
    public String getSymbol() {
        return "K";
    }
}
