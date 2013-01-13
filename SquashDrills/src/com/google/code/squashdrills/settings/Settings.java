package com.google.code.squashdrills.settings;

import com.google.code.squashdrills.exception.configuration.UninitialisedConfigurationException;

import android.content.SharedPreferences;

public class Settings {
	
	/*
	 * Static
	 */
	private static Settings settings;
	
	public static Settings getSettings() {
		if (settings == null) {
			throw new UninitialisedConfigurationException("getSettings() has been called when settings haven't been initialised");
		}
		return settings;
	}
	
	public static void initSettings(SharedPreferences preferences) {
		settings = new Settings(preferences);
	}
	
	/* 
	 * Instance
	 */
	private SharedPreferences preferences;
	
	private Settings(SharedPreferences preferences) {
		this.preferences = preferences;
		this.loadSettings();
	}
	
	

	private void loadSettings() {
		
	}

	public void save() {

		SharedPreferences.Editor editor = preferences.edit();
		editor.commit();

	}
}
