package entity.movementbehavior;

import mechanic.Field;
import mechanic.Position;

public interface MovementBehavior {

    Position[] getMoveablePosition();
    boolean isMovable(Position pos);
    Field move(Position pos);
}
