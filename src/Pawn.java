public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "P";
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

        //can go like a PAWN
        boolean res = true;
        //white
        if (color.equals("White")) {
            if ((toLine == line + 1 || (toLine == line + 2 && line == 1))
                    && column == toColumn)
                res= true;
            else res= false;
        }

        //black
        if (color.equals("Black")) {
            if ((toLine == line - 1 || (toLine == line - 2 && line == 6))
                    && column == toColumn)
                res= true;
            else res= false;
        }
        return res;
    }
}
