package dedicated;

import mechanic.command.Command;

import java.util.ArrayList;

public class ChessWarInvoker {

    private ArrayList<Command> commands;
    private Command currentCommand;

    public ChessWarInvoker() {
        commands = new ArrayList<Command>();
    }

}
