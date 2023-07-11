package patterns.observer;

public class ObserverUsage {
    public static void main(String[] args) {
        IStockObservable observable=new StockObservable();
        SmallStockDisplay component1=new SmallStockDisplay();
        observable.add(component1);
        BigStockDisplay component2=new BigStockDisplay();
        observable.add(component2);
        Stock stock1=new Stock("tata",1000);
        observable.updateStock(stock1);
        Stock stock2=new Stock("ibm",2000);
        observable.updateStock(stock2);

    }
}
