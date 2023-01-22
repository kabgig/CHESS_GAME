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
        // right up
        if(!res){
        int i = line + 1, j = column + 1;
        while (i < 8 && j < 8) {
            if (i == toLine && j == toColumn) {
                res = true;
                break;}
            i++; j++;
        }}

        // left up
        if(!res){
            int a = line - 1, b = column + 1;
            while (a >= 0 && b < 8) {
                if (a == toLine && b == toColumn) {
                    res = true;
                    break;}
                a--; b++;
            }
        }

        // left down
        if(!res){
            int c = line - 1, d = column - 1;
            while (c >= 0 && d >= 0) {
                if (c == toLine && d == toColumn) {
                    res = true;
                    break;}
                c--; d--;
            }
        }

        // right down
        if(!res){
            int e = line + 1, g = column - 1;
            while (e < 8 && g >= 0) {
                if (e == toLine && g == toColumn) {
                    res = true;
                    break;}
                e++; g--;
            }
        }

        return res;
    }
}
