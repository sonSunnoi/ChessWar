package chesswar.entity;

import chesswar.entity.attackbehavior.MeleeAttackBehavior;
import chesswar.entity.movementbehavior.KnightMovementBehavior;
import chesswar.mechanic.Player;

public class Knight extends Chessman {

    private static int BASE_DAMAGE = 2;
    private static int BASE_DEFENSE = 0;
    private static int BASE_HP = 3;

    public Knight(Player owner) {
        super(owner);
        chessType = ChessType.KNIGHT;
        attackType = AttackType.MELEE;
        setDamage(BASE_DAMAGE);
        setDefense(BASE_DEFENSE);
        setHp(BASE_HP);
        penetrationBuff = false;
        setMovementBehavior(new KnightMovementBehavior(this));
        setAttackBehavior(new MeleeAttackBehavior(this));
    }
}
