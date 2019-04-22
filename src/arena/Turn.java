package arena;

import java.util.Vector;

public class Turn {

    private Vector<Board> boardVector;
    private int moveCount;
    private static final int MAX_MOVE = 5;
    private Board now;
    private Player player;
    public Turn(Player player){
        this.player = player;
        now = new NullBoard();
        moveCount = 0;
        boardVector = new Vector<Board>();
        boardVector.add(now);
    }

    public boolean addBoardState(Board board){
        boardVector.add(board);
        //TODO: notify
    }

    //Feature TODO: make undo / redo

}
