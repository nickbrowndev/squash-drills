package com.google.code.squashdrills;

import com.google.code.squashdrills.listener.ValueChangeListener;
import com.google.code.squashdrills.runner.RoutineRunner;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class PlayRoutineActivity extends Activity implements ValueChangeListener  {

	private RoutineRunner runner = new RoutineRunner(null);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_routine);
		
		runner.addValueChangeListener(this);
		runner.addValueChangeListener(new SpeechGenerator(getApplicationContext()));
		
		findViewById(R.id.btnStart).setClickable(true);
        findViewById(R.id.btnStop).setClickable(false);
		
		Button btnStart = (Button) findViewById(R.id.btnStart);
		btnStart.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	Log.d(this.getClass().getName(), "btnStart Clicked");
                runner.start();
                
                findViewById(R.id.btnStart).setClickable(false);
                findViewById(R.id.btnStop).setClickable(true);
            }
        });
		
		Button btnStop = (Button) findViewById(R.id.btnStop);
		btnStop.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                runner.stop();
                
                findViewById(R.id.btnStart).setClickable(true);
                findViewById(R.id.btnStop).setClickable(false);
            }
        });
	}

	@Override
	public void notifyValueChanged(int value) {
		
		final TextView mainText = (TextView) findViewById(R.id.txtMainText); 
		final int currentValue = value;
		
		mainText.post(new Runnable() {

			@Override
			public void run() {
				mainText.setText(Integer.toString(currentValue));
			}
		});
		
	}

}
