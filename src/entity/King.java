package entity;

import mechanic.Player;
import mechanic.Position;
import entity.attackbehavior.MeleeAttackBehavior;

public class King extends Chessman {

    private static int BASE_DAMAGE = 1;
    private static int BASE_DEFENSE = 0;
    private static int BASE_HP = 10;

    public King(Player owner, Position pos) {
        super(owner, pos);

        setDamage(BASE_DAMAGE);
        setDefense(BASE_DEFENSE);
        setHp(BASE_HP);
        setAlive(true);
        setAttacked(false);
        setMoved(false);
        setMovementBehavior(KingMoveBehavior);
        setAttackBehavior(new MeleeAttackBehavior(this));
    }

    public King(Player owner, int x, int y) {
        this(owner, new Position(x, y));
    }

    @Override
    public int attack(Chessman victim) {
        int penetration = victim.getDefense();
        setDamage(getDamage() + penetration);
        int attack = victim.receiveDamage(this);
        setDamage(getDamage() - penetration);
        return attack;
    }

    //inject king aura pass player
}
