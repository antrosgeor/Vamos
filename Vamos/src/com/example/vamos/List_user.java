package com.example.vamos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class List_user extends ActionBarActivity {
	DatabaseHelper myDb;

	// Button on list_user.xml
	Button resetButton, nextButton, backButton;

	// EditText on list_user.xml
	EditText Edit_First_Name, Edit_Last_Name, Edit_Username, Edit_Email,
			Edit_Password, Edit_Re_Password;

	// TextView on list_user.xml
	TextView First_Name, Last_Name, Username, Email, Password, Re_Password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_user);
		myDb = new DatabaseHelper(this);

		// find button
		nextButton = (Button) findViewById(R.id.Next);
		resetButton = (Button) findViewById(R.id.Reset);
		backButton = (Button) findViewById(R.id.Cancel);

		// public void reset()
		reset();

		// public void back()
		back();

		// public void next()
		next();
		// public void onBackPressed()
		onBackPressed();

	}

	@Override
	public void onBackPressed() {
		// Do Here what ever you want do on back press;
		back();
	}

	public void next() {
		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				// Calling Application class (see application tag in
				// AndroidManifest.xml)
				final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

				First_Name = (EditText) findViewById(R.id.Edit_First_Name);
				Last_Name = (EditText) findViewById(R.id.Edit_Last_Name);
				Username = (EditText) findViewById(R.id.Edit_Username);
				Email = (EditText) findViewById(R.id.Edit_Email);
				Password = (EditText) findViewById(R.id.Edit_Password);
				Re_Password = (EditText) findViewById(R.id.Edit_Re_Password);

				// get data for Edit.
				String pass = Password.getText().toString().trim();
				String re_pass = Re_Password.getText().toString().trim();
				String email = Email.getText().toString().trim();

				// test mail - emailPattern
				String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

				if (First_Name.getText().toString().isEmpty()) {
					Toast.makeText(getApplicationContext(),
							R.string.Error_Empty_First_Name, Toast.LENGTH_SHORT)
							.show();
				} else if (Last_Name.getText().toString().isEmpty()) {
					Toast.makeText(getApplicationContext(),
							R.string.Error_Empty_Last_Name, Toast.LENGTH_SHORT)
							.show();
				} else if (Username.getText().toString().isEmpty()) {
					Toast.makeText(getApplicationContext(),
							R.string.Error_Empty_Username, Toast.LENGTH_SHORT)
							.show();
				} else if (Password.getText().toString().isEmpty()) {
					Toast.makeText(getApplicationContext(),
							R.string.Error_Empty_Password, Toast.LENGTH_SHORT)
							.show();
				} else if (Re_Password.getText().toString().isEmpty()) {
					Toast.makeText(getApplicationContext(),
							R.string.Error_Empty_Re_Password,
							Toast.LENGTH_SHORT).show();
				} else if (Email.getText().toString().isEmpty()) {
					Toast.makeText(getApplicationContext(),
							R.string.Error_Empty_Email, Toast.LENGTH_SHORT)
							.show();
				} else if (!(pass.equals(re_pass))) {
					Toast.makeText(getApplicationContext(),
							R.string.Error_Pass_rePass, Toast.LENGTH_SHORT)
							.show();
				} else if (email.matches(emailPattern) && Email.length() > 0) {
					// Error mail - Invalid email address
					Toast.makeText(getApplicationContext(), R.string.ok,
							Toast.LENGTH_SHORT).show();

					String FName = First_Name.getText().toString().trim();
					String LName = Last_Name.getText().toString().trim();
					String UName = Username.getText().toString().trim();

					globalVariable.setFirst_Name(FName);
					globalVariable.setLast_Name(LName);
					globalVariable.setUsername(UName);
					globalVariable.setEmail(email);
					globalVariable.setPassword(pass);
					globalVariable.setRe_Password(re_pass);

					Intent act2 = new Intent(view.getContext(),
							List2_user.class);
					// finish();
					startActivity(act2);

				} else {
					// Error mail - Invalid email address
					Toast.makeText(getApplicationContext(),
							R.string.Error_Email, Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	public void reset() {
		resetButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Edit_First_Name = (EditText) findViewById(R.id.Edit_First_Name);
				Edit_Last_Name = (EditText) findViewById(R.id.Edit_Last_Name);
				Edit_Username = (EditText) findViewById(R.id.Edit_Username);
				Edit_Email = (EditText) findViewById(R.id.Edit_Email);
				Edit_Password = (EditText) findViewById(R.id.Edit_Password);
				Edit_Re_Password = (EditText) findViewById(R.id.Edit_Re_Password);

				Edit_First_Name.setText("");
				Edit_Last_Name.setText("");
				Edit_Username.setText("");
				Edit_Email.setText("");
				Edit_Password.setText("");
				Edit_Re_Password.setText("");
			}
		});
	}

	public void back() {
		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent act2 = new Intent(view.getContext(), MainActivity.class);
				finish();
				startActivity(act2);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_user, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
