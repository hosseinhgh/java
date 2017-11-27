package stockpricefetcher;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
    // 

    private final static String HOSTNAME = "localhost:3333";
    private final static String DBNAME = "stockpricefetcher";
    private final static String USERNAME = "stockpricefetcher";
    private final static String PASSWORD = "K8Xj7WH2v5bm4DN7";

    private Connection conn;

    public Database() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://" + HOSTNAME + "/" + DBNAME,
                USERNAME, PASSWORD);
    }

    public void addStock(Stock stock) throws SQLException {
        String sql = "INSERT INTO stocks (symbol, name, price) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, stock.symbol);
            stmt.setString(2, stock.name);
            stmt.setString(3, stock.price.toPlainString());

            stmt.executeUpdate();
        }
    }

    public ArrayList<Stock> getAllStocks() throws SQLException {
        String sql = "SELECT * FROM stocks";
        ArrayList<Stock> list = new ArrayList<>();

        try (Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery(sql);
            while (result.next()) {
                Stock stock = new Stock();
                stock.id = result.getInt("id");
                stock.symbol = result.getString("symbol");
                stock.name = result.getString("name");
                stock.price = result.getBigDecimal("price");
                // stock.price = new BigDecimal(result.getString("price"));

                list.add(stock);
            }
        }/*  catch (NumberFormatException e) {
            throw new SQLException("Error parsing price field", e);
        } */
        return list;
    }
    
    public void updateStock(Stock stock) throws SQLException {
        String sql = "UPDATE stocks SET name=?, price=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, stock.name);
            stmt.setString(2, stock.price.toPlainString());
            // where is the last parameter
            stmt.setInt(3, stock.id);
            
            stmt.executeUpdate();
        }
    }
}
