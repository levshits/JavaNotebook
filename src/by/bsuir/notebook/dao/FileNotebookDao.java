package by.bsuir.notebook.dao;

import by.bsuir.notebook.entity.Note;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Valentin on 3/19/2015.
 */
public class FileNotebookDao implements INotebookDao {
    private static FileNotebookDao instance = new FileNotebookDao();
    private static final String filename = "storage.xml";
    @Override
    public List<Note> getAllMyNotes() {
        return null;
    }

    @Override
    public List<Note> getAllNotesByDate(String date) {
        return null;
    }

    @Override
    public List<Note> getAllNotesByEmail(String email) {
        return null;
    }

    @Override
    public List<Note> getAllNotesByText(String text) {
        return null;
    }

    @Override
    public List<Note> getAllNotesByTopic(String s) {
        return null;
    }

    @Override
    public boolean writeNote(String topic, String date, String email, String text) throws DaoException {
        try {
            ObjectOutputStream stream = getObjectOutputStream(filename);
            Note note = new Note(topic, new Date(Date.parse(date)), email, text);
            stream.writeObject(note);
            stream.close();
        }catch (IOException ex)
        {
            throw new DaoException();
        }
        return true;
    }

    private ObjectOutputStream getObjectOutputStream(String filename) throws IOException {
        ObjectOutputStream stream =  null;
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = getFileOutputStream(filename);
            stream = new ObjectOutputStream(fileOutputStream);
        }catch (IOException ex)
        {
            if(fileOutputStream != null){
                fileOutputStream.close();
            }
            throw ex;
        }
        return stream;
    }

    private FileOutputStream getFileOutputStream(String filename) throws FileNotFoundException {
        FileOutputStream result = new FileOutputStream(filename, true);
        return result;
    }

    private ObjectInputStream getObjectInputStream(String filename) throws IOException {
        ObjectInputStream stream =  null;
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = getFileStream(filename);
            stream = new ObjectInputStream(fileInputStream);
        }catch (IOException ex)
        {
            if(fileInputStream != null)
            {
                fileInputStream.close();
            }
            throw ex;
        }
        return stream;
    }

    private FileInputStream getFileStream(String filename) throws IOException {
        FileInputStream result = new FileInputStream(filename);
        return result;
    }

    @Override
    public boolean removeNoteAt(int index) {
        return false;
    }


    public static INotebookDao getInstance() {
        return instance;
    }
}
