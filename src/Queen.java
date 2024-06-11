public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(line) && chessBoard.checkPos(toLine) &&
                chessBoard.checkPos(column) && chessBoard.checkPos(toColumn) &&
                // check board borders

                chessBoard.board[line][column] != null &&
                chessBoard.board[line][column].color.equals(this.color))
        // check piece
        {
            if ((line != toLine && column != toColumn) && (Math.abs(toLine - line) == Math.abs(toColumn - column))
                    //check diagonals
                    ||
                    ((line == toLine && column != toColumn)) || (line != toLine && column == toColumn)) {
                //check horizontals and verticals

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

