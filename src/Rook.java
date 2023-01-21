public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "R";
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

        //can go like a rook
        boolean res = false;

        //can go straight up
        int i = line, j = column + 1;
        while (j < 8) {
            if (i == toLine && j == toColumn) {
                res = true;
                break;
            }
            j++;
        }
        //can go straight down
        int a = line, b = column - 1;
        while (b >= 0) {
            if (a == toLine && b == toColumn) {
                res = true;
                break;
            }
            b--;
        }
        //can go straight right
        int c = line + 1, d = column;
        while (c < 8) {
            if (c == toLine && d == toColumn) {
                res = true;
                break;
            }
            c++;
        }
        //can go straight left
        int e = line - 1, f = column;
        while (e >= 0) {
            if (e == toLine && f == toColumn) {
                res = true;
                break;
            }
            e--;
        }
        return res;
    }
}
