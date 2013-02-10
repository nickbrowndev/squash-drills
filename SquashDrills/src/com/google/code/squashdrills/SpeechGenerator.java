package com.google.code.squashdrills;

import java.util.Locale;

import com.google.code.squashdrills.listener.ValueChangeListener;

import android.content.Context;
import android.content.Intent;

import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.widget.Toast;
public class SpeechGenerator implements ValueChangeListener<Integer> {
	
	private TextToSpeech tts;
	private boolean ttsInitiated = false;
	
	public SpeechGenerator(final Context applicationContext) {
		
		tts = new TextToSpeech(applicationContext, new OnInitListener() {
			
			@Override
			public void onInit(int status) {
				switch (status) {
					case TextToSpeech.SUCCESS: ttsInitiated = true; break;
					default : Toast.makeText(applicationContext, "Failed to initialise Text-To-Speech", 3 ).show(); break;
				}
			}
		});
		tts.setLanguage(Locale.UK);
	}
	@Override
	public void notifyValueChanged(Integer value) {
		if (ttsInitiated) {
			tts.speak(String.valueOf(value), TextToSpeech.QUEUE_FLUSH, null);
		}
	}

}
