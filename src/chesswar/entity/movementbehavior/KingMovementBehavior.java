package chesswar.entity.movementbehavior;

import chesswar.mechanic.Position;
import chesswar.mechanic.board.Field;
import chesswar.mechanic.event.EventSystem;
import chesswar.entity.Chessman;

public final class KingMovementBehavior implements MovementBehavior {

    private static final Position[] MOVEABLE_POSITION = new Position[]{
            new Position(-1, -1),
            new Position(0, -1),
            new Position(1, -1),
            new Position(-1, 0),
            new Position(1, 0),
            new Position(-1, 1),
            new Position(0, 1),
            new Position(1, 1),
    };

    private Chessman chessman;

    public KingMovementBehavior(Chessman chessman) {
        this.chessman = chessman;
    }

    @Override
    public Position[] getMoveablePosition() {
        return MOVEABLE_POSITION;
    }

    @Override
    public boolean isMoveable(Field field) {
        try {
            if (field.getChessman() == null) {
                return true;
            }
        } catch (NullPointerException e) {

        }
        return false;
    }

    @Override
    public void move(Field before, Field after) {
        after.setChessman(chessman);
        before.setChessman(null);
        chessman.setMoved(true);
    }
}
