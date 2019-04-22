package entity.movementbehavior;

import arena.Field;
import arena.Position;
import entity.component.Chessman;

public class KingMovementBehavior implements MovementBehavior {

    private Chessman chessman;
    private static Position[] MOVEABLE_POSITION = {
            new Position(-1,-1),
            new Position(0,-1),
            new Position(1,-1),
            new Position(-1,0),
            new Position(1,0),
            new Position(-1,1),
            new Position(0,1),
            new Position(1,1),
    };

    public KingMovementBehavior(Chessman chessman){
        this.chessman = chessman;

    }
    @Override
    public Arra showMoveable() {
        for (Position: MOVEABLE_POSITION) {

        }
        return;
    }

    @Override
    public boolean isMovable(Position pos) {
        if(!chessman.isMoved()) {
            if()
            return true;
        }
        return false;
    }


    @Override
    public Field move(Position pos) {
        if(isMovable(pos)) {
            if()
            chessman.setMoved(true);
            chessman.setPos();
            return field;
        }

    }
}
