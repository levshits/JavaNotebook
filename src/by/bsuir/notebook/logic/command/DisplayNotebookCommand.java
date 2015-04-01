package by.bsuir.notebook.logic.command;

import by.bsuir.notebook.bean.ParametersType;
import by.bsuir.notebook.bean.Request;
import by.bsuir.notebook.dao.DAOFactory;
import by.bsuir.notebook.dao.INotebookDao;
import by.bsuir.notebook.entity.Note;
import by.bsuir.notebook.logic.ICommand;

import java.util.List;

/**
 * Created by Valentin on 3/19/2015.
 */
public class DisplayNotebookCommand implements ICommand {
    @Override
    public Object execute(Request request) {
        List<Note> result = null;
        DAOFactory daoFactory = DAOFactory.getInstance();
        if (daoFactory != null) {
            INotebookDao notebookDao = daoFactory.getNotebookDao();
            if (notebookDao != null) {
                result = notebookDao.getAllMyNotes();
            }
        }
        return result;
    }
}
