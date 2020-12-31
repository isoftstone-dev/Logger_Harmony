package com.example.logger_harmony;

import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;
import org.jetbrains.annotations.Nullable;

import static com.example.logger_harmony.Utils.checkNotNull;

/**
 * LogCat implementation for {@link LogStrategy}
 * <p>
 * This simply prints out all logs to Logcat by using standard {@link} class.
 */
public class LogcatLogStrategy implements LogStrategy {

    static final String DEFAULT_TAG = "NO_TAG";


    @Override
    public void log(int priority, @Nullable String tag, String message) {
        checkNotNull(message);

        if (tag == null) {
            tag = DEFAULT_TAG;
        }
        HiLogLabel label = new HiLogLabel(HiLog.LOG_APP, 0x00201, tag);

//        public static final int DEBUG = 3;
//        public static final int INFO = 4;
//        public static final int WARN = 5;
//        public static final int ERROR = 6;
//        public static final int ASSERT = 7;


        switch (priority) {
            case Logger.DEBUG:
                HiLog.debug(label, message);
                break;
            case Logger.INFO:
                HiLog.info(label, message);
                break;
            case Logger.WARN:
                HiLog.warn(label, message);
                break;
            case Logger.ERROR:
                HiLog.error(label, message);
                break;
            case Logger.ASSERT:
                HiLog.fatal(label, message);
                break;

        }
    }
}
