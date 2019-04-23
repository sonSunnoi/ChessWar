package entity.component;

import arena.Player;
import arena.Position;
import entity.attackbehavior.AttackBehavior;
import entity.movementbehavior.MovementBehavior;
import dedicated.EventSystem;

public abstract class Chessman {

    protected int damage;
    protected int defense;
    protected int hp;
    protected boolean isAttacked;
    protected boolean isMoved;
    protected boolean isAlive;

    protected EventSystem eventSystem;
    protected ChessType chessType;
    protected MovementBehavior movementBehavior;
    protected AttackBehavior attackBehavior;
    protected Player owner;
    protected Position pos;

    private Chessman() {
        isAttacked = false;
        isMoved = false;
        isAlive = true;
    }

    public Chessman(Player owner, Position pos, EventSystem eventSystem) {
        this();
        this.owner = owner;
        this.pos = pos;
        this.eventSystem = eventSystem;
    }

    public Chessman(Player owner, int x, int y) {
        this.owner = owner;
        this.pos = new Position(x, y);
    }

    public int attack(Chessman victim) {
        return attackBehavior.attack(victim);
    }

    public int receiveDamage(Chessman attacker) {
        int inflict = Math.max(0, attacker.getDamage() - this.getDefense());
        setHp(this.hp - inflict);
        if (!isAlive) {
            //TODO: ChessKillEvent?
        }

        return inflict;
    }

    public boolean isAlly(Chessman chessman){
        //TODO: confirm that use == or equals
        if(this.getOwner().equals(chessman.getOwner()))
            return true;
        return false;
    }

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

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
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

    public EventSystem getEventSystem() {
        return eventSystem;
    }

    public Player getOwner() {
        return owner;
    }
}
