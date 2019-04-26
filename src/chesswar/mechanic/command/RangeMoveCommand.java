package chesswar.mechanic.command;

import chesswar.entity.Chessman;
import chesswar.mechanic.board.Field;

public final class RangeMoveCommand implements Command {

    private static int COST = 2;
    private Chessman chessman;
    private Field after;
    private Field before;


    public RangeMoveCommand(Chessman chessman, Field before, Field after) {
        this.chessman = chessman;
        this.before = before;
        this.after = after;
    }

    @Override
    public void execute() {
        chessman.getMovementBehavior().move(before, after);
        chessman.setAttacked(true);
    }

    @Override
    public void unexecute() {
        chessman.getMovementBehavior().move(after, before);
        chessman.setAttacked(false);
        chessman.setMoved(false);
    }

    @Override
    public int getCommandCost() {
        return COST;
    }
}
