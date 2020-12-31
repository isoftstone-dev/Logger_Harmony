package com.example.logger_harmony;

import org.jetbrains.annotations.Nullable;

/**
 * Used to determine how messages should be printed or saved.
 *
 * @see PrettyFormatStrategy
 * @see CsvFormatStrategy
 */
public interface FormatStrategy {

    void log(int priority, @Nullable String tag, String message);
}
