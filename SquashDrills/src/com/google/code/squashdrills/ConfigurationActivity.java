package com.google.code.squashdrills;

import java.util.List;

import com.google.code.squashdrills.settings.Settings;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class ConfigurationActivity extends PreferenceActivity {

	private Settings settings;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		settings.initSettings(this.getPreferences(MODE_PRIVATE));
	}
    
    @Override
    protected void onPause() {
    	super.onPause();
    	saveSettings();
    }
	
	@Override
	protected void onStop() {
		super.onStop();
		saveSettings();
	}
	
	private void saveSettings() {
		settings.save();
	}
}
