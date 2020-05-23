package loggers;

import beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    List<Event> cache;

    CacheFileEventLogger(int cacheSize, String fileName) {
        super(fileName);
        this.cacheSize = cacheSize;
        cache = new ArrayList<Event>();
    }

    @Override
    public void logEvent(Event event) {
        System.out.println(event);
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        for (Event event : cache) {
            System.out.println(event);
            super.logEvent(event);
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
