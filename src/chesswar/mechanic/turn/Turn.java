package chesswar.mechanic.turn;

import chesswar.exception.UnexpectTurnCostException;
import chesswar.mechanic.Player;
import chesswar.mechanic.command.Command;

import java.util.Stack;

public class Turn {

    private Stack<Command> commands;
    private Player player;

    public static final int MAX_TURN_COST = 10; //public cuz there is no more mutation.
    private int turnCost;

    public Turn(Player player) {
        this.player = player;
        commands = new Stack<Command>();
        setTurnCost(0);
    }

    public void executeCommand(Command command) {
        try {
            setTurnCost(command.getCommandCost() + turnCost);
            command.execute();
            commands.push(command);
        } catch (UnexpectTurnCostException e) {
            //TODO: Change output stream to game log
            System.out.print(e.toString());
        }
    }

    public void unexecuteCommand() {
        setTurnCost(turnCost - commands.peek().getCommandCost());
        commands.pop().unexecute();

    }

    public void setTurnCost(int turnCost) throws UnexpectTurnCostException {
        if (turnCost > MAX_TURN_COST)
            throw new UnexpectTurnCostException(turnCost);
        else
            this.turnCost = turnCost;
    }

    public int getTurnCost() {
        return turnCost;
    }

    public Player getPlayer() {
        return player;
    }
}
