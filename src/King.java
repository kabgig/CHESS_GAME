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

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return false;
    }
}
