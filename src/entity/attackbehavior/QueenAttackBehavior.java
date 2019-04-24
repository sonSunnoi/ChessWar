package entity.attackbehavior;

import mechanic.Position;
import EventSystem;
import entity.Chessman;

public class QueenAttackBehavior extends RangeAttackBehavior {

    public QueenAttackBehavior(Chessman atttacker, EventSystem eventSystem) {
        this.attacker = atttacker;
        this.eventSystem = eventSystem;
        attackablePosition = new Position[]{
                new Position(1, 0), new Position(2, 0), new Position(3, 0), new Position(4, 0), new Position(5, 0),
                new Position(-1, 0), new Position(-2, 0), new Position(-3, 0), new Position(-4, 0), new Position(-5, 0),
                new Position(0, 1), new Position(0, 2), new Position(0, 3), new Position(0, 4), new Position(0, 5),
                new Position(0, -1), new Position(0, -2), new Position(0, -3), new Position(0, -4), new Position(0, -5),
        };
    }
}
