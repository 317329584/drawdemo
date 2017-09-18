package com.goldgov.demo.view.gestures.creator;

import com.goldgov.demo.view.draw.SerializablePath;


public interface GestureCreatorListener {
  void onGestureCreated(SerializablePath serializablePath);

  void onCurrentGestureChanged(SerializablePath currentDrawingPath);
}
