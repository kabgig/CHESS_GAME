public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getSymbol() {
        return "H";
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

        //can go like a horse
        if (
            (toLine == line + 1 && toColumn == column + 2) ||
            (toLine == line + 2 && toColumn == column + 1) ||
            (toLine == line - 1 && toColumn == column + 2) ||
            (toLine == line - 2 && toColumn == column + 1) ||
            (toLine == line - 2 && toColumn == column - 1) ||
            (toLine == line - 1 && toColumn == column - 2) ||
            (toLine == line + 1 && toColumn == column - 2) ||
            (toLine == line + 2 && toColumn == column - 1)
        ) return true;
        else return false;
    }
}
