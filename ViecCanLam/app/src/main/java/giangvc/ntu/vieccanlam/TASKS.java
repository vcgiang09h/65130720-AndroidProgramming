package giangvc.ntu.vieccanlam;

import java.io.Serializable;
import java.util.HashMap;

public class TASKS implements Serializable {
    String name;
    String date;
    String message;
    long priority;   // Lưu là số nguyên trên Firebase

    public TASKS(String name, String date, String message, long priority) {
        this.name = name;
        this.date = date;
        this.message = message;
        this.priority = priority;
    }
    public TASKS() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public HashMap<String, Object> toFirebaseOject(){

        HashMap<String, Object> taskObject =
                new HashMap<String, Object>();

        taskObject.put("name", name);
        taskObject.put("date", date);
        taskObject.put("message", message);
        taskObject.put("priority", priority);  // lưu là số nguyên

        return taskObject;
    }
}

