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
        if (chessBoard.checkPos(line) && chessBoard.checkPos(toLine) &&
                chessBoard.checkPos(column) && chessBoard.checkPos(toColumn) &&
                // check board borders
                chessBoard.board[line][column] != null && line != toLine) // check move
        {
            if (column == toColumn) {
                if (Math.abs(toLine - line) == 1) {
                    return chessBoard.board[toLine][toColumn] == null; // one square move front

                } else if (Math.abs(toLine - line) == 2) {
                    if (line == 1 && chessBoard.board[line][column].color.equals("White")) {
                        return chessBoard.board[2][column] == null && chessBoard.board[3][column] == null; // two square move for white

                    } else if (line == 6 && chessBoard.board[line][column].color.equals("Black")) {
                        return chessBoard.board[5][column] == null && chessBoard.board[4][column] == null; // two square move for black
                    }
                }
            } else if (Math.abs(toColumn - column) == 1 && Math.abs(toLine - line) == 1) {   //can eat
                return  !chessBoard.board[line][column].color.equals(chessBoard.board[toLine][toColumn].getColor());
                }
            }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }




}

