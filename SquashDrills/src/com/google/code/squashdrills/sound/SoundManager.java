package com.google.code.squashdrills.sound;

import com.google.code.squashdrills.R;

import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;

public class SoundManager {

	private SoundPool soundPool;
	private boolean soundPoolInitialised = false;
	private final String COUNTDOWN_BEEP_SHORT = "assets/sounds/countdown_beep_25ms.mp3";
	private final String COUNTDOWN_BEEP_LONG = "assets/sounds/countdown_beep_50ms.mp3";
	final int COUNTDOWN_BEEP_SHORT_ID;
	final int COUNTDOWN_BEEP_LONG_ID;
	
	private float volume;
	
	public SoundManager(float volume) {
		soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
	    soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
			
	      @Override
	      public void onLoadComplete(SoundPool soundPool, int soundId,
	          int status) {
	    	  switch (status) {
	    	  	case 0 : soundPoolInitialised = true; break;
	    	  }
	      }
	    });
	    
	    // Pre-initialise sounds
	    COUNTDOWN_BEEP_SHORT_ID = soundPool.load(COUNTDOWN_BEEP_SHORT, 1);
	    COUNTDOWN_BEEP_LONG_ID = soundPool.load(COUNTDOWN_BEEP_LONG, 1);
	}
	
	private void playSound(int soundId) {
		if (soundPoolInitialised) {
		soundPool.play(soundId, volume, volume, 1, 0, 1.0f);
		} else {
			throw new RuntimeException("Attempted to run sound while sound pool not initialised");
		}
	    
	}
	
	public void playCountdownLongBeep() {
		playSound(COUNTDOWN_BEEP_LONG_ID);
	}
	
	public void playCountdownShortBeep() {
		playSound(COUNTDOWN_BEEP_SHORT_ID);
	}
	
}
