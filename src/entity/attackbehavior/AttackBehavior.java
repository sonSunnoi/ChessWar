package entity.attackbehavior;

import entity.Chessman;

public interface AttackBehavior {

    boolean canAttack(Chessman victim);
    int attack(Chessman victim);
}
