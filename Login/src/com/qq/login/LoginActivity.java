package com.qq.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	private EditText edit_username = null;
	private EditText edit_password = null;
	private Button btn_submit = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		edit_username = (EditText) findViewById(R.id.username);
		edit_password = (EditText) findViewById(R.id.password);
		btn_submit = (Button) findViewById(R.id.submit);

		btn_submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String username = edit_username.getText().toString();
				String password = edit_password.getText().toString();
				Intent intent = new Intent(LoginActivity.this,
						ResultActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("username", username);
				bundle.putString("password", password);
				intent.putExtras(bundle);
				startActivity(intent);

				setTitle(password + username);

			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}

}
