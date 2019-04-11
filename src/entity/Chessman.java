package entity;

import arena.Player;
import entity.movebehavior.MoveBehavior;

public abstract class Chessman {

    protected int damage;
    protected int defense;
    protected int hp;

    protected MoveBehavior moveBehavior;

    protected boolean action;
    protected boolean isAlive;


    public int attack(Chessman victim){
         return victim.receiveDamage(this);
    }

    public int receiveDamage(Chessman attacker){
        int inflict = Math.max(0,attacker.getDamage() - this.getDefense());
        setHp(this.hp - inflict);
        if (!isAlive) {
            //TODO: ChessKillEvent?
        }

        return inflict;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = Math.max(0,damage);
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = Math.max(0,defense);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0,hp);
        if (this.hp == 0) {
            setAlive(false);
        }
    }

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
