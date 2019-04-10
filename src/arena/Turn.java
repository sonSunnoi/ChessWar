package arena;

import java.util.Vector;

public class Turn {

    Vector<BoardState> boardStateVector;
    int moveCount;
    private static final int MAX_MOVE = 5;
    BoardState now;

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
