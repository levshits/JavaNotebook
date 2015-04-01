package by.bsuir.notebook.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Valentin on 3/18/2015.
 */
public class Note implements Comparable, Serializable {
    private String topic;
    private Date creationDate;
    private String email;
    private String text;

    public Note(String topic, Date creationDate, String email, String text) {
        this.topic = topic;
        this.creationDate = creationDate;
        this.email = email;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public int compareTo(Object o) {
        int result = 0;
        if(o instanceof Note){
            result = this.getCreationDate().compareTo(((Note) o).getCreationDate());
        }
        return result;
    }
}
