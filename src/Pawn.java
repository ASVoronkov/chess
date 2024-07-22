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

        if (this.getColor().equals("White") && chessBoard.board[toLine][toColumn] == null) {  // check color, check posToMove
                if (toLine - line == 1 || (toLine - line == 2 && line == 1)) {
                    return true;
                }
            } else if (this.getColor().equals("Black") && chessBoard.board[toLine][toColumn] == null) {  // check color, check posToMove
                if (toLine - line == -1 || (toLine - line == -2 && line == 6)) return true;
            }

            if (Math.abs(toColumn - column) == 1 && Math.abs(toLine - line) == 1) {
                return canEat(chessBoard, toLine, toColumn);
            }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}




