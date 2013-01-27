package com.google.code.squashdrills;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenuActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainmenu);
		
		Button btnConfiguration = (Button) findViewById(R.id.navConfiguration);
		btnConfiguration.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("com.google.code.squashdrills", "com.google.code.squashdrills.ConfigurationActivity");
                startActivity(i);
            }
        });
		
		Button btnRoutineMenu = (Button) findViewById(R.id.navRoutineMenu);
		btnRoutineMenu.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("com.google.code.squashdrills", "com.google.code.squashdrills.RoutineMenuActivity");
                startActivity(i);
            }
        });
		
		/*Button btnPersonalRecords = (Button) findViewById(R.id.navPersonalRecordsMenu);
		btnPersonalRecords.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("com.google.code.squashdrills", "com.google.code.squashdrills.PersonalRecordsMenuActivity");
                startActivity(i);
            }
        });*/
	}
	
	@Override
	protected void onStop(){
		super.onStop();
	}
}
