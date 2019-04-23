package entity.movementbehavior;

import arena.Field;
import arena.Position;
import dedicated.EventSystem;
import entity.component.Chessman;

public class KingMovementBehavior implements MovementBehavior {

    private Chessman chessman;
    private EventSystem eventSystem;
    private  Position[] moveablePosition;

    public KingMovementBehavior(Chessman chessman, EventSystem eventSystem){
        this.chessman = chessman;
        this.eventSystem = eventSystem;
        moveablePosition = new Position[]{
                new Position(-1,-1),
                new Position(0,-1),
                new Position(1,-1),
                new Position(-1,0),
                new Position(1,0),
                new Position(-1,1),
                new Position(0,1),
                new Position(1,1),
        };
    }

    @Override
    public Position[] getMoveablePosition() {
        return moveablePosition;
    }

    @Override
    public boolean isMovable(Position pos) {

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
