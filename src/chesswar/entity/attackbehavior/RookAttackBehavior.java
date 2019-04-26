package chesswar.entity.attackbehavior;

import chesswar.entity.Chessman;
import chesswar.mechanic.Position;

public final class RookAttackBehavior extends DefaultAttackBehavior {
    private static final Position[] ATTACKABLE_POSITION = new Position[]{
            new Position(-2, -2), new Position(-2, -1), new Position(-2, 0), new Position(-2, 1), new Position(-2, 2),
            new Position(-1, -2), new Position(-1, -1), new Position(-1, 0), new Position(-1, 1), new Position(-1, 2),
            new Position(0, -2), new Position(0, -1), new Position(0, 1), new Position(0, 2),
            new Position(1, -2), new Position(1, -1), new Position(1, 0), new Position(1, 1), new Position(1, 2),
            new Position(2, -2), new Position(2, -1), new Position(2, 0), new Position(2, 1), new Position(2, 2),
    };

    public RookAttackBehavior(Chessman attacker) {
        this.attacker = attacker;
    }

    @Override
    public Position[] getAttackablePosition() {
        return ATTACKABLE_POSITION;
    }
}
