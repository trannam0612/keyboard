package com.example.keyboard_test;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import io.flutter.embedding.android.FlutterActivity;
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
    }

    private void helloFromNative() {
        startActivity(new Intent("android.settings.INPUT_METHOD_SETTINGS"));

    }
}
