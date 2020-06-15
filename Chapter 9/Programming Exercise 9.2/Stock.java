
/**
 * (The Stock class) Following the example of the Circle class in Section 9.2,
 * design a class named Stock that contains:
 *
 * ■ A string data field named symbol for the stock’s symbol.
 * ■ A string data field named name for the stock’s name.
 * ■ A double data field named previousClosingPrice that stores the stock
 * price for the previous day.
 * ■ A double data field named currentPrice that stores the stock price for the
 * current time.
 * ■ A constructor that creates a stock with the specified symbol and name.
 * ■ A method named getChangePercent() that returns the percentage changed
 * from previousClosingPrice to currentPrice.
 *
 * Draw the UML diagram for the class and then implement the class. Write a test
 * program that creates a Stock object with the stock symbol ORCL, the name
 * Oracle Corporation, and the previous closing price of 34.5. Set a new current
 * price to 34.35 and display the price-change percentage.
 *
 * @author martinfall
 */
public class Stock {

    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        Stock oracle = new Stock("ORCL", "Oracle Corporation");
        oracle.setPreviousClosingPrice(34.5);
        oracle.setCurrentPrice(34.35);
        System.out.println("Price-change percentage: " + oracle.getChangePercent());
    }

    // A string data field named symbol for the oracle’s symbol.
    private String symbol;
    // A string data field named name for the oracle’s name.
    private String name;
    // A double data field named previousClosingPrice that stores the oracle price 
    // for the previous day.
    private double previousClosingPrice;
    // A double data field named currentPrice that stores the oracle price for the
    // current time.
    private double currentPrice;

    // A constructor that creates a oracle with the specified symbol and name.
    public Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    // A method named getChangePercent() that returns the percentage changed
    // from previousClosingPrice to currentPrice.
    public double getChangePercent() {
        return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
    }
    // Setters

    // Mutator method for previousClosingPrice
    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    // Mutator method for currentPrice
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

}
