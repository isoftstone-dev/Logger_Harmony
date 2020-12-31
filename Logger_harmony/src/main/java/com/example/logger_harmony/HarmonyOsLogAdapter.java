package com.example.logger_harmony;


import org.jetbrains.annotations.Nullable;

import static com.example.logger_harmony.Utils.checkNotNull;

/**
 * Android terminal log output implementation for {@link LogAdapter}.
 *
 * Prints output to LogCat with pretty borders.
 *
 * <pre>
 *  ┌──────────────────────────
 *  │ Method stack history
 *  ├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄
 *  │ Log message
 *  └──────────────────────────
 * </pre>
 */
public class HarmonyOsLogAdapter implements LogAdapter {

   private final FormatStrategy formatStrategy;

  public HarmonyOsLogAdapter() {
    this.formatStrategy = PrettyFormatStrategy.newBuilder().build();
  }

  public HarmonyOsLogAdapter(FormatStrategy formatStrategy) {
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
