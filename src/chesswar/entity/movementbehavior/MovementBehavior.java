package chesswar.entity.movementbehavior;

import chesswar.mechanic.board.Field;
import chesswar.mechanic.Position;

public interface MovementBehavior {

    boolean isMovable(Position pos);

    Field move(Position pos);

    Position[] getMoveablePosition();
}
