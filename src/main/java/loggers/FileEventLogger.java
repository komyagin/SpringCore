package loggers;

import beans.Event;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    protected File file;
    protected String fileName;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) {
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.append(event.toString()).append("\n");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void init() {
        this.file = new File(fileName);
    }
}
