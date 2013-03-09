package com.example.homework6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IndexActivity extends Activity {

	private Button btn1;
	private Button btn2;
	private Button btn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		ini();
		set();

	}

	private void ini() {
		btn1 = (Button) findViewById(R.id.button1);
		btn2 = (Button) findViewById(R.id.button2);
		btn3 = (Button) findViewById(R.id.button3);
	}

	private void set() {
		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				start(Ex1Activity.class);
			}
		});

		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				start(Ex2Activity.class);
			}
		});

		btn3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				start(Ex3Activity.class);
			}
		});
	}
	
	private void start(Class cls) {
		Intent intent = new Intent(IndexActivity.this,cls);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.index, menu);
		return true;
	}

}
