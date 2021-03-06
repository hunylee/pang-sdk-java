package com.pangdata.sdk.callback;

import java.util.Date;

import com.pangdata.sdk.callback.DataCallback;
import com.pangdata.sdk.domain.Sensor;
import com.pangdata.sdk.util.JsonUtils;

public class StopConditionCallback implements DataCallback<String> {

  private Sensor sensor = new Sensor();

  private int loopCount;

  public StopConditionCallback() {
    this(3);
  }

  public StopConditionCallback(int i) {
    this.loopCount = i;
  }

  public String getData() {
    sensor.setHumidity((int) (Math.random() * 30 + 30));
    sensor.setTemperature((int) (Math.random() * 20 + 20));
    sensor.setTimeStamp(new Date());
    return JsonUtils.convertObjToJsonStr(sensor);
  }

  public boolean isRunning(int count) {
    return count <= loopCount;
  }

  public void onSuccess(String data) {}
};
