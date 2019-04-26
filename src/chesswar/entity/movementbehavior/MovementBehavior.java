package chesswar.entity.movementbehavior;

import chesswar.mechanic.Position;
import chesswar.mechanic.board.Field;

public interface MovementBehavior {

    boolean isMoveable(Field field);

    void move(Field before, Field after);

    Position[] getMoveablePosition();
}
