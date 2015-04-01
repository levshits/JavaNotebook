package by.bsuir.notebook.logic.command;

import by.bsuir.notebook.bean.ParametersType;
import by.bsuir.notebook.bean.Request;
import by.bsuir.notebook.dao.DAOFactory;
import by.bsuir.notebook.dao.DaoException;
import by.bsuir.notebook.dao.INotebookDao;
import by.bsuir.notebook.logic.ICommand;
import by.bsuir.notebook.logic.LogicException;

/**
 * Created by Valentin on 3/19/2015.
 */
public class AddNoteCommand implements ICommand {
    @Override
    public  Object execute(Request request) throws LogicException {
        boolean result = false;
        DAOFactory daoFactory = DAOFactory.getInstance();
        if (daoFactory != null) {
            INotebookDao notebookDao = daoFactory.getNotebookDao();
            if (notebookDao != null) {

                try {
                    result = notebookDao.writeNote(
                            request.getParameter(ParametersType.TOPIC),
                            request.getParameter(ParametersType.CREATION_DATE),
                            request.getParameter(ParametersType.EMAIL),
                            request.getParameter(ParametersType.TEXT));
                } catch (DaoException e) {
                    throw new LogicException();
                }
            }
        }
        return result;
    }
    }

