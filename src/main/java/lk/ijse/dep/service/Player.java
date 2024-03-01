package lk.ijse.dep.service;

public class Player implements Board {
    @Override
    public BoardUI getBoard() {
        return null;
    }

    @Override
    public int findnextAvailableSpot(int col) {
        return 0;
    }

    @Override
    public boolean isLegalMove(int col) {
        return false;
    }

    @Override
    public boolean existLegalMoves() {
        return false;
    }

    @Override
    public void updateMove(int col, Piece move) {

    }

    @Override
    public Winner findWinner() {
        return null;
    }

    public void movePiece(int i) {
    }
}
