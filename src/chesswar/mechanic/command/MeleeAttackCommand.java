package chesswar.mechanic.command;

import chesswar.entity.Chessman;

public final class MeleeAttackCommand implements Command {

    private static int COST = 1;
    private Chessman attacker;
    private Chessman victim;
    private boolean isMovedBeforeAttack;
    private int victimHealtBeforeAttacked;

    public MeleeAttackCommand(Chessman attacker, Chessman victim) {
        this.attacker = attacker;
        this.victim = victim;
        isMovedBeforeAttack = attacker.isMoved();
        victimHealtBeforeAttacked = victim.getHp();
    }

    @Override
    public void execute() {
        attacker.attack(victim);
    }

    @Override
    public void unexecute() {
        victim.setHp(victimHealtBeforeAttacked);
        attacker.setAttacked(false);
        attacker.setMoved(isMovedBeforeAttack);
    }

    @Override
    public int getCommandCost() {
        return COST;
    }
}
