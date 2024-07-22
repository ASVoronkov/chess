public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (Math.abs(toLine - line) <= 1 && Math.abs(column - toColumn) <= 1) {
            return canEat(chessBoard, toLine, toColumn);
        }
        return false;
    }



    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(chessBoard.board[i][j] != null && !chessBoard.board[i][j].getColor().equals(this.color)){
                    if (chessBoard.board[i][j].canMoveToPosition(chessBoard,line,column,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
