package stockpricefetcher;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class YahooApi {
    
    public static Stock getStockBySymbol(String symbol) throws IOException {
        try {
            String url = String.format("http://download.finance.yahoo.com/d/quotes.csv?s=%s&f=nl1", symbol);
            String data = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
            System.out.printf("URL result for %s was: %s", symbol, data); // make debugging easier
            Stock stock = new Stock();
            String [] dataArray = data.split(","); // FIXME: doesn't handle stock names with a comma in them!            
            if (dataArray.length != 2) throw new IOException("Error in data, must have 2 fields only: " + data);
            stock.name = dataArray[0];
            stock.price = new BigDecimal(dataArray[1].trim()); // may throw NumberFormatException
            return stock;
        } catch (MalformedURLException | NoSuchElementException | NumberFormatException  ex) {
            throw new IOException("Error fetching data from Yahoo API for " + symbol, ex);
        }
    }
    
}
