
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
        if ((chessBoard.checkPos(line) && chessBoard.checkPos(toLine) &&
                chessBoard.checkPos(column) && chessBoard.checkPos(toColumn)) &&
                // check bord borders

                chessBoard.board[line][column] != null  &&
                // check piece

                (line != toLine && column != toColumn) &&
                // check move

                ((Math.abs(toLine - line) == 2) && (Math.abs(toColumn - column) == 1)) ||
                ((Math.abs(toLine - line) == 1) && (Math.abs(toColumn - column) == 2)))
            // logic of move
            return chessBoard.board[toLine][toColumn] == null ||
                    !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
       else return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}



