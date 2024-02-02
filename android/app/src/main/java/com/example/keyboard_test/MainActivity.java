package com.example.keyboard_test;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {

    private static final String CHANNEL_METHOD = "flutter.native/helper";


    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL_METHOD).setMethodCallHandler((call, result) -> {
            if (call.method.equals("helloFromNative")) {
                helloFromNative();
                result.success("Hellop");
            }
        });

        // Khởi tạo Flutter Engine
        FlutterEngine flutterEngine = new FlutterEngine(this);

        // Đặt tên cho Engine (có thể là bất kỳ chuỗi)
        String engineId = "my_engine_id";

        // Đặt Engine vào bộ nhớ cache
        FlutterEngineCache
                .getInstance()
                .put(engineId, flutterEngine);
    }

    private void helloFromNative() {
        startActivity(new Intent("android.settings.INPUT_METHOD_SETTINGS"));

    }
}
