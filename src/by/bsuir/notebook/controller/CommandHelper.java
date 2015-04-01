package by.bsuir.notebook.controller;

import by.bsuir.notebook.bean.OperationType;
import by.bsuir.notebook.logic.ICommand;
import by.bsuir.notebook.logic.command.AddNoteCommand;
import by.bsuir.notebook.logic.command.DisplayNotebookCommand;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valentin on 3/19/2015.
 */
public class CommandHelper {
    private static CommandHelper instance = new CommandHelper();
    private Map<OperationType, ICommand> commandMap = new HashMap<OperationType, ICommand>();
    private CommandHelper(){
        commandMap.put(OperationType.ADD, new AddNoteCommand());
        commandMap.put(OperationType.REMOVE, new AddNoteCommand());
        commandMap.put(OperationType.SEARCH, new AddNoteCommand());
        commandMap.put(OperationType.DISPLAY, new DisplayNotebookCommand());
    }

    public static CommandHelper getInstance(){
        return instance;
    }

    public ICommand getCommand(OperationType operationType) {
        ICommand command = null;
        if(commandMap.containsKey(operationType)){
            command = commandMap.get(operationType);
        }
        return command;
    }
}
