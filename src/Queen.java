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

        //can go like a rook
        boolean res = false;

        //STRAIGHTS
        //can go straight up
        if(!res){
        int i = line, j = column + 1;
        while (j < 8) {
            if (i == toLine && j == toColumn) {
                res = true;
                break;
            }
            j++;
        }}
        //can go straight down
        if(!res){
        int a = line, b = column - 1;
        while (b >= 0) {
            if (a == toLine && b == toColumn) {
                res = true;
                break;
            }
            b--;
        }}
        //can go straight right
        if(!res){
        int c = line + 1, d = column;
        while (c < 8) {
            if (c == toLine && d == toColumn) {
                res = true;
                break;
            }
            c++;
        }}
        //can go straight left
        if(!res){
        int e = line - 1, f = column;
        while (e >= 0) {
            if (e == toLine && f == toColumn) {
                res = true;
                break;
            }
            e--;
        }}

        //DIAGONALS
        // right up diagonal
        if(!res){
        int g = line + 1, h = column + 1;
        while (g < 8 && h < 8) {
            if (g == toLine && h == toColumn) {
                res = true;
                break;}
            g++; h++;
        }}
        // left up diagonal
        if(!res){
            int k = line - 1, l = column + 1;
            while (k >= 0 && l < 8) {
                if (k == toLine && l == toColumn) {
                    res = true;
                    break;}
                k--; l++;
            }
        }
        // left down diagonal
        if(!res){
            int m = line - 1, n = column - 1;
            while (m >= 0 && n >= 0) {
                if (m == toLine && n == toColumn) {
                    res = true;
                    break;}
                m--; n--;
            }
        }
        // right down diagonal
        if(!res){
            int p = line + 1, q = column - 1;
            while (p < 8 && q >= 0) {
                if (p == toLine && q == toColumn) {
                    res = true;
                    break;}
                p++; q--;
            }
        }
        return res;
    }
}
