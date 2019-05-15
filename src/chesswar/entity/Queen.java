package chesswar.entity;

import chesswar.entity.attackbehavior.QueenAttackBehavior;
import chesswar.entity.movementbehavior.PawnMovementBehavior;
import chesswar.mechanic.Player;

public class Queen extends Chessman {

    private static int BASE_DAMAGE = 3;
    private static int BASE_DEFENSE = 0;
    private static int BASE_HP = 2;

    public Queen(Player owner) {
        super(owner);
        chessType = ChessType.QUEEN;
        attackType = AttackType.RANGE;
        setDamage(BASE_DAMAGE);
        setDefense(BASE_DEFENSE);
        setHp(BASE_HP);
        penetrationBuff = false;
        setMovementBehavior(new PawnMovementBehavior(this));
        setAttackBehavior(new QueenAttackBehavior(this));
    }
}
