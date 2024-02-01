package com.example.keyboard_test;

import android.inputmethodservice.InputMethodService;
import android.view.View;

import io.flutter.embedding.android.FlutterActivity;


public class ShareInputMethodServices extends InputMethodService {

    @Override
    public View onCreateInputView() {
        return getLayoutInflater().inflate(R.layout.keyboard_main, null);
    }
}
