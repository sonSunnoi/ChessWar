package arena;

import java.util.Vector;

public class Turn {

    private Vector<BoardState> boardStateVector;
    private int moveCount;
    private static final int MAX_MOVE = 5;
    private BoardState now;

    public Turn(){
        now = new NullBoardState();
        moveCount = 0;
        boardStateVector = new Vector<BoardState>();
        boardStateVector.add(now);
    }

    public boolean addBoardState(BoardState boardState){
        boardStateVector.add(boardState);
        //TODO: notify
    }

    //Feature TODO: make undo / redo

}
