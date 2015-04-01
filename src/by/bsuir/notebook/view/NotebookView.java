package by.bsuir.notebook.view;

import by.bsuir.notebook.bean.OperationType;
import by.bsuir.notebook.bean.ParametersType;
import by.bsuir.notebook.bean.Request;
import by.bsuir.notebook.controller.ControllerException;
import by.bsuir.notebook.controller.NotebookController;
import by.bsuir.notebook.entity.Note;

import java.util.List;
import java.util.Map;

/**
 * Created by Valentin on 3/19/2015.
 */
public class NotebookView {
    private NotebookController controller;

    public void setController(NotebookController controller) {
        this.controller = controller;
    }
    public void DisplayAllNotes(){
        Request request = new Request();
        request.setOperationType(OperationType.DISPLAY);
        if(controller!=null){
            Object response = null;
            try {
                response = controller.execute(request);
                if(response!=null)
                {
                    this.printNotes((List<Note>) response);
                }
            } catch (ControllerException e) {
                e.printStackTrace();
            }
        }
    }

    private void printNotes(List<Note> response) {
        for (Note note: response){
            System.out.println(note.getTopic());
            System.out.println(note.getCreationDate());
            System.out.println(note.getEmail());
            System.out.println(note.getText());
        }
    }

    public void SearchNotesByTopic(String topic){
        Request request = new Request();
        request.setOperationType(OperationType.SEARCH);
        request.setParameter(ParametersType.TOPIC, topic);
        if(controller!=null){
            Object response = null;
            try {
                response = controller.execute(request);
                if(response!=null)
                {
                    this.printNotes((List<Note>) response);
                }
            } catch (ControllerException e) {
                e.printStackTrace();
            }
        }
    }
    public void SearchNotesByEmail(String email) {
        Request request = new Request();
        request.setOperationType(OperationType.SEARCH);
        request.setParameter(ParametersType.EMAIL, email);
        if(controller!=null){
            Object response = null;
            try {
                response = controller.execute(request);
                if(response!=null)
                {
                    this.printNotes((List<Note>) response);
                }
            } catch (ControllerException e) {
                e.printStackTrace();
            }

        }
    }
    public void SearchNotesByText(String text){
        Request request = new Request();
        request.setOperationType(OperationType.SEARCH);
        request.setParameter(ParametersType.TEXT, text);
        if(controller!=null){
            Object response = null;
            try {
                response = controller.execute(request);
                if(response!=null)
                {
                    this.printNotes((List<Note>) response);
                }
            } catch (ControllerException e) {
                e.printStackTrace();
            }

        }
    }
    public void SearchNotesByDate(String date){
        Request request = new Request();
        request.setOperationType(OperationType.SEARCH);
        request.setParameter(ParametersType.CREATION_DATE, date);
        if(controller!=null){
            Object response = null;
            try {
                response = controller.execute(request);
                if(response!=null)
                {
                    this.printNotes((List<Note>) response);
                }
            } catch (ControllerException e) {
                e.printStackTrace();
            }
        }
    }
    public void SearchNotes(Map<ParametersType, String> searchParameters){
        Request request = new Request();
        request.setParameters(searchParameters);
        if(controller!=null){
            Object response = null;
            try {
                response = controller.execute(request);
                if(response!=null)
                {
                    this.printNotes((List<Note>) response);
                }
            } catch (ControllerException e) {
                e.printStackTrace();
            }

        }
    }
    public void AddNote(String topic, String date, String email, String text){
        Request request = new Request();
        request.setOperationType(OperationType.ADD);
        request.setParameter(ParametersType.TEXT, text);
        request.setParameter(ParametersType.EMAIL, email);
        request.setParameter(ParametersType.CREATION_DATE, date);
        request.setParameter(ParametersType.TOPIC, topic);
        if(controller!=null){
            Object response = null;
            try {
                response = controller.execute(request);
                if(response!=null && response instanceof Boolean && (Boolean)response == true){
                    System.out.println("Note successfully added");
                }else {
                    System.out.println("Note adding failure");
                }
            } catch (ControllerException e) {
                e.printStackTrace();
            }

        }
    }
}
