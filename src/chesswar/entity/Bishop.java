package chesswar.entity;

import chesswar.entity.attackbehavior.MeleeAttackBehavior;
import chesswar.entity.movementbehavior.BishopMovementBehavior;
import chesswar.mechanic.Player;

public class Bishop extends Chessman {
    private static int BASE_DAMAGE = 2;
    private static int BASE_DEFENSE = 1;
    private static int BASE_HP = 2;

    public Bishop(Player owner) {
        super(owner);
        chessType = ChessType.BISHOP;
        attackType = AttackType.MELEE;
        setDamage(BASE_DAMAGE);
        setDefense(BASE_DEFENSE);
        setHp(BASE_HP);
        setMovementBehavior(new BishopMovementBehavior(this));
        setAttackBehavior(new MeleeAttackBehavior(this));
    }
}
