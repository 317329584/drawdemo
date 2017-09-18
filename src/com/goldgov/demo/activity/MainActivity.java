package com.goldgov.demo.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

import com.goldgov.demo.R;
import com.goldgov.demo.view.DrawableView;
import com.goldgov.demo.view.DrawableViewConfig;

public class MainActivity extends Activity {

  private DrawableView drawableView;
  private DrawableViewConfig config = new DrawableViewConfig();
  private ImageView img; 

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initUi();
  }

  private void initUi() {
    drawableView = (DrawableView) findViewById(R.id.paintView);
    Button strokeWidthMinusButton = (Button) findViewById(R.id.strokeWidthMinusButton);
    Button strokeWidthPlusButton = (Button) findViewById(R.id.strokeWidthPlusButton);
    Button changeColorButton = (Button) findViewById(R.id.changeColorButton);
    Button undoButton = (Button) findViewById(R.id.undoButton);
    img = (ImageView) findViewById(R.id.img);
    
    findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			drawableView.clear();
		}
	});
    findViewById(R.id.getbitmap).setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			img.setImageBitmap(drawableView.obtainBitmap());
		}
	});
    

    config.setStrokeColor(getResources().getColor(android.R.color.black));
    config.setShowCanvasBounds(true);
    config.setStrokeWidth(20.0f);
    config.setMinZoom(1.0f);
    config.setMaxZoom(3.0f);
    config.setCanvasHeight(1080);
    config.setCanvasWidth(1920);
    drawableView.setConfig(config);

    strokeWidthPlusButton.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        config.setStrokeWidth(config.getStrokeWidth() + 10);
      }
    });
    strokeWidthMinusButton.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        config.setStrokeWidth(config.getStrokeWidth() - 10);
      }
    });
    changeColorButton.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        Random random = new Random();
        config.setStrokeColor(
            Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
      }
    });
    undoButton.setOnClickListener(new View.OnClickListener() {

      @Override public void onClick(View v) {
        drawableView.undo();
      }
    });
  }
}
