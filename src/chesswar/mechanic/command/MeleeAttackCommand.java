package chesswar.mechanic.command;

import chesswar.entity.Chessman;
import chesswar.mechanic.board.Field;

public final class MeleeAttackCommand implements Command {

    private static int COST = 1;
    private Chessman attacker;
    private Chessman victim;
    private Field victimField;
    private boolean isMovedBeforeAttack;
    private int victimHealtBeforeAttacked;

    public MeleeAttackCommand(Chessman attacker, Field victimField) {
        this.attacker = attacker;
        this.victimField = victimField;
        this.victim = victimField.getChessman();

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
        victimField.setChessman(victim);
        attacker.setAttacked(false);
        attacker.setMoved(isMovedBeforeAttack);
    }

    @Override
    public int getCommandCost() {
        return COST;
    }
}
