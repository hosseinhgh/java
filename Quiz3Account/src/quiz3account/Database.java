package quiz3account;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private final static String HOSTNAME = "localhost:3333";
    private final static String DBNAME = "quiz3account";
    private final static String USERNAME = "quiz3account";
    private final static String PASSWORD = "K8Xj7WH2v5bm4DN7";

    private Connection conn;

    public Database() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://" + HOSTNAME + "/" + DBNAME,
                USERNAME, PASSWORD);
    }

    public void addTransaction(Transaction t) throws SQLException {
       /* String sql = "INSERT INTO transactino (deposit, withdrawal, transactionDate) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, stock.symbol);
            stmt.setString(2, stock.name);
            stmt.setString(3, stock.price.toPlainString());

            stmt.executeUpdate();
        }*/
    }

    public ArrayList<Transaction> getAllTransaction() throws IOException {
        String sql = "SELECT * FROM transactions";
        ArrayList<Transaction> list = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                BigDecimal d = result.getBigDecimal("deposit");
                BigDecimal w = result.getBigDecimal("withdrawal");
                Date td = new Date(result.getDate("transactionDate").getTime());
                Transaction t = new Transaction(td, d, w);
                list.add(t);
            }
        } catch (SQLException ex) {
            throw new IOException("Error in SQL", ex);
        }
        return list;
    }

    // write SQL query returning ONE value - the total account amount
    public BigDecimal getAccountTotalAmount() throws IOException {
        String sql = "SELECT SUM(deposit) - SUM(withdrawal) as balance FROM transactions";
        try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            result.next();
            return result.getBigDecimal("balance");
        } catch (SQLException ex) {
            throw new IOException("Error in SQL", ex);
        }
    }
}
