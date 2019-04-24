package entity;

import mechanic.Player;
import mechanic.Position;

public class Rook extends Chessman {

    private static int BASE_DAMAGE = 1;
    private static int BASE_DEFENSE = 0;
    private static int BASE_HP = 10;

    public Rook(Player owner, Position pos) {
        super(owner, pos);
        setDamage(BASE_DAMAGE);
        setDefense(BASE_DEFENSE);
        setHp(BASE_HP);
        setAlive(true);
        setAttacked(false);
        setMoved(false);
        setMovementBehavior(RookMoveBehavior);
        setAttackBehavior(RookAttackBehavior);
    }

    public Rook(Player owner, int x, int y) {
        this(owner, new Position(x, y));
    }
}
