package entity.attackbehavior;

import entity.component.Chessman;

public interface AttackBehavior {

    boolean canAttack(Chessman victim);
    int attack(Chessman victim);
}
