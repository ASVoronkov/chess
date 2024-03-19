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
                chessBoard.board[line][column] != null && line !=toLine) { // check board and piece
            if (column == toColumn) {
                if (Math.abs(toLine - line) == 1) {
                    return chessBoard.board[toLine][toColumn] == null;
                } else if (Math.abs(toLine - line) == 2) {
                    if (line == 1 && chessBoard.board[line][column].color.equals("White")) {
                        return chessBoard.board[2][column] == null && chessBoard.board[3][column] == null;
                    } else if (line == 6 && chessBoard.board[line][column].color.equals("Black")) {
                        return chessBoard.board[5][column] == null && chessBoard.board[4][column] == null; //
                    }
                }
            }
            else if(Math.abs(toColumn - column) == 1){   //can eat
                if(!chessBoard.board[line][column].color.equals(chessBoard.board[toLine][toColumn].color))
                {return Math.abs(toLine - line) == 1;}
            } else return false;
        }
        return false;
    }
    @Override
    public String getSymbol() {
        return "P";
    }
}

