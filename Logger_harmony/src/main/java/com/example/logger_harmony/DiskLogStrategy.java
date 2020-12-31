package com.example.logger_harmony;


import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;
import ohos.eventhandler.InnerEvent;
import ohos.hiviewdfx.HiLog;
import org.jetbrains.annotations.Nullable;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.example.logger_harmony.Utils.checkNotNull;

/**
 * Abstract class that takes care of background threading the file log operation on Android.
 * implementing classes are free to directly perform I/O operations there.
 * <p>
 * Writes all logs to the disk with CSV format.
 */
public class DiskLogStrategy implements LogStrategy {

    private final EventHandler handler;

    public DiskLogStrategy(EventHandler handler) {
        this.handler = checkNotNull(handler);
    }

    @Override
    public void log(int level, @Nullable String tag, String message) {
        checkNotNull(message);

        InnerEvent event = InnerEvent.get(0, message);
        handler.sendEvent(event);
    }

    static class WriteHandler extends EventHandler {

        private String folder;

        public WriteHandler(EventRunner runner, String filePath) throws IllegalArgumentException {
            super(runner);
            this.folder = filePath;
        }

        @Override
        protected void processEvent(InnerEvent event) {
            super.processEvent(event);
            try {
                String param = event.object.toString();
                FileWriter fileWriter = new FileWriter(folder, true);
                fileWriter.write(param);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
