package com.example.logger_harmony;


import ohos.app.Context;
import org.jetbrains.annotations.Nullable;

import static com.example.logger_harmony.Utils.checkNotNull;

/**
 * This is used to saves log messages to the disk.
 * By default it uses {@link CsvFormatStrategy} to translates text message into CSV format.
 */
public class DiskLogAdapter implements LogAdapter {

   private final FormatStrategy formatStrategy;

  public DiskLogAdapter(Context context) {
    formatStrategy = CsvFormatStrategy.newBuilder().build(context);
  }

  public DiskLogAdapter( FormatStrategy formatStrategy) {
    this.formatStrategy = checkNotNull(formatStrategy);
  }

  @Override
  public boolean isLoggable(int priority, @Nullable String tag) {
    return true;
  }

  @Override
  public void log(int priority, @Nullable String tag, String message) {
    formatStrategy.log(priority, tag, message);
  }
}
