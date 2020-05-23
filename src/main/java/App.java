import beans.Client;
import beans.Event;
import loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client client;
    EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) applicationContext.getBean("app");
        app.eventLogger.logEvent((Event) applicationContext.getBean("event"));
        app.eventLogger.logEvent((Event) applicationContext.getBean("event"));
        app.eventLogger.logEvent((Event) applicationContext.getBean("event"));
        app.eventLogger.logEvent((Event) applicationContext.getBean("event"));
        applicationContext.close();
    }


}
