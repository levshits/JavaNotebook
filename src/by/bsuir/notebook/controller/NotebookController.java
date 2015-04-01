package by.bsuir.notebook.controller;

import by.bsuir.notebook.bean.Request;
import by.bsuir.notebook.logic.ICommand;
import by.bsuir.notebook.logic.LogicException;

/**
 * Created by Valentin on 3/19/2015.
 */
public class NotebookController {
    public Object execute(Request request) throws ControllerException {
        Object response = null;
        CommandHelper helper = CommandHelper.getInstance();
        if(helper!=null){
            ICommand command = helper.getCommand(request.getOperationType());
            if(command!=null){
                try {
                    response = command.execute(request);
                } catch (LogicException e) {
                    throw new ControllerException();
                }
            }
        }
        return response;
    }
}
