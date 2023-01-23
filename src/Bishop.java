public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMoveToPosition(
            ChessBoard chessBoard,
            int line, int column,
            int toLine, int toColumn) {

        //target is on board
        if (!(
                0 <= line && line <= 7 &&
                        0 <= column && column <= 7 &&
                        0 <= toLine && toLine <= 7 &&
                        0 <= toColumn && toColumn <= 7))
            return false;

        //not go to the same position
        if (line == toLine && column == toColumn)
            return false;

        //can go like a bishop
        boolean res = false;
        boolean notOurs = chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].getColor().equals(color);
        // right up
        if(!res){
        int i = line + 1, j = column + 1;
        while (i < 8 && j < 8) {
            if (i == toLine && j == toColumn) {
                if (notOurs) res = true;
                break;}
            if (chessBoard.board[i][j] != null) break; //nothing is on the way
            i++; j++;
        }}

        // left up
        if(!res){
            int i = line - 1, j = column + 1;
            while (i >= 0 && j < 8) {
                if (i == toLine && j == toColumn) {
                    if (notOurs) res = true;
                    break;}
                if (chessBoard.board[i][j] != null) break; //nothing is on the way
                i--; j++;
            }
        }

        // left down
        if(!res){
            int i = line - 1, j = column - 1;
            while (i >= 0 && j >= 0) {
                if (i == toLine && j == toColumn) {
                    if (notOurs) res = true;
                    break;}
                if (chessBoard.board[i][j] != null) break; //nothing is on the way
                i--; j--;
            }
        }

        // right down
        if(!res){
            int i = line + 1, j = column - 1;
            while (i < 8 && j >= 0) {
                if (i == toLine && j == toColumn) {
                    if (notOurs) res = true;
                    break;}
                if (chessBoard.board[i][j] != null) break; //nothing is on the way
                i++; j--;
            }
        }

        return res;
    }
}
