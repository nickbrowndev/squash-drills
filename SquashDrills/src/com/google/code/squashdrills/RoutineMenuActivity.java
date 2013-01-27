package com.google.code.squashdrills;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RoutineMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_routine_menu);
		
		Button btnCreate = (Button) findViewById(R.id.btnCreate);
		btnCreate.setClickable(false);
		btnCreate.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("com.google.code.squashdrills", "com.google.code.squashdrills.ConfigurationActivity");
                startActivity(i);
            }
        });
		
		Button btnPlay = (Button) findViewById(R.id.btnPlay);
		btnPlay.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClassName("com.google.code.squashdrills", "com.google.code.squashdrills.PlayRoutineActivity");
                startActivity(i);
            }
        });
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_routine_menu, menu);
		return true;
	}
	
	

}
