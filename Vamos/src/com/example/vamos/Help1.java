package com.example.vamos;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class Help1 extends ActionBarActivity {

	Button back;
	TextView text1, text2, text3, text4, text5, text6, text7, text8, text9,
			text10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help1);

		back = (Button) findViewById(R.id.back);
		text1 = (TextView) findViewById(R.id.text1);
		text2 = (TextView) findViewById(R.id.text2);
		text3 = (TextView) findViewById(R.id.text3);
		text4 = (TextView) findViewById(R.id.text4);
		text5 = (TextView) findViewById(R.id.text5);
		text6 = (TextView) findViewById(R.id.text6);
		text7 = (TextView) findViewById(R.id.text7);
		text8 = (TextView) findViewById(R.id.text8);
		text9 = (TextView) findViewById(R.id.text9);
		text10 = (TextView) findViewById(R.id.text10);
		show();
	}

	public void show() {
		// Calling Application class (see application tag in
		// AndroidManifest.xml)
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

		// Get name and email from global/application context
		final String pass = globalVariable.getPassword();
		final String email = globalVariable.getEmail();
		final String FName = globalVariable.getFirst_Name();
		final String LName = globalVariable.getLast_Name();
		final String Uname = globalVariable.getUsername();
		final String sex = globalVariable.getSex();
		final String family = globalVariable.getFamily();
		final String job = globalVariable.getjob();
		final Integer age = globalVariable.getAge();
		final int money = globalVariable.getMoney();

		// String showString = "\n\nName : " + pass + "\n" + "Email : " + email
		// + "\n\n" + "xs :\n\n";

		text1.setText(pass);
		text2.setText(email);
		text3.setText(String.valueOf(money));
		text4.setText(FName);
		text5.setText(LName);
		text6.setText(Uname);
		text7.setText(sex);
		text8.setText(family);
		text9.setText(job);
		text10.setText(String.valueOf(age));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.help1, menu);
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
