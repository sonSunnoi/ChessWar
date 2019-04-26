package chesswar.mechanic.event;

import chesswar.entity.Chessman;
import chesswar.mechanic.board.Field;

public class EntityMoveEvent implements Event {

    private Chessman chessman;
    private Field before;
    private Field after;

    public EntityMoveEvent(Chessman chessman, Field before, Field after) {
        this.chessman = chessman;
        this.before = before;
        this.after = after;
    }
}
