package by.bsuir.notebook.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valentin on 3/18/2015.
 */
public class Notebook {
    private List<Note> notes = new LinkedList<Note>();

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
