public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(line) && chessBoard.checkPos(column) && chessBoard.board[line][column] != null &&
                chessBoard.checkPos(toColumn)) {
            if (column == toColumn) {
                int dir;
                int start;
                if (color.equals("White")) {
                    dir = 1;
                    start = 1;
                } else {
                    dir = -1;
                    start = 6;
                }
                if (line + dir == toLine) {
                    return chessBoard.board[toLine][toColumn] == null;
                }
                if (line == start && line + 2 * dir == toLine) {
                    return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + dir][toColumn] == null;
                }
            } else {
                if ((column - toColumn == 1 || column - toColumn == -1) && (line - toColumn == 2 || line - toColumn == -1) &&
                        chessBoard.board[line][column] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                } else return false;
            }
        }
        return false;
    }


    @Override
    public String getSymbol() {
        return "P";
    }
}
