
package tododb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Todo {
    private int id;
    private String task;
    private Date dueDate;
    private boolean isDone;

    public Todo(int id, String task, java.sql.Date dueDateSql, String isDoneStr) {
        setId(id);
        setTask(task);
        setDueDate(dueDateSql);
        setIsDone(isDoneStr);
    }
    
    public Todo(int id, String task, String dueDateStr, boolean isDone) {
        setId(id);
        setTask(task);
        setDueDate(dueDateStr);
        setIsDone(isDone);
    }
    
    public Todo(int id, String task, Date dueDate, boolean isDone) {
        setId(id);
        setTask(task);
        setDueDate(dueDate);
        setIsDone(isDone);
    }

    @Override
    public String toString() {
        return "Todo{" + "id=" + id + ", task=" + task + ", dueDate=" + dueDate + ", isDone=" + isDone + '}';
    }
    
    public int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public final void setTask(String task) {
        this.task = task;
    }

    public Date getDueDate() {
        return dueDate;
    }

    // translate java.util.Date into java.sql.Date
    public java.sql.Date getDueDateSql() {
        return new java.sql.Date(dueDate.getTime());
    }

    public String getDueDateString() {
        return dateFormat.format(dueDate);
    }
    
    public final void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    private void setDueDate(String dueDateStr) {
        try {
            dueDate = dateFormat.parse(dueDateStr);
        } catch (ParseException ex) {
            throw new IllegalArgumentException("Due date invalid");
        }
    }

    public boolean isDone() {
        return isDone;
    }

    public String isDoneString() {
        return isDone ? "done" : "pending";
    }
    
    public final void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
    
    public final void setIsDone(String isDoneString) {
        switch (isDoneString) {
            case "done":
                isDone = true;
                break;
            case "pending":
                isDone = false;
                break;
            default:
                throw new IllegalArgumentException("isDone must be done or pending, not " + isDoneString);
        }
    }

    
}
