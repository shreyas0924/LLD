package ObserverPattern;

public interface StockObservable {
    public void addObserver(ObserverInterface observer);
    public void removeObserver(ObserverInterface observer);
    public void notifyObservers();
    public int getData();
    public void setData(int data);
}
