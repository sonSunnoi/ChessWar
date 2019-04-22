package entity.attackbehavior;

import arena.Position;
import dedicated.EventSystem;
import entity.component.Chessman;
import mechanic.event.ChessAttackEvent;

import java.util.ArrayList;

public abstract class RangeAttackBehavior implements  AttackBehavior{

    protected Chessman attacker;
    protected EventSystem eventSystem;
    protected ArrayList<Position> attackablePosition;

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
            eventSystem.dispatch(new ChessAttackEvent(attacker, victim));
            return attacker.attack(victim);
        }
        return 0;
    }
}
