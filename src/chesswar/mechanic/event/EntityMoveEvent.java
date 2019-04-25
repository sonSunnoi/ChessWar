package chesswar.mechanic.event;

import chesswar.entity.Chessman;

public class EntityMoveEvent implements Event {

    private Chessman chessman;

    public EntityMoveEvent(Chessman chessman) {
        this.chessman = chessman;
    }
}
