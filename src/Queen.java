public class Queen extends ChessPiece{

    public Queen(String color) {
        super(color);
    }
    @Override
    public String getColor() {
        return color;
    }
    @Override
    public String getSymbol() {
        return "Q";
    }

    @Override
    public boolean canMoveToPosition(
            ChessBoard chessBoard,
            int line, int column,
            int toLine, int toColumn) {

        //target cell is on board
        if (!(
                0 <= line && line <= 7 &&
                        0 <= column && column <= 7 &&
                        0 <= toLine && toLine <= 7 &&
                        0 <= toColumn && toColumn <= 7))
            return false;

        //not go to the same position
        if (line == toLine && column == toColumn)
            return false;

        //can go like a QUEEN
        boolean res = false;
        boolean isEnemyColor = chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].getColor().equals(color);
        //STRAIGHTS
        //can go straight up
        if(!res){
        int i = line, j = column + 1;
        while (j < 8) {
            if (i == toLine && j == toColumn) {
                if (isEnemyColor) res = true;
                break;
            }
            if (chessBoard.board[i][j] != null) break; //nothing is on the way
            j++;
        }}
        //can go straight down
        if(!res){
        int i = line, j = column - 1;
        while (j >= 0) {
            if (i == toLine && j == toColumn) {
                if (isEnemyColor) res = true;
                break;
            }
            if (chessBoard.board[i][j] != null) break; //nothing is on the way
            j--;
        }}
        //can go straight right
        if(!res){
        int i = line + 1, j = column;
        while (i < 8) {
            if (i == toLine && j == toColumn) {
                if (isEnemyColor) res = true;
                break;
            }
            if (chessBoard.board[i][j] != null) break; //nothing is on the way
            i++;
        }}
        //can go straight left
        if(!res){
        int i = line - 1, j = column;
        while (i >= 0) {
            if (i == toLine && j == toColumn) {
                if (isEnemyColor) res = true;
                break;
            }
            if (chessBoard.board[i][j] != null) break; //nothing is on the way
            i--;
        }}

        //DIAGONALS
        // right up diagonal
        if(!res){
        int i = line + 1, j = column + 1;
        while (i < 8 && j < 8) {
            if (i == toLine && j == toColumn) {
                if (isEnemyColor) res = true;
                break;}
            if (chessBoard.board[i][j] != null) break; //nothing is on the way
            i++; j++;
        }}
        // left up diagonal
        if(!res){
            int i = line - 1, j = column + 1;
            while (i >= 0 && j < 8) {
                if (i == toLine && j == toColumn) {
                    if (isEnemyColor) res = true;
                    break;}
                if (chessBoard.board[i][j] != null) break; //nothing is on the way
                i--; j++;
            }
        }
        // left down diagonal
        if(!res){
            int i = line - 1, j = column - 1;
            while (i >= 0 && j >= 0) {
                if (i == toLine && j == toColumn) {
                    if (isEnemyColor) res = true;
                    break;}
                if (chessBoard.board[i][j] != null) break; //nothing is on the way
                i--; j--;
            }
        }
        // right down diagonal
        if(!res){
            int i = line + 1, j = column - 1;
            while (i < 8 && j >= 0) {
                if (i == toLine && j == toColumn) {
                    if (isEnemyColor) res = true;
                    break;}
                if (chessBoard.board[i][j] != null) break; //nothing is on the way
                i++; j--;
            }
        }
        return res;
    }
}
