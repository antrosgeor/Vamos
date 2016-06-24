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

public class List2_user extends ActionBarActivity {

	// Button on list_user.xml
	Button resetButton, backButton, nextButton;

	// EditText on list_user.xml
	EditText Edit_Age, Edit_job, Edit_Money;

	// RadioGroup on list_user.xml
	RadioGroup Edit_Sex, Edit_Family;

	// RadioButton on list_user.xml
	RadioButton radiosex, radiofamily;

	// TextView on list_user.xml
	TextView Sex, Age, Family, job, Money, text, Edit_Text;

	// int checkup .. 2= yes, 1= no.
	int checkup = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list2_user);

		// find button
		nextButton = (Button) findViewById(R.id.Next);
		resetButton = (Button) findViewById(R.id.Reset);
		backButton = (Button) findViewById(R.id.Cancel);

		// public void show()
		show();

		// public void reset()
		reset();

		// public void back()
		back();

		// public void next()
		next();

		// public void onBackPressed()
		onBackPressed();

	}

	// show welcome the user.
	public void show() {
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
		String username = globalVariable.getUsername();

		String show = R.string.welcome + "\n" + username;
		text = (TextView) findViewById(R.id.text);
		text.setText(show);
	}

	@Override
	public void onBackPressed() {
		// Do Here what ever you want do on back press;
		back();
	}

	// back Button(back)
	public void back() {
		backButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent act2 = new Intent(view.getContext(), List_user.class);
				finish();
				startActivity(act2);
			}
		});
	}

	// reset Button(reset)
	public void reset() {
		resetButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// the RadioGroup clear automatical
				Edit_Age = (EditText) findViewById(R.id.Edit_Age);
				Edit_job = (EditText) findViewById(R.id.Edit_job);
				Edit_Money = (EditText) findViewById(R.id.Edit_Money);

				// reset the EditText.
				Edit_Age.setText("");
				Edit_job.setText("");
				Edit_Money.setText("");
			}
		});
	}

	public void next() {
		nextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// Calling Application class (see application tag in
				// AndroidManifest.xml)
				final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

				Age = (EditText) findViewById(R.id.Edit_Age);
				job = (EditText) findViewById(R.id.Edit_job);
				Money = (EditText) findViewById(R.id.Edit_Money);

				// check if the EditText is Empty.
				if (Age.getText().toString().isEmpty()) {
					Toast.makeText(getApplicationContext(),
							R.string.Error_Empty_Age, Toast.LENGTH_SHORT)
							.show();
				} else if (job.getText().toString().isEmpty()) {
					Toast.makeText(getApplicationContext(),
							R.string.Error_Empty_job, Toast.LENGTH_SHORT)
							.show();
				} else if (Money.getText().toString().isEmpty()) {
					Toast.makeText(getApplicationContext(),
							R.string.Error_Empty_Money, Toast.LENGTH_SHORT)
							.show();
				} else {
					// if is not Empty all EditText then >

					String SEX = "noSex";
					String Family = "noFamily";

					// male = 2131296341
					// female = 2131296342
					// String sex = Sex.getText().toString();
					Edit_Sex = (RadioGroup) findViewById(R.id.Edit_Sex);
					int selectedSEX_id = Edit_Sex.getCheckedRadioButtonId();
					radiosex = (RadioButton) findViewById(selectedSEX_id);
					String S = radiosex.getText().toString();
					if (S.equals("Male") || S.equals("Αντρας")) {
						SEX = "Male";
					} else if (S.equals("Female") || S.equals("Γυναίκα")) {
						SEX = "Female";
					} else {
						SEX = "Error";
						// SEX = String.valueOf(selectedSEX_id);
					}

					// String family = Family.getText().toString();
					// family yes = 2131296347
					// family no = 2131296348
					Edit_Family = (RadioGroup) findViewById(R.id.Edit_Family);
					int selectedFAMILY_id = Edit_Family
							.getCheckedRadioButtonId();
					radiofamily = (RadioButton) findViewById(selectedFAMILY_id);
					String Fam = radiofamily.getText().toString();
					if (Fam.equals("Family Yes") || Fam.equals("Δεσμευμενος")) {
						Family = "FamilyYes";
					} else if (Fam.equals("Family No")
							|| Fam.equals("Ελευθερος")) {
						Family = "FamilyNo";
					} else {
						Family = "Error";
					}

					Integer age = Integer.parseInt(Age.getText().toString());
					String jobs = job.getText().toString();
					Integer ney = Integer.parseInt(Money.getText().toString());

					// set all value to Global
					globalVariable.setSex(SEX);
					globalVariable.setAge(age);
					globalVariable.setFamily(Family);
					globalVariable.setjob(jobs);
					globalVariable.setMoney(ney);
					// the checkup is value to show as. if is 1 is install
					// OR if is 2 is update.
					checkup = 1;
					globalVariable.setCheckup(checkup);

					Toast.makeText(getApplicationContext(), R.string.ok,
							Toast.LENGTH_SHORT).show();

					Intent act2 = new Intent(view.getContext(),
							Show_before_install.class);
					finish();
					startActivity(act2);
				}
			}
		});
	}

	//
	// Toast.makeText(getApplicationContext(), R.string.form_name,
	// Toast.LENGTH_SHORT).show();
	//
	// showMessage("Error", "Nothing found");

	// public void showMessage(String title, String Message) {
	// AlertDialog.Builder builder = new AlertDialog.Builder(this);
	// builder.setCancelable(true);
	// builder.setTitle(title);
	// builder.setMessage(Message);
	// builder.show();
	// }

	//
	//
	//
	//
	//

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list2_user, menu);
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