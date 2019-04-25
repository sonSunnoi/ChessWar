package chesswar.mechanic.command;

public class RangeMoveCommand implements Command {

    private static int COST = 2;

    @Override
    public void execute() {

    }

    @Override
    public void unexecute() {

    }

    @Override
    public int getCommandCost() {
        return COST;
    }
}
