package chesswar.mechanic.event;

import chesswar.entity.Chessman;

public class EntityAttackEvent implements Event {

    private Chessman attacker;
    private Chessman victim;

    public EntityAttackEvent(Chessman attacker, Chessman victim) {
        this.attacker = attacker;
        this.victim = victim;
    }
}
