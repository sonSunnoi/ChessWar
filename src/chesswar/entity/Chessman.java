package chesswar.entity;

import chesswar.mechanic.Player;
import chesswar.mechanic.Position;
import chesswar.entity.attackbehavior.AttackBehavior;
import chesswar.entity.movementbehavior.MovementBehavior;
import chesswar.mechanic.event.EventSystem;

public abstract class Chessman {

    protected int damage;
    protected int defense;
    protected int hp;
    protected boolean isAttacked;
    protected boolean isMoved;
    protected boolean isAlive;

    protected Player owner;
    protected ChessType chessType;
    protected AttackType attackType;
    protected MovementBehavior movementBehavior;
    protected AttackBehavior attackBehavior;


    public Chessman(Player player) {
        this.owner = player;
        isAttacked = false;
        isMoved = false;
    }

    public int attack(Chessman victim) {
        return attackBehavior.attack(victim);
    }

    public int receiveDamage(Chessman attacker) {
        int inflict = Math.max(0, attacker.getDamage() - this.getDefense());
        setHp(this.hp - inflict);
        return inflict;
    }

    public boolean isAlly(Chessman chessman) {
        //TODO: confirm that use == or equals
        if (this.getOwner() == chessman.getOwner()){
            return true;
        }
        return false;
    }

    //below this is getter setter

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = Math.max(0, damage);
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = Math.max(0, defense);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, hp);
        if (this.hp == 0) {
            setAlive(false);
        } else {
            setAlive(true);
        }
    }

    public MovementBehavior getMovementBehavior() {
        return movementBehavior;
    }

    public void setMovementBehavior(MovementBehavior movementBehavior) {
        this.movementBehavior = movementBehavior;
    }

    public AttackBehavior getAttackBehavior() {
        return attackBehavior;
    }

    public void setAttackBehavior(AttackBehavior attackBehavior) {
        this.attackBehavior = attackBehavior;
    }

    public boolean isAttacked() {
        return isAttacked;
    }

    public void setAttacked(boolean attacked) {
        isAttacked = attacked;
    }

    public boolean isMoved() {
        return isMoved;
    }
    public void setMoved(boolean moved) {
        isMoved = moved;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public ChessType getChessType() {
        return chessType;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public Player getOwner() {
        return owner;
    }
}
