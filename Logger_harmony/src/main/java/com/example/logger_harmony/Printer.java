package com.example.logger_harmony;

import org.jetbrains.annotations.Nullable;

/**
 * A proxy interface to enable additional operations.
 * Contains all possible Log message usages.
 */
public interface Printer {

    void addAdapter(LogAdapter adapter);

    Printer t(@Nullable String tag);

    void d(String message, @Nullable Object... args);

    void d(@Nullable Object object);

    void e(String message, @Nullable Object... args);

    void e(@Nullable Throwable throwable, String message, @Nullable Object... args);

    void w(String message, @Nullable Object... args);

    void i(String message, @Nullable Object... args);

    void i(@Nullable Object object);

    void v(String message, @Nullable Object... args);

    void wtf(String message, @Nullable Object... args);

    /**
     * Formats the given json content and print it
     */
    void json(@Nullable String json);

    /**
     * Formats the given xml content and print it
     */
    void xml(@Nullable String xml);

    void log(int priority, @Nullable String tag, @Nullable String message, @Nullable Throwable throwable);

    void clearLogAdapters();
}
