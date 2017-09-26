
package com.reactlibrary;

import android.content.Intent;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.meiqia.core.callback.OnInitCallback;
import com.meiqia.meiqiasdk.util.MQConfig;
import com.meiqia.meiqiasdk.util.MQIntentBuilder;


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
  public void init() {
    ReactApplicationContext context = getReactApplicationContext();

    MQConfig.init(context, "Your Appkey", new OnInitCallback() {
      @Override
      public void onSuccess(String clientId) {
        ReactApplicationContext context = getReactApplicationContext();
        Toast.makeText(context, "init success", Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onFailure(int code, String message) {
        ReactApplicationContext context = getReactApplicationContext();
        Toast.makeText(context, "int failure", Toast.LENGTH_SHORT).show();
      }
    });
  }

  @ReactMethod
  public void start() {
    ReactApplicationContext context = getReactApplicationContext();
    Intent intent = new MQIntentBuilder(context).build();
    context.startActivity(intent);
  }
}