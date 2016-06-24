package com.example.vamos;

import java.util.Locale;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//The import android.widget.EditText is never used
//import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	DatabaseHelper myDb;

	// Button for activity_main.xml
	Button singupButton, loginButton, eng, gr;
	TextView AppName;
	EditText Edit_email, Edit_pass;
	Context CTX = this;
	ImageView test_image;
	int langpos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// for to see the Database.
		myDb = new DatabaseHelper(this);

		// find from mainactivity.xml
		singupButton = (Button) findViewById(R.id.sing_up);
		loginButton = (Button) findViewById(R.id.log_in);
		gr = (Button) findViewById(R.id.gr);
		eng = (Button) findViewById(R.id.eng);
		Edit_email = (EditText) findViewById(R.id.Edit_Text_email);
		Edit_pass = (EditText) findViewById(R.id.Edit_Text_pass);
		AppName = (TextView) findViewById(R.id.AppName);
		test_image = (ImageView) findViewById(R.id.test_image);

		eng.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				updateconfig("en");
				// changelang(en);
				// Intent act1=new Intent(v.getContext(),MainActivity.class);
				// startActivity(act1);
			}
		});

		gr.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				updateconfig("gr");
				// changelang(gr);
				// Intent act1=new Intent(v.getContext(),MainActivity.class);
				// startActivity(act1);
			}
		});

		// public void sing_up()
		sing_up();
		// public void login()
		login();

		viewAll();
	}

	// go to the List_user
	public void sing_up() {
		singupButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent act2 = new Intent(view.getContext(), List_user.class);
				finish();
				startActivity(act2);
			}
		});
	}

	// to show all data from database.
	public void viewAll() {
		test_image.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Cursor res = myDb.getAllData();
				if (res.getCount() == 0) {
					// show message
					showMessage("Error", "Nothing found");
					return;
				}
				// edo i arithmisi prepi na einia -1 gt 3ekiname apo to 0.
				StringBuffer buffer = new StringBuffer();
				while (res.moveToNext()) {
					buffer.append("Id        : " + res.getString(0) + "\n");
					buffer.append("Username  : " + res.getString(1) + "\n");
					buffer.append("Email     : " + res.getString(2) + "\n");
					buffer.append("Password  : " + res.getString(3) + "\n");
					buffer.append("Sex       : " + res.getString(4) + "\n");
					buffer.append("Age       : " + res.getString(5) + "\n");
					buffer.append("Family    : " + res.getString(6) + "\n");
					buffer.append("Money     : " + res.getString(7) + "\n");
					buffer.append("CheckUp   : " + res.getString(8) + "\n\n\n");
				}
				// show all data
				showMessage("Data", buffer.toString());
			}
		});
	}

	// to show the message.
	public void showMessage(String title, String Message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setCancelable(true);
		builder.setTitle(title);
		builder.setMessage(Message);
		builder.show();
	}

	public void login() {
		loginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

				String userEmail = Edit_email.getText().toString();
				String pass = Edit_pass.getText().toString();
				String USERNAME = "";
				String PASSWORD = "";
				String ID = "";
				String EMAIL = "";
				String SEX = "";
				int AGE;
				String FAMILY = "";
				int MONEY;
				int CHECKUP;

				DatabaseHelper DOP = new DatabaseHelper(CTX);
				Cursor CR = DOP.getInformation(DOP);
				CR.moveToFirst();
				boolean loginstatus = false;
				do {
					if (userEmail.equals(CR.getString(2))
							&& (pass.equals(CR.getString(3)))) {
						loginstatus = true;

						// send all data to Global
						ID = CR.getString(0);
						int IDdata = Integer.parseInt(ID);
						globalVariable.setlog_id(IDdata);

						USERNAME = CR.getString(1);
						globalVariable.setlog_user(USERNAME);

						EMAIL = CR.getString(2);
						globalVariable.setlog_email(EMAIL);

						PASSWORD = CR.getString(3);
						globalVariable.setlog_userpass(PASSWORD);

						SEX = CR.getString(4);
						globalVariable.setlog_sex(SEX);

						AGE = Integer.parseInt(CR.getString(5));
						globalVariable.setlog_age(AGE);

						FAMILY = CR.getString(6);
						globalVariable.setlog_family(FAMILY);

						MONEY = Integer.parseInt(CR.getString(7));
						globalVariable.setlog_money(MONEY);

						CHECKUP = Integer.parseInt(CR.getString(8));
						globalVariable.setlog_checkup(CHECKUP);
					}
				} while (CR.moveToNext());
				if (loginstatus) {

					final String user = globalVariable.getlog_user();
					String us = getResources().getString(R.string.oklogin)
							+ " " + user + " !\n";

					Toast.makeText(getApplicationContext(), us,
							Toast.LENGTH_LONG).show();
					Intent act2 = new Intent(view.getContext(),
							Login_user.class);
					// act2.putExtra("Username", user);
					startActivity(act2);
				} else {
					Toast.makeText(getBaseContext(), R.string.notlogin,
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	public void changelang(View v) {
		switch (langpos) {
		case 0:
			updateconfig("en");
			break;
		case 1:
			updateconfig("gr");
			break;
		}
	}

	public void updateconfig(String s) {
		String languageToload = s;
		Locale locale = new Locale(languageToload);
		Locale.setDefault(locale);
		Configuration config = new Configuration();
		config.locale = locale;
		getBaseContext().getResources().updateConfiguration(config,
				getBaseContext().getResources().getDisplayMetrics());
		// this.setContentView(R.layout.activity_main);
		setTitle(R.string.app_name);
		((Button) findViewById(R.id.sing_up)).setText(R.string.sing_up);
		((Button) findViewById(R.id.log_in)).setText(R.string.log_in);
		((Button) findViewById(R.id.gr)).setText(R.string.gr);
		((Button) findViewById(R.id.eng)).setText(R.string.en);
		((EditText) findViewById(R.id.Edit_Text_email))
				.setHint(R.string.Email_example);
		((EditText) findViewById(R.id.Edit_Text_pass)).setHint(R.string.pass);
		((TextView) findViewById(R.id.AppName)).setText(R.string.app_name);

		// Bundle tempBundle =new Bundle();
		// onCreate(tempBundle);
		// setTitle(R.string.app_name);
		// invalidateOptionsMenu();

	}

}
