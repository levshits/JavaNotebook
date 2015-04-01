package by.bsuir.notebook.logic;

import by.bsuir.notebook.bean.Request;


/**
 * Created by Valentin on 3/19/2015.
 */
public interface ICommand {
    Object execute(Request request) throws LogicException;
}
