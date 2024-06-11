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

        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
                chessBoard.checkPos(line) && chessBoard.checkPos(column) && // check board
                chessBoard.board[line][column] != null && (line != toLine &&
                column != toColumn) && (Math.abs(toLine - line) == Math.abs(toColumn - column))) {

            if (toLine > line && toColumn > column) {
                int j = column;// lef and up
                for (int i = toLine - 1; i > line; i--) {
                    j += 1;
                    if (chessBoard.board[i][j] != null) return false;
                }
            }
            if (line > toLine && column > toColumn) {
                int j = column;// left and down
                for (int i = line - 1; i > toLine; i--) {
                    j -= 1;
                    if (chessBoard.board[i][j] != null) return false;
                }

            }
            if (line > toLine && toColumn > column) {
                int j = column;//right and down
                for (int i = line - 1; i > toLine; i--) {
                    j += 1;
                    if (chessBoard.board[i][j] != null) return false;
                }
            }
            if (toLine > line && column > toColumn) {
                int j = column;// right and up
                for (int i = toLine - 1; i > line; i--) {
                    j -= 1;
                    if (chessBoard.board[i][j] != null) return false;
                }
            }

            return chessBoard.board[toLine][toColumn] == null ||
                    !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}

