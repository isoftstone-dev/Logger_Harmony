package com.example.myapplication.slice;

import com.example.logger_harmony.*;
import com.example.myapplication.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.app.Context;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

public class MainAbilitySlice extends AbilitySlice {
    Context context;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        context = this;
        Text text = (Text) findComponentById(ResourceTable.Id_text_helloworld);

        text.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {

                try {
                    Logger.i("需要打印的日志信息");
//                    Logger.i("需要打印的日志信息");
//                    Logger.t("tag标签").i("需要打印的日志信息");
//                    Logger.json("{\"key\": 3, \"value\": something}");

//                    List<Integer> list = new ArrayList<>();
//                    for (int i = 0; i < 5; i++) {
//                        list.add(i);
//                    }
//                    Logger.i(Arrays.asList(list));

//                    FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
//                            .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
//                            .methodCount(0)         // (Optional) How many method line to show. Default 2
//                            .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
//                            .logStrategy(new LogcatLogStrategy()) // (Optional) Changes the log strategy to print out. Default LogCat
//                            .tag("My custom tag")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
//                            .build();
//
//                    Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
//                    Logger.addLogAdapter(new DiskLogAdapter(context));


//                    Logger.i(Arrays.asList(list));

//                    Map<String, String> map = new HashMap<>();
//        map.put("key", "value");
//        map.put("key1", "value2");

//        Logger.d(map);
//                    HiLog.info(label,"info");
//                    HiLog.error(label,"error");
//                    HiLog.fatal(label,"fatal");
//                    HiLog.warn(label,"warn");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
