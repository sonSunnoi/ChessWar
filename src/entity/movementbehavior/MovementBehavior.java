package entity.movementbehavior;

import arena.Field;
import arena.Position;

public interface MovementBehavior {

    void getMoveablePosition();
    boolean isMovable(Position pos);
    Field move(Board Position pos);
}
