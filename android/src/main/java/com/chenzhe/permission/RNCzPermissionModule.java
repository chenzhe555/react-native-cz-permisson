
package com.chenzhe.permission;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.tbruyelle.rxpermissions2.RxPermissions;

public class RNCzPermissionModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    private final int YES = 1;
    private final int NO = 2;

    public RNCzPermissionModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNCzPermission";
    }

    @ReactMethod
    public void CheckPushNotification(Callback callback) {
        if (getCurrentActivity() == null) return;
        boolean hasPermission = Utils.hasNotificationPermission(getCurrentActivity());
        if (hasPermission) {
            callback.invoke(YES);
        } else {
            callback.invoke(NO);
        }
    }

    @ReactMethod
    public void OpenPushNotification(Callback callback) {
        if (getCurrentActivity() == null) return;
        boolean canOpen = Utils.openNotificationSetting(getCurrentActivity());
        if (canOpen) {
            callback.invoke(YES);
        } else {
            callback.invoke(NO);
        }
    }

    @ReactMethod
    public void CheckNetwork(Callback callback) {
        if (getCurrentActivity() == null) return;
        boolean hasNetwork = Utils.hasNetwork(getCurrentActivity());
        if (hasNetwork) {
            callback.invoke(YES);
        } else {
            callback.invoke(NO);
        }
    }


    @ReactMethod
    public void OpenNetwork(Callback callback) {
        if (getCurrentActivity() == null) return;
        Utils.openNetwork(getCurrentActivity());
    }

    @ReactMethod
    public void CheckCamera(Callback callback) {
        if (getCurrentActivity() == null) return;
        boolean hasPermission = Utils.hasCameraPermission(getCurrentActivity());
        if (hasPermission) {
            callback.invoke(YES);
        } else {
            callback.invoke(NO);
        }
    }

    @ReactMethod
    public void OpenCamera(Callback callback) {
        if (getCurrentActivity() == null) return;
        Utils.requestPermission(getCurrentActivity(), Utils.PERMISSION_CAMERA, callback);
    }
}