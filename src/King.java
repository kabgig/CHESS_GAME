public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }
    @Override
    public String getColor() {
        return color;
    }
    @Override
    public String getSymbol() {
        return "K";
    }

    public void getEnemyColor(){
        String enemyColor = color.equals("White") ? "Black" : "White";
    }

    @Override
    public boolean canMoveToPosition(
            ChessBoard chessBoard,
            int line, int column,
            int toLine, int toColumn) {

        //target cell is on board
        if (!(          0 <= line && line <= 7 &&
                        0 <= column && column <= 7 &&
                        0 <= toLine && toLine <= 7 &&
                        0 <= toColumn && toColumn <= 7))
            return false;

        //not go to the same position
        if (line == toLine && column == toColumn)
            return false;

        //can go like a rook
        boolean res = false;
        // going around
        if ( (toLine == line && toColumn == column + 1) ||
             (toLine == line + 1 && toColumn == column + 1) ||
             (toLine == line + 1 && toColumn == column) ||
             (toLine == line + 1 && toColumn == column - 1) ||
             (toLine == line && toColumn == column - 1) ||
             (toLine == line - 1 && toColumn == column - 1) ||
             (toLine == line - 1 && toColumn == column) ||
             (toLine == line - 1 && toColumn == column + 1)
        ) res = true;


        return res;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column){
      //  if (board.board[0][1].getColor() == this.getColor())
     //   board.board[0][1].getSymbol()

    }


}
