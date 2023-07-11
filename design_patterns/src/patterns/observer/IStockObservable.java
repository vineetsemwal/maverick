package patterns.observer;

interface IStockObservable {
    void add(IStockObserver observer);
    void remove(IStockObserver observer);
    void notifyObservers();


    void updateStock(Stock stock);

}
