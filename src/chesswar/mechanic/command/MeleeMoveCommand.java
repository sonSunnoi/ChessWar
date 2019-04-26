package chesswar.mechanic.command;

import chesswar.entity.Chessman;
import chesswar.mechanic.Position;
import chesswar.mechanic.board.Field;

public final class MeleeMoveCommand implements Command {

    private static int COST = 1;
    private Chessman chessman;
    private Field after;
    private Field before;


    public MeleeMoveCommand(Chessman chessman, Field before, Field after) {
        this.chessman = chessman;
        this.before = before;
        this.after = after;
    }

    @Override
    public void execute() {
        chessman.getMovementBehavior().move(before, after);
    }

    @Override
    public void unexecute() {
        chessman.getMovementBehavior().move(after, before);
        chessman.setMoved(false);
    }

    @Override
    public int getCommandCost() {
        return COST;
    }
}
