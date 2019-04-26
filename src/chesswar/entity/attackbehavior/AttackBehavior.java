package chesswar.entity.attackbehavior;

import chesswar.entity.Chessman;
import chesswar.mechanic.Position;

public interface AttackBehavior {

    boolean canAttack(Chessman victim);

    int attack(Chessman victim);

    Position[] getAttackablePosition();
}
