public class King extends ChessPiece {

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

    public String getEnemyColor() {
        return color.equals("White") ? "Black" : "White";
    }

    @Override
    public boolean canMoveToPosition(
            ChessBoard chessBoard,
            int line, int column,
            int toLine, int toColumn) {

        //target cell is on board
        if (!(0 <= line && line <= 7 &&
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
        if ((toLine == line && toColumn == column + 1) ||
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

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        boolean res = false;
        //  if (board.board[0][1].getColor() == this.getColor())
        //   board.board[0][1].getSymbol()

        //CHECK ENEMY ROOK AND QUEEN STRAIGHT UP/DOWN
        if (!res) {
            int i = line, j = 0;
            while (j < 8) {
                if (board.board[i][j] != null && board.board[i][j].getColor().equals(getEnemyColor()) &&
                        (board.board[i][j].getSymbol().equals("R") ||
                                board.board[i][j].getSymbol().equals("Q"))) {
                    res = true;
                    break;
                }
                j++;
            }
        }
        //CHECK ENEMY ROOK AND QUEEN STRAIGHT LEFT/RIGHT
        if (!res) {
            int i = 0, j = column;
            while (i < 8) {
                if (board.board[i][j] != null && board.board[i][j].getColor().equals(getEnemyColor()) &&
                        (board.board[i][j].getSymbol().equals("R") ||
                                board.board[i][j].getSymbol().equals("Q"))) {
                    res = true;
                    break;
                }
                i++;
            }
        }
        //CHECK ENEMY BISHOP AND QUEEN DIAGONAL RIGHT UP
        if (!res) {
            int g = line + 1, h = column + 1;
            while (g < 8 && h < 8) {
                if (board.board[g][h] != null && board.board[g][h].getColor().equals(getEnemyColor()) &&
                        (board.board[g][h].getSymbol().equals("B") ||
                                board.board[g][h].getSymbol().equals("Q"))) {
                    res = true;
                    break;
                }
                g++;
                h++;
            }
        }
        //CHECK ENEMY BISHOP AND QUEEN DIAGONAL LEFT UP
        if (!res) {
            int a = line - 1, b = column + 1;
            while (a >= 0 && b < 8) {
                if (board.board[a][b] != null && board.board[a][b].getColor().equals(getEnemyColor()) &&
                        (board.board[a][b].getSymbol().equals("B") ||
                                board.board[a][b].getSymbol().equals("Q"))) {
                    res = true;
                    break;
                }
                a--;
                b++;
            }
        }
        //CHECK ENEMY BISHOP AND QUEEN DIAGONAL LEFT DOWN
        if (!res) {
            int a = line - 1, b = column - 1;
            while (a >= 0 && b >= 0) {
                if (board.board[a][b] != null && board.board[a][b].getColor().equals(getEnemyColor()) &&
                        (board.board[a][b].getSymbol().equals("B") ||
                                board.board[a][b].getSymbol().equals("Q"))) {
                    res = true;
                    break;
                }
                a--;
                b--;
            }
        }
        //CHECK ENEMY BISHOP AND QUEEN DIAGONAL RIGHT DOWN
        if (!res) {
            int a = line + 1, b = column - 1;
            while (a < 8 && b >= 0) {
                if (board.board[a][b] != null && board.board[a][b].getColor().equals(getEnemyColor()) &&
                        (board.board[a][b].getSymbol().equals("B") ||
                                board.board[a][b].getSymbol().equals("Q"))) {
                    res = true;
                    break;
                }
                a++;
                b--;
            }
        }
        //HORSE CHECK-------------
        if (!res) {
            if (
                    (board.checkPos(line + 1) && board.checkPos(column + 2) &&
                            board.board[line + 1][column + 2] != null &&
                            board.board[line + 1][column + 2].getColor().equals(getEnemyColor()) &&
                            board.board[line + 1][column + 2].getSymbol().equals("H")) ||

                            (board.checkPos(line + 2) && board.checkPos(column + 1) &&
                                    board.board[line + 2][column + 1] != null &&
                                    board.board[line + 2][column + 1].getColor().equals(getEnemyColor()) &&
                                    board.board[line + 2][column + 1].getSymbol().equals("H")) ||

                            (board.checkPos(line - 1) && board.checkPos(column + 2) &&
                                    board.board[line - 1][column + 2] != null &&
                                    board.board[line - 1][column + 2].getColor().equals(getEnemyColor()) &&
                                    board.board[line - 1][column + 2].getSymbol().equals("H")) ||

                            (board.checkPos(line - 2) && board.checkPos(column + 1) &&
                                    board.board[line - 2][column + 1] != null &&
                                    board.board[line - 2][column + 1].getColor().equals(getEnemyColor()) &&
                                    board.board[line - 2][column + 1].getSymbol().equals("H")) ||

                            (board.checkPos(line - 2) && board.checkPos(column - 1) &&
                                    board.board[line - 2][column - 1] != null &&
                                    board.board[line - 2][column - 1].getColor().equals(getEnemyColor()) &&
                                    board.board[line - 2][column - 1].getSymbol().equals("H")) ||

                            (board.checkPos(line - 1) && board.checkPos(column - 2) &&
                                    board.board[line - 1][column - 2] != null &&
                                    board.board[line - 1][column - 2].getColor().equals(getEnemyColor()) &&
                                    board.board[line - 1][column - 2].getSymbol().equals("H")) ||

                            (board.checkPos(line + 1) && board.checkPos(column - 2) &&
                                    board.board[line + 1][column - 2] != null &&
                                    board.board[line + 1][column - 2].getColor().equals(getEnemyColor()) &&
                                    board.board[line + 1][column - 2].getSymbol().equals("H")) ||

                            (board.checkPos(line + 1) && board.checkPos(column - 2) &&
                                    board.board[line + 2][column - 1] != null &&
                                    board.board[line + 2][column - 1].getColor().equals(getEnemyColor()) &&
                                    board.board[line + 2][column - 1].getSymbol().equals("H"))
            ) res = true;
        }
        //PAWN CHECK
        if (!res) {
            if (getEnemyColor().equals("Black")) {
                if (    (board.checkPos(line + 1) && board.checkPos(column + 1) &&
                        board.board[line + 1][column + 1] != null &&
                        board.board[line + 1][column + 1].getColor().equals("Black") &&
                        board.board[line + 1][column + 1].getSymbol().equals("P")) ||
                        (board.checkPos(line - 1) && board.checkPos(column + 1) &&
                                board.board[line - 1][column + 1] != null &&
                                board.board[line - 1][column + 1].getColor().equals("Black") &&
                         board.board[line - 1][column + 1].getSymbol().equals("P"))
                ) res = true;
            }

            if (getEnemyColor().equals("White")) {
                if (    (board.checkPos(line + 1) && board.checkPos(column - 1) &&
                        board.board[line + 1][column - 1] != null && board.board[line + 1][column - 1].getColor().equals("White") &&
                        board.board[line + 1][column - 1].getSymbol().equals("P")) ||
                        (board.checkPos(line - 1) && board.checkPos(column - 1) &&
                                board.board[line - 1][column - 1] != null &&
                                board.board[line - 1][column - 1].getColor().equals("White") &&
                        board.board[line - 1][column - 1].getSymbol().equals("P"))
                ) res = true;
            }

        }

        return res;
    }
}
