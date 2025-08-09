package ObserverPattern;

import java.util.ArrayList;

public class StockObservableImpl implements StockObservable{

    public ArrayList<ObserverInterface> observersList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void addObserver(ObserverInterface observer) {
        observersList.add(observer);
    }

    @Override
    public void removeObserver(ObserverInterface observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(ObserverInterface observer : observersList) {
            observer.update();
        }
    }

    @Override
    public int getData() {
        return stockCount;
    }

    @Override
    public void setData(int newStockCount) {
        if(newStockCount == 0) notifyObservers();
        this.stockCount += newStockCount;
    }
}
