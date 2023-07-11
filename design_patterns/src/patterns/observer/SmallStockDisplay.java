package patterns.observer;

class SmallStockDisplay implements IStockDisplay, IStockObserver {
    @Override
    public void update(Stock stock) {
        display(stock);
    }

    @Override
    public void display(Stock stock) {
        System.out.println("SmallStockdisplay value " + stock);
    }
}