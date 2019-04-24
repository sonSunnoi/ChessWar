package entity.attackbehavior;

import mechanic.Position;
import EventSystem;
import entity.Chessman;
import mechanic.event.EntityAttackEvent;

public abstract class RangeAttackBehavior implements  AttackBehavior{

    protected Chessman attacker;
    protected EventSystem eventSystem;
    protected Position[] attackablePosition;

    @Override
    public boolean canAttack(Chessman victim) {
        for(Position pos : attackablePosition){
            if (victim.getPos().equals(attacker.getPos().sum(pos)) && !attacker.isAttacked()) {
                return true;
            }
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
