package chesswar.entity;

import chesswar.entity.attackbehavior.KingAttackBehavior;
import chesswar.entity.movementbehavior.KingMovementBehavior;
import chesswar.mechanic.Player;
import chesswar.mechanic.Position;
import chesswar.entity.attackbehavior.MeleeAttackBehavior;

public class King extends Chessman {

    private static int BASE_DAMAGE = 1;
    private static int BASE_DEFENSE = 0;
    private static int BASE_HP = 10;

    public King(Player owner) {
        super(owner);
        chessType = ChessType.KING;
        attackType = AttackType.MELEE;
        setDamage(BASE_DAMAGE);
        setDefense(BASE_DEFENSE);
        setHp(BASE_HP);
        setMovementBehavior(new KingMovementBehavior(this));
        setAttackBehavior(new KingAttackBehavior(this));
    }
}
