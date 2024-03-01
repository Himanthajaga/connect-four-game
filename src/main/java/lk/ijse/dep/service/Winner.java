package lk.ijse.dep.service;

public class Winner {
    private Piece winningPiece;
    private int row1;
    private int col1;
    private int row2;
    private int col2;
    public Winner(Piece winningPiece) {}
    public Winner(Piece winningPiece, int row1, int col1, int row2, int col2) {
        this.winningPiece = winningPiece;
        this.row1 = row1;
        this.col1 = col1;
        this.row2 = row2;
        this.col2 = col2;
    }

    public int getWinningPiece() {
        return winningPiece.ordinal();
    }

    public String getCol1() {
        return String.valueOf(col1);
    }

    public String getCol2() {
        return String.valueOf(col2);
    }

    public Object getRow1() {
        return String.valueOf(row1);
    }

    public int getRow2() {
        return row2;
    }

    @Override
    public String toString() {
        return "Winner{" +
                "winningPiece=" + winningPiece +
                ", row1=" + row1 +
                ", col1=" + col1 +
                ", row2=" + row2 +
                ", col2=" + col2 +
                '}';
    }
}
