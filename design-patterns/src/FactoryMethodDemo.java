interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending EMAIL notification");
    }
}

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending SMS notification");
    }
}

// Creator (abstract)
abstract class NotificationService {

    // factory method
    protected abstract Notification createNotification();

    // template method using product
    public void send() {
        Notification n = createNotification();
        n.notifyUser();
    }
}

// Concrete creators
class EmailNotificationService extends NotificationService {
    protected Notification createNotification() {
        return new EmailNotification();
    }
}

class SMSNotificationService extends NotificationService {
    protected Notification createNotification() {
        return new SMSNotification();
    }
}

public class FactoryMethodDemo {
    public static void main(String[] args) {
        NotificationService service = new EmailNotificationService();
        service.send();   // internally creates EmailNotification
    }
}
