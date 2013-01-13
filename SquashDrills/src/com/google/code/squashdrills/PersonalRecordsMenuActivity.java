package com.google.code.squashdrills;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PersonalRecordsMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_records_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_personal_records_menu,
				menu);
		return true;
	}

}
