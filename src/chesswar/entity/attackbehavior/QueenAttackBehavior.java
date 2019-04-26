package chesswar.entity.attackbehavior;

import chesswar.mechanic.Position;
import chesswar.mechanic.event.EventSystem;
import chesswar.entity.Chessman;

public final class QueenAttackBehavior extends DefaultAttackBehavior {

    private static final Position[] ATTACKABLE_POSITION = new Position[]{
            new Position(1, 0), new Position(2, 0), new Position(3, 0), new Position(4, 0), new Position(5, 0),
            new Position(-1, 0), new Position(-2, 0), new Position(-3, 0), new Position(-4, 0), new Position(-5, 0),
            new Position(0, 1), new Position(0, 2), new Position(0, 3), new Position(0, 4), new Position(0, 5),
            new Position(0, -1), new Position(0, -2), new Position(0, -3), new Position(0, -4), new Position(0, -5),
    };

    public QueenAttackBehavior(Chessman attacker) {
        this.attacker = attacker;
    }

    @Override
    public Position[] getAttackablePosition() {
        return ATTACKABLE_POSITION;
    }
}
