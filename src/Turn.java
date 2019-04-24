import mechanic.command.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Turn {

    private Stack<Command> commands;
    private Command currentCommand;

    public Turn() {
        commands = new Stack<Command>();
    }

    public void executeCommand(Command command){
        if (commands.size() < 5) {
            commands.push(command);
            currentCommand = command;
        }


    }

    public void unexecuteCommand(){
        commands.pop().unexecute();
        currentCommand = commands.peek();
    }
}
