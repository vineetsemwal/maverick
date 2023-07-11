package patterns.observer;

public class Stock {
    private String stockName;
    private double currentValue;

    public Stock(String stockName, double currentValue) {
        this.stockName = stockName;
        this.currentValue = currentValue;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockName='" + stockName + '\'' +
                ", currentValue=" + currentValue +
                '}';
    }
}
