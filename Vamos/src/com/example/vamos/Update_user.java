package com.example.vamos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Update_user extends ActionBarActivity {
	// see database name myDb.
	DatabaseHelper myDb;

	// TextView from update_user.xml
	TextView text, Edit_Text, Age, Family, job, Money;

	// Button from update_user.xml
	Button backButton, resetButton, updateButton;

	// RadioGroup on list_user.xml
	RadioGroup Edit_Family;

	// RadioButton on list_user.xml
	RadioButton radiofamily;

	// EditText from update_user.xml
	EditText Edit_Age, Edit_job, Edit_Money;

	// int
	int checkup = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update_user);
		// for to see the Database.
		myDb = new DatabaseHelper(this);

		backButton = (Button) findViewById(R.id.Back);
		resetButton = (Button) findViewById(R.id.Reset);
		updateButton = (Button) findViewById(R.id.Update);

		show();
		// public void Resat()
		Resat();
		// public void Back()
		Back();
		// public void Update()
		Update();

		onBackPressed();

	}

	public void show() {

		final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
		final String user = globalVariable.getlog_user();

		String show = getResources().getString(R.string.welcome) + "\n" + user;
		text = (TextView) findViewById(R.id.text);
		text.setText(show);
	}

	public void runget() {
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

		Age = (EditText) findViewById(R.id.Edit_Age);
		job = (EditText) findViewById(R.id.Edit_job);
		Money = (EditText) findViewById(R.id.Edit_Money);

		// Set to globalClass.java

		String Family = "noFamily";

		// String family = Family.getText().toString();
		// family yes = 2131296347
		// family no = 2131296348
		Edit_Family = (RadioGroup) findViewById(R.id.Edit_Family);
		int selectedFAMILY_id = Edit_Family.getCheckedRadioButtonId();
		radiofamily = (RadioButton) findViewById(selectedFAMILY_id);
		String Fam = radiofamily.getText().toString();
		if (Fam.equals("Family Yes") || Fam.equals("Δεσμευμενος")) {
			Family = "FamilyYes";
			globalVariable.setFamily(Family);
		} else if (Fam.equals("Family No") || Fam.equals("Ελευθερος")) {
			Family = "FamilyNo";
			globalVariable.setFamily(Family);
		} else {
			Family = "Error";
			globalVariable.setFamily(Family);
		}

		if (!(Age.getText().toString().isEmpty())) {
			Integer age = Integer.parseInt(Age.getText().toString());
			globalVariable.setAge(age);
		}
		if (!(job.getText().toString().isEmpty())) {
			String jobs = job.getText().toString();
			globalVariable.setjob(jobs);
		}
		if (!(Money.getText().toString().isEmpty())) {
			Integer money = Integer.parseInt(Money.getText().toString());
			globalVariable.setMoney(money);
		}

		checkup = 2;
		globalVariable.setCheckup(checkup);

		Toast.makeText(getApplicationContext(), R.string.ok_update,
				Toast.LENGTH_SHORT).show();
	}

	public void Update() {
		updateButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				runget();

				final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

				final Integer age = globalVariable.getAge();
				final String family = globalVariable.getFamily();
				// final String jobs = globalVariable.getjob();
				final Integer money = globalVariable.getMoney();
				final Integer checkup = globalVariable.getCheckup();

				final String user = globalVariable.getlog_user();

				// TODO Auto-generated method stub
				boolean isUpdate = myDb.updateData(user, age, family, money,
						checkup);
				if (isUpdate = true) {
					Toast.makeText(getApplicationContext(),
							R.string.DataisUpDate, Toast.LENGTH_LONG).show();
					int again = 1;
					globalVariable.setupdatetest(again);
					Intent act2 = new Intent(v.getContext(), Login_user.class);
					finish();
					startActivity(act2);
				} else
					Toast.makeText(getApplicationContext(),
							R.string.DatanotUpdate, Toast.LENGTH_LONG).show();
			}
		});
	}

	public void Resat() {
		resetButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Edit_Age = (EditText) findViewById(R.id.Edit_Age);
				Edit_job = (EditText) findViewById(R.id.Edit_job);
				Edit_Money = (EditText) findViewById(R.id.Edit_Money);

				Edit_Age.setText("");
				Edit_job.setText("");
				Edit_Money.setText("");
			}
		});
	}

	@Override
	public void onBackPressed() {
		Back();
	}

	public void Back() {
		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent act2 = new Intent(v.getContext(), Login_user.class);
				finish();
				startActivity(act2);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update_user, menu);
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