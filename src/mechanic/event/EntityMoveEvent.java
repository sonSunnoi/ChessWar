package mechanic.event;

import entity.Chessman;

public class EntityMoveEvent {

    private Chessman chessman;

    public EntityMoveEvent(Chessman chessman) {
        this.chessman = chessman;
    }
}
