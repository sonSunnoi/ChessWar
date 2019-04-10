package arena;

//one object per one stage in the board
public class BoardState {

    private Field[][] board;

    public BoardState(){
        board = new Field[16][16];
    }

    //copy constructor
    public BoardState(BoardState boardState){
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                board[i][j] = new Field(boardState.getField(i,j));
            }
        }
    }

    public Field getField(int x, int y) {
        try {
            return board[x][y];
        } catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }
}

