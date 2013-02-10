package com.google.code.squashdrills;

import com.google.code.squashdrills.listener.ValueChangeListener;
import com.google.code.squashdrills.runner.CountDownSecondsTimer;
import com.google.code.squashdrills.runner.RoutineCoordinator;
import com.google.code.squashdrills.runner.RoutineRunner;
import com.google.code.squashdrills.sound.SoundManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class PlayRoutineActivity extends Activity  {

	private SoundManager soundManager;
	RoutineCoordinator routine = new RoutineCoordinator();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_routine);
		
		soundManager = new SoundManager(1.0f);
		
		ValueChangeListener<Integer> textValueChangeListener = new ValueChangeListener<Integer>() {

				@Override
				public void notifyValueChanged(Integer value) {
					
					final TextView mainText = (TextView) findViewById(R.id.txtMainText); 
					final int currentValue = value;
					mainText.post(new Runnable() {
						@Override
						public void run() {
							mainText.setText(Integer.toString(currentValue));
						}
					});
			}
		};
		
		routine.addCountdownTimerTickListener(getCountdownBeepListener());
		routine.addCountdownTimerTickListener(textValueChangeListener);
		
		
		routine.addRoutineRunnerNextValueListener(textValueChangeListener);
		routine.addRoutineRunnerNextValueListener(new SpeechGenerator(getApplicationContext()));
		
		findViewById(R.id.btnStart).setClickable(true);
        findViewById(R.id.btnStop).setClickable(false);
		
		Button btnStart = (Button) findViewById(R.id.btnStart);
		btnStart.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	Log.d(this.getClass().getName(), "btnStart Clicked");
                routine.run();
                
                findViewById(R.id.btnStart).setClickable(false);
                findViewById(R.id.btnStop).setClickable(true);
            }
        });
		
		Button btnStop = (Button) findViewById(R.id.btnStop);
		btnStop.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                routine.stop();
                
                findViewById(R.id.btnStart).setClickable(true);
                findViewById(R.id.btnStop).setClickable(false);
            }
        });
	}
	
	private ValueChangeListener<Integer> getCountdownBeepListener() {
		return new ValueChangeListener<Integer>() {

			@Override
			public void notifyValueChanged(Integer value) {
				if (value == 3 || value == 2) {
					soundManager.playCountdownShortBeep();
				} else if (value == 1) {
					soundManager.playCountdownLongBeep();
				}
			}
		};
	}

	
	

}
