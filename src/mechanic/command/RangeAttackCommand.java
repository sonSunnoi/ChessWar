package mechanic.command;

public class RangeAttackCommand implements Command {

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
