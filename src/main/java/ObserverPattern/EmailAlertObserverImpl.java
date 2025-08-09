package ObserverPattern;

public class EmailAlertObserverImpl  implements  ObserverInterface{

    String emailId;
    StockObservable observable;

    public EmailAlertObserverImpl(String emailId, StockObservable observable){
        this.emailId = emailId;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendEmail(emailId, "Stock updated");
    }

    private void sendEmail(String emailId, String stockUpdated) {
        System.out.println("Mail sent to " + emailId);
    }
}
