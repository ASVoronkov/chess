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
       return //первая проверка это ход по вертикали и диагонали
               ((chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
                (line == toLine && column != toColumn)) ||
                (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
                        (line != toLine && column == toColumn))
                ||
                // проверка диагонали
                chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) &&
                        (line != toLine && column != toColumn) &&
                        (Math.abs(toLine - line) == Math.abs(toColumn - column))) &&
               // проверка, что на одно поле не более
                       ((Math.abs(toColumn - column)<= 1 && (Math.abs(toLine - column) <=1)));

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
