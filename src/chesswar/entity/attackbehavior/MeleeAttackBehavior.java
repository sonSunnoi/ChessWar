package chesswar.entity.attackbehavior;

import chesswar.mechanic.Position;
import chesswar.mechanic.event.EventSystem;
import chesswar.entity.Chessman;
import chesswar.mechanic.event.EntityAttackEvent;

public final class MeleeAttackBehavior extends DefaultAttackBehavior {


    private static final Position[] ATTACKABLE_POSITION = new Position[]{
            new Position(-1, 0),
            new Position(1, 0),
            new Position(0, -1),
            new Position(0, 1)
    };

    public MeleeAttackBehavior(Chessman attacker) {
        this.attacker = attacker;
    }

    @Override
    public Position[] getAttackablePosition() {
        return ATTACKABLE_POSITION;
    }
}
