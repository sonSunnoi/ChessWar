package chesswar.entity;

import chesswar.entity.attackbehavior.MeleeAttackBehavior;
import chesswar.entity.movementbehavior.KingMovementBehavior;
import chesswar.entity.movementbehavior.PawnMovementBehavior;
import chesswar.mechanic.Player;
import chesswar.mechanic.Position;

public class Pawn extends Chessman {

    private static int BASE_DAMAGE = 1;
    private static int BASE_DEFENSE = 0;
    private static int BASE_HP = 2;

    public Pawn(Player owner) {
        super(owner);
        chessType = ChessType.PAWN;
        attackType = AttackType.MELEE;
        setDamage(BASE_DAMAGE);
        setDefense(BASE_DEFENSE);
        setHp(BASE_HP);
        setMovementBehavior(new PawnMovementBehavior(this));
        setAttackBehavior(new MeleeAttackBehavior(this));
    }
}
