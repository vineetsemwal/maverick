package patterns.observer;

import java.util.ArrayList;
import java.util.List;

class StockObservable implements IStockObservable {
    private List<IStockObserver> observers = new ArrayList<>();
    private Stock stock;

    @Override
    public void add(IStockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void updateStock(Stock stock) {
        this.stock = stock;
        notifyObservers();
    }


    @Override
    public void remove(IStockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.stream().forEach(observer -> observer.update(stock));
    }
}
