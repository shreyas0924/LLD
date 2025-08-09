package ObserverPattern;

public class PhoneAlertObserverImpl implements ObserverInterface{
    int mobileNumber;
    StockObservable observable;
    public PhoneAlertObserverImpl(int mobileNumber, StockObservable observable){
        this.mobileNumber = mobileNumber;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendSms(mobileNumber, "Stock updated sms");
    }

    public void sendSms(int mobileNumber, String msg){
        System.out.println(msg + " sent to " + mobileNumber);
    }
}
