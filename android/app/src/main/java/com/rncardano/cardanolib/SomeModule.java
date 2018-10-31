package com.rncardano.cardanolib;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class SomeModule extends ReactContextBaseJavaModule {
    static {
        System.loadLibrary("cardano_c");
    }
    public SomeModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "SomeModule";
    }

    private static native String greeting(String pattern);

    @ReactMethod
    public void show(String message) {
        System.out.println(message);
    }
    @ReactMethod
    public void invokeR(String message) {
        System.out.println("abc invoke r: " + message);
        System.out.println(greeting(message));
    }
}
