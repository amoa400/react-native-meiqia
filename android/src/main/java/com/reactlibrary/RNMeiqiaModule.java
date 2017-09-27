
package com.reactlibrary;

import android.content.Intent;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.meiqia.core.callback.OnInitCallback;
import com.meiqia.meiqiasdk.util.MQConfig;
import com.meiqia.meiqiasdk.util.MQIntentBuilder;

import java.util.HashMap;


public class RNMeiqiaModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNMeiqiaModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNMeiqia";
  }

  @ReactMethod
  public void init(String appKey, final Promise promise) {
    ReactApplicationContext context = getReactApplicationContext();

    MQConfig.init(context, appKey, new OnInitCallback() {
      @Override
      public void onSuccess(String clientId) {
        promise.resolve(clientId);
      }

      @Override
      public void onFailure(int code, String message) {
        promise.reject(message);
      }
    });
  }

  @ReactMethod
  public void start(ReadableMap options) {
    ReactApplicationContext context = getReactApplicationContext();

    HashMap<String, String> clientInfo = new HashMap<>();
    clientInfo.put("name", options.hasKey("name") ? options.getString("name") : options.getString("customizedId"));

    Intent intent = new MQIntentBuilder(context)
            .setCustomizedId(options.getString("customizedId"))
            .setClientInfo(clientInfo)
            .setScheduledGroup(options.hasKey("groupId") ? options.getString("groupId") : null)
            .build();

    context.startActivity(intent);
  }
}