
package stockpricefetcher;

import java.math.BigDecimal;

public class Stock {
    int id;
    String symbol;
    String name;
    BigDecimal price;

    @Override
    public String toString() {
        return String.format("%s(%s): %s", symbol, name, price);
    }
    
}
