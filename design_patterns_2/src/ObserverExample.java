import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Subscriber {
    void update(String news);
}

// Concrete Observers
class EmailSubscriber implements Subscriber {
    private String name;

    public EmailSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news via Email: " + news);
    }
}

class SMSSubscriber implements Subscriber {
    private String name;

    public SMSSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news via SMS: " + news);
    }
}

// Subject Class
class NewsAgency {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String news;

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }

    public void publishNews(String news) {
        this.news = news;
        notifySubscribers();
    }
}

// Client Code
public class ObserverExample {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Subscriber john = new EmailSubscriber("John");
        Subscriber jane = new SMSSubscriber("Jane");

        agency.addSubscriber(john);
        agency.addSubscriber(jane);

        agency.publishNews("Breaking News: Observer Pattern Explained!");
    }
}
