package com.example.vamos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Show_before_test extends Activity {
	Button Next, Back;
	TextView textView, Dear_User;
	ImageView Test_Image;
	int x;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_before_test);

		Next = (Button) findViewById(R.id.Next);
		Back = (Button) findViewById(R.id.Back);
		textView = (TextView) findViewById(R.id.textView);
		Dear_User = (TextView) findViewById(R.id.Dear_User);
		Test_Image = (ImageView) findViewById(R.id.Test_Image);

		// public void Next()
		Show();

		// public void Next()
		Next();

		// public void Back()
		Back();

		// public void onBackPressed()
		onBackPressed();
	}

	@Override
	public void onBackPressed() {
		// Do Here what ever you want do on back press;
		Back();
	}

	public void Show() {
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
		String username = globalVariable.getlog_user();

		final int age = globalVariable.getlog_age();
		final String family = globalVariable.getlog_family();
		String show = getResources().getString(R.string.Dear) + " " + username;
		Dear_User.setText(show);
		Test_Image.setImageResource(R.drawable.quizdiakopwn);

		if ((age <= 35 && family.equals("FamilyNo"))
				|| family.equals("FamilyNo")) {
			x = 1;
			globalVariable.sette(x);
		} else if (age < 60 && family.equals("FamilyYes")) {
			x = 2;
			globalVariable.sette(x);
		} else if (age >= 60 && family.equals("FamilyYes")) {
			x = 3;
			globalVariable.sette(x);
		}

		// 1 => neos, 2 => pantremenos, 3 => papous
		if (x == 1) {
			textView.setText(getString(R.string.Before_Test1));
		} else if (x == 2) {
			textView.setText(getString(R.string.Before_Test2));
		} else if (x == 3) {
			textView.setText(getString(R.string.Before_Test3));
		}
	}

	public void Next() {
		Next.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
				int X = 0;
				int again = 0;
				globalVariable.setX(X);
				globalVariable.setA(again);
				globalVariable.setB(again);
				globalVariable.setC(again);
				globalVariable.setD(again);
				int Test = 1;
				globalVariable.setupdatetest(again);
				globalVariable.setTest(Test);
				Intent act2 = new Intent(view.getContext(), Test1.class);
				startActivity(act2);
			}
		});
	}

	public void Back() {
		Back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent act2 = new Intent(view.getContext(), Login_user.class);
				startActivity(act2);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_before_test, menu);
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
