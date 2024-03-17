package lk.ijse.dep.service;

public class BoardImpl implements Board {

    private final Piece [][] pieces;

    private final BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {
        this.boardUI = boardUI;
        this.pieces=new Piece[6][5];

        //initialize all the pieces
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                pieces[i][j]=Piece.EMPTY;
            }
        }
    }
    public Piece[][] getPieces() {
        return pieces;
    }
    public BoardUI getBoardUI() {
        return this.boardUI;
    }
    //should return the first empty space in the specified column.
    //If there are no free spaces in the column, the function should return -1.
    @Override
    public int findNextAvailableSpot(int col) {

        for (int i = 0; i < pieces[col].length; i++) {
            if (pieces[col][i]==Piece.EMPTY){
                return i;
            }
        }
        return -1;
    }
    //should return a boolean representing whether the current move is a legal
    //move or not finding whether there is an open space in the row
    @Override
    public boolean isLegalMove(int col) {
        int index=findNextAvailableSpot(col);
        return index != -1;
    }
    //whether one side has already connected 4 in a row. As long as there is a single spot available this method
    //should return true
    @Override
    public boolean existLegalMoves() {
        for (int i = 0; i < pieces.length; i++) {
            if (isLegalMove(i)){
                return true;
            }
        }
        return false;
    }
   // method should update the board by putting the piece
   // whose turn it is in the first free row of the specified column
    //. You are not validating whether the move is
   //legal here
    @Override
    public void updateMove(int col, Piece move) {
        int index=findNextAvailableSpot(col);
        pieces[col][index]=move;
    }

    @Override
    public void updateMove(int col, int row, Piece move) {
        pieces[col][row]=move;
    }
//method should check if either player has already connected four pieces.
    @Override
    public Winner findWinner() {

        int count=0;

        //Vertically

        for (int i = 0; i < pieces.length; i++){
            for (int j = 0; j < pieces[i].length-1; j++){
                if (pieces[i][j]==pieces[i][j+1]){
                    count++;
                    if (count==3 && pieces[i][j]!=Piece.EMPTY){
                        return new Winner(pieces[i][j],i,(j-2),i,(j+1));
                    }
                }
                else{
                    count=0;
                }
            }
            count=0;
        }

        count=0;

        //Horizontally

        for (int i = 0; i < pieces[0].length; i++){
            for (int j = 0; j < pieces.length-1; j++){
                if (pieces[j][i]==pieces[j+1][i]){
                    count++;
                    if (count==3 && pieces[j][i]!=Piece.EMPTY){
                        return  new Winner(pieces[j][i],(j-2),i,(j+1),i);
                    }
                }
                else{
                    count=0;
                }
            }
            count=0;
        }
        return new Winner(Piece.EMPTY);

    }

}
