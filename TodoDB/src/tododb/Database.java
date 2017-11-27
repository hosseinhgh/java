package tododb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
    private final static String HOSTNAME = "localhost:3333";
    private final static String DBNAME = "tododb";
    private final static String USERNAME = "tododb";
    private final static String PASSWORD = "SeHmjtwGjrVJBAqA";

    private Connection conn;
    
    public Database() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://" + HOSTNAME + "/" + DBNAME,
                USERNAME, PASSWORD);        
    }
    
    public void addTodo(Todo todo) throws SQLException {
        String sql = "INSERT INTO todos (task, dueDate, isDone) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, todo.getTask());
            stmt.setDate(2, todo.getDueDateSql());
            stmt.setString(3, todo.isDoneString());
            
            stmt.executeUpdate();
        }
    }
    
    public ArrayList<Todo> getAllTodos() throws SQLException {
        String sql = "SELECT * FROM todos";
        ArrayList<Todo> list = new ArrayList<>();
        
        try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("id");
                String task = result.getString("task");
                java.sql.Date dueDateSql = result.getDate("dueDate");
                String isDoneStr = result.getString("isDone");
                Todo todo = new Todo(id, task, dueDateSql, isDoneStr);
                list.add(todo);
            }
        }
        return list;
    }
    
    public Todo getTodoById(int id) throws SQLException {
        // FIXME: Preapred statement is required if id may contain malicious SQL injection code
        String sql = "SELECT * FROM todos WHERE id=" + id;
        
        try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            if (result.next()) {
                String task = result.getString("task");
                java.sql.Date dueDateSql = result.getDate("dueDate");
                String isDoneStr = result.getString("isDone");
                Todo todo = new Todo(id, task, dueDateSql, isDoneStr);
                return todo;
            } else {
                throw new SQLException("Record not found");
                //return null;
            }
        }
    }
    
    public void updateTodo(Todo todo) throws SQLException {
        String sql = "UPDATE todos SET task=?, dueDate=?, isDone=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, todo.getTask());
            stmt.setDate(2, todo.getDueDateSql());
            stmt.setString(3, todo.isDoneString());
            // where is the last parameter
            stmt.setInt(4, todo.getId());
            
            stmt.executeUpdate();
        }
    }
    
    public void deleteTodoById(int id) throws SQLException {
        String sql = "DELETE FROM todos WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);            
            stmt.executeUpdate();
        }
    }

   
}
