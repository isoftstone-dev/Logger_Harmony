package com.example.myapplication;

import com.example.logger_harmony.BuildConfig;
import com.example.logger_harmony.HarmonyOsLogAdapter;
import com.example.logger_harmony.Logger;
import ohos.aafwk.ability.AbilityPackage;

public class MyApplication extends AbilityPackage {
    @Override
    public void onInitialize() {
        super.onInitialize();

        Logger.addLogAdapter(new HarmonyOsLogAdapter() {
            @Override
            public boolean isLoggable(int priority, @org.jetbrains.annotations.Nullable String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }
}
