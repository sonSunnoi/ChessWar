package chesswar.mechanic.command;

import chesswar.entity.Chessman;

public final class RangeAttackCommand implements Command {

    private static int COST = 2;
    private Chessman attacker;
    private Chessman victim;
    private boolean isMovedBeforeAttack;
    private int victimHealtBeforeAttacked;

    public RangeAttackCommand(Chessman attacker, Chessman victim) {
        this.attacker = attacker;
        this.victim = victim;
        victimHealtBeforeAttacked = victim.getHp();
    }

    @Override
    public void execute() {
        attacker.attack(victim);
        attacker.setAttacked(true);
        attacker.setAttacked(true);
    }

    @Override
    public void unexecute() {
        victim.setHp(victimHealtBeforeAttacked);
        attacker.setAttacked(false);
        attacker.setMoved(false);
    }


    @Override
    public int getCommandCost() {
        return COST;
    }
}
