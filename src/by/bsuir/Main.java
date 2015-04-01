package by.bsuir;

import by.bsuir.notebook.controller.NotebookController;
import by.bsuir.notebook.view.NotebookView;

import java.util.logging.Logger;

public class Main {
    public static final Logger LOG = Logger.getGlobal();
    public static void main(String[] args) {
	// write your code here
        NotebookView view = new NotebookView();
        NotebookController controller = new NotebookController();
        view.setController(controller);
        view.AddNote("Footbal","3/27/2015","user1@email.com","Some stupid text");
        view.DisplayAllNotes();

    }
}
