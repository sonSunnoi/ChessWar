package chesswar.mechanic.command;

public interface Command {
    void execute();
    void unexecute();
    int getCommandCost();
}
