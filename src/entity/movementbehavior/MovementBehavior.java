package entity.movementbehavior;

import arena.Field;
import arena.Position;

public interface MovementBehavior {

    Position[] getMoveablePosition();
    boolean isMovable(Position pos);
    Field move(Position pos);
}
