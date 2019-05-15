package chesswar.entity;

import chesswar.entity.attackbehavior.RookAttackBehavior;
import chesswar.entity.movementbehavior.PawnMovementBehavior;
import chesswar.mechanic.Player;
import chesswar.mechanic.Position;

public class Rook extends Chessman {

    private static int BASE_DAMAGE = 1;
    private static int BASE_DEFENSE = 1;
    private static int BASE_HP = 5;

    public Rook(Player owner) {
        super(owner);
        chessType = ChessType.ROOK;
        attackType = AttackType.RANGE;
        setDamage(BASE_DAMAGE);
        setDefense(BASE_DEFENSE);
        setHp(BASE_HP);
        penetrationBuff = false;
        setMovementBehavior(new PawnMovementBehavior(this));
        setAttackBehavior(new RookAttackBehavior(this));
    }
}
