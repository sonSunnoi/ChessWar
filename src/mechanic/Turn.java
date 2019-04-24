package mechanic;

import exception.UnexpectTurnCostException;
import mechanic.command.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Turn {

    private Stack<Command> commands;

    public final static int MAX_TURN_COST = 10; //public cuz there is no more mutation.
    private int turnCost;

    public Turn() {
        commands = new Stack<Command>();
        setTurnCost(0);
    }

    public void executeCommand(Command command){
        try {
            setTurnCost(command.getCommandCost() + turnCost);
            command.execute();
            commands.push(command);
        } catch (UnexpectTurnCostException e){
            //TODO: Change output stream to game log
            System.out.print(e.toString());
        }


    }

    public void unexecuteCommand(){
        commands.pop().unexecute();
    }

    public void setTurnCost(int turnCost) throws UnexpectTurnCostException {
        if(turnCost > MAX_TURN_COST)
            throw new UnexpectTurnCostException(turnCost);
        else
            this.turnCost = turnCost;

    }
}
