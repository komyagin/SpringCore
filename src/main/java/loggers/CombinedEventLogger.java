package loggers;

import beans.Event;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger {
    Collection<EventLogger> loggers;

    @Override
    public void logEvent(Event event) {

    }
}
