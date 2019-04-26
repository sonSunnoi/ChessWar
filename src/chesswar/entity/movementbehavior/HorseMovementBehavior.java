package chesswar.entity.movementbehavior;

import chesswar.entity.Chessman;
import chesswar.mechanic.Position;
import chesswar.mechanic.board.Field;

public final class HorseMovementBehavior implements MovementBehavior {
    private static final Position[] MOVEABLE_POSITION = new Position[]{
            new Position(-1, -2),
            new Position(1, -2),
            new Position(-2, -1),
            new Position(2, -1),
            new Position(-2, 1),
            new Position(2, 1),
            new Position(-1, 2),
            new Position(-1, 2),
    };

    private Chessman chessman;

    public HorseMovementBehavior(Chessman chessman) {
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
