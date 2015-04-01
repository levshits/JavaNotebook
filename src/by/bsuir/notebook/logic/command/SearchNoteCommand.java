package by.bsuir.notebook.logic.command;

import by.bsuir.notebook.bean.ParametersType;
import by.bsuir.notebook.bean.Request;
import by.bsuir.notebook.dao.DAOFactory;
import by.bsuir.notebook.dao.INotebookDao;
import by.bsuir.notebook.entity.Note;
import by.bsuir.notebook.logic.ICommand;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Valentin on 3/19/2015.
 */
public class SearchNoteCommand implements ICommand {
    @Override
    public Object execute(Request request){
        List<Note> result = search(request.getParameters());
        return result;
    }
    private static List<Note> search(Map<ParametersType, String> searchParameters){
        List<Note> result = null;
        if(searchParameters.containsKey(ParametersType.CREATION_DATE))
        {
            result = searchByCreationDate(result, searchParameters.get(ParametersType.CREATION_DATE));
        }
        if(result.size()>0 && searchParameters.containsKey(ParametersType.EMAIL))
        {
            result = searchByEmail(result, searchParameters.get(ParametersType.EMAIL));
        }
        if(result.size()>0 && searchParameters.containsKey(ParametersType.TOPIC))
        {
            result = searchByTopic(result, searchParameters.get(ParametersType.TOPIC));
        }
        if(result.size()>0 && searchParameters.containsKey(ParametersType.TEXT))
        {
            result = searchByText(result, searchParameters.get(ParametersType.TEXT));

        }
        return result;
    }

    private static List<Note> searchByText(List<Note> notes, String s) {
        if(notes==null){
            notes = DAOFactory.getInstance().getNotebookDao().getAllNotesByText(s);
        }
        List<Note> result = new LinkedList<Note>();
        for (Note note: notes)
        {

        }
        return result;
    }

    private static List<Note> searchByTopic(List<Note> notes, String s) {
        if(notes==null){
            notes = DAOFactory.getInstance().getNotebookDao().getAllNotesByTopic(s);
        }
        List<Note> result = new LinkedList<Note>();
        return result;
    }

    private static List<Note> searchByEmail(List<Note> notes, String s) {
        if(notes==null){
            notes = DAOFactory.getInstance().getNotebookDao().getAllNotesByEmail(s);
        }
        List<Note> result = new LinkedList<Note>();
        return result;
    }

    private static List<Note> searchByCreationDate(List<Note> notes, String s) {
        if(notes==null){
            notes = DAOFactory.getInstance().getNotebookDao().getAllNotesByDate(s);
        }
        List<Note> result = new LinkedList<Note>();
        return result;
    }
}
