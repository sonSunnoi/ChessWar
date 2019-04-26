package chesswar.entity.attackbehavior;

import chesswar.mechanic.event.EventSystem;
import chesswar.entity.Chessman;
import chesswar.mechanic.event.EntityAttackEvent;

public class MeleeAttackBehavior implements AttackBehavior {

    private Chessman attacker;
    private EventSystem eventSystem;

    public MeleeAttackBehavior(Chessman attacker, EventSystem eventSystem) {
        this.attacker = attacker;
        this.eventSystem = eventSystem;
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
            eventSystem.dispatch(new EntityAttackEvent(attacker, victim));
            return victim.receiveDamage(attacker);
        }
        return -1;
    }
}
