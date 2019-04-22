package arena;

//one object per one stage in the board
public class Board {

    private Field[][] board;
    private static int BOARD_SIZE = 12;
    public Board(){
        board = new Field[BOARD_SIZE][BOARD_SIZE];
    }

    //copy constructor
    public Board(Board board){
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                this.board[i][j] = new Field(board.getField(i,j));
            }
        }
    }

    public Field getField(int x, int y) {
        try {
            return board[x][y];
        } catch (ArrayIndexOutOfBoundsException e){
            return ;
        }
    }
}

