
public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
         if (chessBoard.checkPos(line) && chessBoard.checkPos(column) && chessBoard.checkPos(toLine) &&
                chessBoard.checkPos(toColumn)) {
            if (line != toLine && column != toColumn &&
                    (chessBoard.board[toLine][toColumn] == null ||
                            chessBoard.board[toLine][toColumn].color.equals(this.color))
                    && chessBoard.board[line][column] != null) {
                if (!chessBoard.board[line][column].equals(this)) {
                    return true;
                }


                int[][] positions = new int[][]{
                        {-2, -1}, {-2, +1},
                        {+2, -1}, {+2, +1},
                        {-1, -2}, {-1, +2},
                        {+1, -2}, {+1, +2},
                };
                for (int i = 0; i < positions.length; i++) {
                    if (positions[i][0] == toLine && positions[i][1] == toColumn) {
                        return true;
                    }
                }
            }
        } else return false;
        return true;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}



