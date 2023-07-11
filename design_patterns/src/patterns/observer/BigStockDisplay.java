package patterns.observer;

class BigStockDisplay implements IStockDisplay, IStockObserver{
    @Override
    public void update(Stock stock) {
         display(stock);
    }

    @Override
    public void display(Stock stock) {
        System.out.println("Big Stock value "+stock);

    }
}
