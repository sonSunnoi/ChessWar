package mechanic.event;

import entity.component.Chessman;

public class ChessAttackEvent implements Event {

    private Chessman attacker;
    private Chessman victim;

    public ChessAttackEvent(Chessman attacker, Chessman victim) {
        this.attacker = attacker;
        this.victim = victim;
    }
}
