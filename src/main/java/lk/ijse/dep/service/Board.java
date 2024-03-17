package lk.ijse.dep.service;

public interface Board {
    public int NUM_OF_ROWS = 5;
    public int NUM_OF_COLS = 6;
    BoardUI getBoardUI();
   int findNextAvailableSpot(int col);

   boolean isLegalMove(int col);

   boolean existLegalMoves();

  void updateMove(int col, Piece move);
  void updateMove(int col, int row,Piece move);
  Piece[][] getPieces();
  Winner findWinner();


}
