package by.bsuir.notebook.dao;

import by.bsuir.notebook.entity.Note;

import java.util.List;

/**
 * Created by Valentin on 3/19/2015.
 */
public interface INotebookDao {
    List<Note> getAllMyNotes();
    List<Note> getAllNotesByDate(String date);
    List<Note> getAllNotesByEmail(String email);
    List<Note> getAllNotesByText(String text);
    List<Note> getAllNotesByTopic(String s);
    boolean writeNote(String topic, String date, String email, String text) throws DaoException;
    boolean removeNoteAt(int index);
}
