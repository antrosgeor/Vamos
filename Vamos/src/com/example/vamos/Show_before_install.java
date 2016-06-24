package com.example.vamos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Show_before_install extends ActionBarActivity {
	DatabaseHelper myDb;

	// Buttons
	Button back, Install;
	// static TextView
	TextView Edit_Text, First_Name, Last_Name, Username, Email, Password, Sex,
			Age, Family, job, Money;
	// dynamic TextView
	TextView Edit_First_Name, Edit_Last_Name, Edit_Username, Edit_Email,
			Edit_Password, Edit_Sex, Edit_Age, Edit_Family, Edit_job,
			Edit_Money;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_before_install);
		myDb = new DatabaseHelper(this);

		// dilosi ton Button sto show_before_install.xml
		back = (Button) findViewById(R.id.back);
		Install = (Button) findViewById(R.id.Install);

		// dilosi ton TextView sto show_before_install.xml
		Edit_First_Name = (TextView) findViewById(R.id.Edit_First_Name);
		Edit_Last_Name = (TextView) findViewById(R.id.Edit_Last_Name);
		Edit_Username = (TextView) findViewById(R.id.Edit_Username);
		Edit_Email = (TextView) findViewById(R.id.Edit_Email);
		Edit_Password = (TextView) findViewById(R.id.Edit_Password);
		Edit_Sex = (TextView) findViewById(R.id.Edit_Sex);
		Edit_Age = (TextView) findViewById(R.id.Edit_Age);
		Edit_Family = (TextView) findViewById(R.id.Edit_Family);
		Edit_job = (TextView) findViewById(R.id.Edit_job);
		Edit_Money = (TextView) findViewById(R.id.Edit_Money);

		show();

		back();

		onBackPressed();

		Install();
	}

	@Override
	public void onBackPressed() {
		// Do Here what ever you want do on back press;
		back();
	}

	public void show() {
		// Calling Application class (see application tag in
		// AndroidManifest.xml)
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
		// Get name and email from global/application context
		final String FName = globalVariable.getFirst_Name();
		final String LName = globalVariable.getLast_Name();
		final String Uname = globalVariable.getUsername();
		final String email = globalVariable.getEmail();
		final String pass = globalVariable.getPassword();
		final String sex = globalVariable.getSex();
		final Integer age = globalVariable.getAge();
		final String family = globalVariable.getFamily();
		final String doulia = globalVariable.getjob();
		final Integer money = globalVariable.getMoney();
		// protos tropos ilopiisis ... o defteros einai sto age.
		// String smoney = String.valueOf(money);

		Edit_First_Name.setText(FName);
		Edit_Last_Name.setText(LName);
		Edit_Username.setText(Uname);
		Edit_Email.setText(email);
		Edit_Password.setText(pass);
		Edit_Sex.setText(sex);
		Edit_Age.setText(String.valueOf(age));
		Edit_Family.setText(family);
		Edit_job.setText(doulia);
		Edit_Money.setText(String.valueOf(money));

	}

	public void back() {
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent act2 = new Intent(view.getContext(), List2_user.class);
				startActivity(act2);
			}
		});
	}

	public void Install() {
		Install.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// Calling Application class (see application tag in
				// AndroidManifest.xml)
				final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
				// Get name and email from global/application context
				// final String fname = globalVariable.getFirst_Name();
				// final String lname = globalVariable.getLast_Name();
				final String uname = globalVariable.getUsername();
				final String email = globalVariable.getEmail();
				final String pass = globalVariable.getPassword();
				final String sex = globalVariable.getSex();
				final Integer age = globalVariable.getAge();
				final String family = globalVariable.getFamily();
				final String doulia = globalVariable.getjob();
				final Integer money = globalVariable.getMoney();
				final Integer checkup = globalVariable.getCheckup();

				boolean isInserted = myDb.insertData(uname, email, pass, sex,
						age, family, money, checkup, doulia);
				if (isInserted = true) {
					Toast.makeText(getApplicationContext(),
							R.string.ok_install_data, Toast.LENGTH_SHORT)
							.show();
					// if ok then go to MainActivity.
					Intent act2 = new Intent(view.getContext(),
							MainActivity.class);

					startActivity(act2);

				} else {
					// else show the message.
					Toast.makeText(getBaseContext(),
							R.string.Data_not_Inserted, Toast.LENGTH_LONG)
							.show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_before_install, menu);
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
