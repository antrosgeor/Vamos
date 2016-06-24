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

public class Last_test extends Activity {

	TextView show, bodyTitle, where_to_go;
	ImageView Test_Image;
	Button userButton, go_to_test, send;
	int money;
	int max;
	int usertype;
	String A = "A", B = "B", C = "C", D = "D";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.last_test);

		show = (TextView) findViewById(R.id.show);
		bodyTitle = (TextView) findViewById(R.id.bodyTitle);
		where_to_go = (TextView) findViewById(R.id.where_to_go);
		Test_Image = (ImageView) findViewById(R.id.Test_Image);
		userButton = (Button) findViewById(R.id.userButton);
		go_to_test = (Button) findViewById(R.id.go_to_test);
		send = (Button) findViewById(R.id.send);

		// public void go_to_test()
		go_to_test();

		send();
		// public void userButton()
		userButton();

		final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
		// Get the value from Global.

		// user name
		String User = globalVariable.getlog_user();
		// type for user 1=Neos 2=PANTREMENOS-GEROS
		int usertypes = globalVariable.gette();
		// money 0= AFRAGKOS 1=MATSOMENOS

		if (usertypes == 1) {
			usertype = 1;
		} else if (usertypes == 2 || usertypes == 3) {
			usertype = 2;
		}

		int money = globalVariable.getmoneylast();
		String max = globalVariable.getmaxlast();

		// if gia to kathe ena gia na ta efanisi ola ...
		if (usertype == 1) {
			if (A.equals(max)) {
				String ShowAnswer = getResources()
						.getString(R.string.last_test)
						+ " "
						+ User
						+ " :\n  A. " + getString(R.string.answerATitle);
				show.setText(ShowAnswer);
				Test_Image.setImageResource(R.drawable.afoto);
				bodyTitle.setText(R.string.answerAN);

				if (money == 0) { // Afragkos
					where_to_go.setText(R.string.answerAgoA);
				} else if (money == 1) { // Matsomenos
					where_to_go.setText(R.string.answerAgoM);
				}
			} else if (B.equals(max)) {
				String ShowAnswer = getResources()
						.getString(R.string.last_test)
						+ " "
						+ User
						+ " :\n  B. " + getString(R.string.answerBTitle);
				show.setText(ShowAnswer);
				Test_Image.setImageResource(R.drawable.bfoto);
				bodyTitle.setText(R.string.answerBN);

				if (money == 0) { // Afragkos
					where_to_go.setText(R.string.answerBgoA);
				} else if (money == 1) { // Matsomenos
					where_to_go.setText(R.string.answerBgoM);
				}
			} else if (C.equals(max)) {
				String ShowAnswer = getResources()
						.getString(R.string.last_test)
						+ " "
						+ User
						+ " :\n  C. " + getString(R.string.answerCTitle);
				show.setText(ShowAnswer);
				Test_Image.setImageResource(R.drawable.cfoto);
				bodyTitle.setText(R.string.answerCN);

				if (money == 0) { // Afragkos
					where_to_go.setText(R.string.answerCgoA);
				} else if (money == 1) { // Matsomenos
					where_to_go.setText(R.string.answerCgoM);
				}
			} else if (D.equals(max)) {
				String ShowAnswer = getResources()
						.getString(R.string.last_test)
						+ " "
						+ User
						+ " :\n  D. " + getString(R.string.answerDTitle);
				show.setText(ShowAnswer);
				Test_Image.setImageResource(R.drawable.dfoto);
				bodyTitle.setText(R.string.answerDN);

				if (money == 0) { // Afragkos
					where_to_go.setText(R.string.answerDgoA);
				} else if (money == 1) { // Matsomenos
					where_to_go.setText(R.string.answerDgoM);
				}
			}
		}
		if (usertype == 2) {
			if (A.equals(max)) {
				String ShowAnswer = getResources()
						.getString(R.string.last_test)
						+ " "
						+ User
						+ " :\n  A. " + getString(R.string.answerATitle);
				show.setText(ShowAnswer);
				Test_Image.setImageResource(R.drawable.afoto);
				bodyTitle.setText(R.string.answerAP);

				if (money == 0) { // Afragkos
					where_to_go.setText(R.string.answerAgoA);
				} else if (money == 1) { // Matsomenos
					where_to_go.setText(R.string.answerAgoM);
				}
			} else if (B.equals(max)) {
				String ShowAnswer = getResources()
						.getString(R.string.last_test)
						+ " "
						+ User
						+ " :\n  B. " + getString(R.string.answerBTitle);
				show.setText(ShowAnswer);
				Test_Image.setImageResource(R.drawable.bfoto);
				bodyTitle.setText(R.string.answerBP);

				if (money == 0) { // Afragkos
					where_to_go.setText(R.string.answerBgoA);
				} else if (money == 1) { // Matsomenos
					where_to_go.setText(R.string.answerBgoM);
				}
			} else if (C.equals(max)) {
				String ShowAnswer = getResources()
						.getString(R.string.last_test)
						+ " "
						+ User
						+ " :\n  C. " + getString(R.string.answerCTitle);
				show.setText(ShowAnswer);
				Test_Image.setImageResource(R.drawable.cfoto);
				bodyTitle.setText(R.string.answerCP);

				if (money == 0) { // Afragkos
					where_to_go.setText(R.string.answerCgoA);
				} else if (money == 1) { // Matsomenos
					where_to_go.setText(R.string.answerCgoM);
				}
			} else if (D.equals(max)) {
				String ShowAnswer = getResources()
						.getString(R.string.last_test)
						+ " "
						+ User
						+ " :\n  D. " + getString(R.string.answerDTitle);
				show.setText(ShowAnswer);
				Test_Image.setImageResource(R.drawable.dfoto);
				bodyTitle.setText(R.string.answerDP);

				if (money == 0) { // Afragkos
					where_to_go.setText(R.string.answerDgoA);
				} else if (money == 1) { // Matsomenos
					where_to_go.setText(R.string.answerDgoM);
				}
			}
		}
	}

	public void go_to_test() {
		go_to_test.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
				int again = 0;
				globalVariable.setA(again);
				globalVariable.setB(again);
				globalVariable.setC(again);
				globalVariable.setD(again);

				Intent act2 = new Intent(view.getContext(),
						Show_before_test.class);
				startActivity(act2);
			}
		});
	}

	public void userButton() {
		userButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
				int again = 0;
				int againtest = -1;
				String againTests = "F";
				globalVariable.setA(again);
				globalVariable.setB(again);
				globalVariable.setC(again);
				globalVariable.setD(again);

				globalVariable.setmoneylast(againtest);
				globalVariable.setmaxlast(againTests);

				Intent act2 = new Intent(view.getContext(), Login_user.class);
				startActivity(act2);
			}
		});
	}

	public void send() {
		send.setOnClickListener(new View.OnClickListener() {
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
		getMenuInflater().inflate(R.menu.last_test, menu);
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
