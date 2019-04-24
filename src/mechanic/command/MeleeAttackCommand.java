package mechanic.command;

public class MeleeAttackCommand implements  Command{

    private static int COST = 1;


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
