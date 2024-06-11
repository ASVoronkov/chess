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
        if ((chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
                chessBoard.checkPos(line) && chessBoard.checkPos(column)) &&
                ((line == toLine && column != toColumn)) || (line != toLine && column == toColumn) &&
                chessBoard.board[line][column] != null)
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
        return chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
