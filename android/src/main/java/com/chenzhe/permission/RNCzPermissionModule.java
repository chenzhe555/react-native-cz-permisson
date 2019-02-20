
package com.chenzhe.permission;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNCzPermissionModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNCzPermissionModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNCzPermission";
  }
}