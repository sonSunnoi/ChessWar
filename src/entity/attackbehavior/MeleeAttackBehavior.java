package entity.attackbehavior;

import dedicated.EventSystem;
import entity.component.Chessman;
import mechanic.event.ChessAttackEvent;

public class MeleeAttackBehavior implements AttackBehavior {

    private Chessman attacker;
    private EventSystem eventSystem;

    public MeleeAttackBehavior(Chessman attacker, EventSystem eventSystem) {
        this.attacker = attacker;
    }

    @Override
    public boolean canAttack(Chessman victim) {
        if (attacker.getPos().equals(victim.getPos()) && !attacker.isAttacked()) {
            return true;
        }
        return false;
    }

    @Override
    public int attack(Chessman victim) {
        if (canAttack(victim)) {
            attacker.setAttacked(true);
            attacker.setMoved(true);
            eventSystem.dispatch(new ChessAttackEvent(attacker, victim));
            return attacker.attack(victim);
        }
        return -1;
    }
}
