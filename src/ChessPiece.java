public abstract class ChessPiece {
    public String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    public boolean canEat(ChessBoard chessBoard, int toLine, int toColumn) {
        return chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
    }

    public boolean horizontalAndVerticalCanMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (column == toColumn) if (line > toLine) for (int i = line - 1; i > toLine; i--) {
            if (chessBoard.board[i][column] != null) return false;
        }
        if (toLine > line) for (int i = toLine - 1; i > line; i--) {
            if (chessBoard.board[i][column] != null) return false;
        }
        if (line == toLine) if (column > toColumn) for (int i = column - 1; i > toColumn; i--) {
            if (chessBoard.board[line][i] != null) return false;
        }
        if (toColumn > column) for (int i = toColumn - 1; i > column; i--) {
            if (chessBoard.board[line][i] != null) return false;
        }
        return true;
    }

    public boolean diagonalsCanMove(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((Math.abs(toLine - line) == Math.abs(toColumn - column))) // check diagonals
        {
            if (line < toLine && column < toColumn) { // right and up
                int j = toColumn;
                for (int i = toLine - 1; i > line; i--) {
                    j--;
                    if (chessBoard.board[i][j] != null) return false;
                }


            }
            if (line > toLine && column < toColumn) {// right and down
                int j = toColumn;
                for (int i = toLine + 1; i < line; i++) {
                    j--;

                    if (chessBoard.board[i][j] != null) return false;
                }
            }


            if (line < toLine && column > toColumn) { // left and up
                int j = toColumn;
                for (int i = toLine - 1; i > line; i--) {
                    j++;
                    if (chessBoard.board[i][j] != null) return false;

                }
            }
            if (line > toLine && column > toColumn) { // left and down
                int j = toColumn;
                for (int i = toLine + 1; i < line; i++) {
                    j++;
                    if (chessBoard.board[i][j] != null) return false;
                }

            }

        }
        return true;
    }
}

