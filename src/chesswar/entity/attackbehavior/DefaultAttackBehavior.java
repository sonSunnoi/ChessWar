package chesswar.entity.attackbehavior;

import chesswar.entity.Chessman;
import chesswar.mechanic.Position;

public abstract class DefaultAttackBehavior implements AttackBehavior {

    protected Chessman attacker;

    @Override
    public boolean canAttack(Chessman victim) {
        try {
            if (!attacker.isAttacked() && !attacker.isAlly(victim)) {
                return true;
            }
        } catch (NullPointerException e) {
            return false;
        }
        return false;
    }

    @Override
    public int attack(Chessman victim) {
        if (canAttack(victim)) {
            attacker.setAttacked(true);
            attacker.setMoved(true);
            return victim.receiveDamage(attacker);
        }
        return -1;
    }
}
