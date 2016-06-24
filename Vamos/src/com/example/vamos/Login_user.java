package com.example.vamos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login_user extends ActionBarActivity {
	// see database name myDb.
	DatabaseHelper myDb;

	Button go_testButton, Change_The_DataButton, Show_last_testButton,
			Log_OutButton, Delete_user, show_db;
	// Button viewAll;
	TextView Welcome, ShowUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_user);

		// for to see the Database.
		myDb = new DatabaseHelper(this);

		// find from login_user.xml
		go_testButton = (Button) findViewById(R.id.go_test);
		Change_The_DataButton = (Button) findViewById(R.id.Change_The_Data);
		Show_last_testButton = (Button) findViewById(R.id.Show_last_test);
		Log_OutButton = (Button) findViewById(R.id.Log_Out);
		Welcome = (TextView) findViewById(R.id.Welcome);
		ShowUser = (TextView) findViewById(R.id.ShowUser);
		Delete_user = (Button) findViewById(R.id.Delete_user);
		show_db = (Button) findViewById(R.id.show_db);
		// viewAll = (Button) findViewById(R.id.viewAll);

		// get.
		// String Username = getIntent().getStringExtra("Username");
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
		final String user = globalVariable.getlog_user();

		// show the username on welcome text.
		ShowUser.setText(user);

		// public void Log_Out()
		Log_Out();

		// public void Update()
		Update();

		// public void DeleteData()

		DeleteData();

		// public void viewAll()
		// viewAll();

		// false
		show_user();

		go_test();

		Show_last_testButton();

		onBackPressed();

	}

	@Override
	public void onBackPressed() {
		// Do Here what ever you want do on back press;
	}

	public void Show_last_testButton() {
		Show_last_testButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

				int a = globalVariable.getmoneylast();
				String b = globalVariable.getmaxlast();
				int updatetest = globalVariable.getupdatetest();

				if (updatetest == 1) {
					Toast.makeText(getApplicationContext(), R.string.changed,
							Toast.LENGTH_LONG).show();
				} else if (a == -1 && b.equals("F")) {
					Toast.makeText(getBaseContext(), R.string.not,
							Toast.LENGTH_LONG).show();
				} else {

					Intent act2 = new Intent(view.getContext(), Last_test.class);
					finish();
					startActivity(act2);
				}
			}
		});
	}

	public void go_test() {
		go_testButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent act2 = new Intent(view.getContext(),
						Show_before_test.class);
				finish();
				startActivity(act2);
			}
		});
	}

	// to delete the user.
	public void DeleteData() {
		Delete_user.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(final View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder a_builder = new AlertDialog.Builder(
						Login_user.this);
				a_builder.setTitle(R.string.Delete_user);

				a_builder.setIcon(R.drawable.delete);

				a_builder
						.setMessage(R.string.Do_you_want_to_Delete)
						.setCancelable(false)
						.setPositiveButton(R.string.Yes,
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
										final String user = globalVariable
												.getlog_user();
										// get user from globalVariable.getuser
										// and delete for data.

										Integer deleteRows = myDb
												.deleteData(user);
										if (deleteRows > 0) {
											Intent act2 = new Intent(v
													.getContext(),
													MainActivity.class);
											Toast.makeText(
													getApplicationContext(),
													R.string.delet,
													Toast.LENGTH_LONG).show();
											finish();
											startActivity(act2);
										} else {
											Toast.makeText(getBaseContext(),
													R.string.nodelete,
													Toast.LENGTH_LONG).show();
										}
									}
								})
						.setNegativeButton(R.string.No,
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.cancel();
									}
								});
				AlertDialog alert = a_builder.create();
				alert.setTitle(R.string.Alert);
				alert.show();
			}
		});
	}

	// edo isos na ftei to cursor pou xrisimopiio. na to do.isos valo kati alo.
	public void show_user() {
		show_db.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				// refresh code.
				// Intent intent = getIntent();
				// finish();
				// startActivity(intent);

				final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
				final String user = globalVariable.getlog_user();

				int Iduser = globalVariable.getlog_id();
				String USERNAME = globalVariable.getlog_user();
				String EMAIL = globalVariable.getlog_email();
				String PASSWORD = globalVariable.getlog_userpass();
				String SEX = globalVariable.getlog_sex();
				int AGE = globalVariable.getlog_age();
				String FAMILY = globalVariable.getlog_family();
				int MONEY = globalVariable.getlog_money();
				int CHECKUP = globalVariable.getlog_checkup();

				// show message
				showMessage("User Data : " + user + " \n", "Id        : "
						+ Iduser + "\n" + "Username  : " + USERNAME + "\n"
						+ "Email     : " + EMAIL + "\n" + "Password  : "
						+ PASSWORD + "\n" + "Sex       : " + SEX + "\n"
						+ "Age       : " + AGE + "\n" + "Family    : " + FAMILY
						+ "\n" + "Money     : " + MONEY + "\n" + "CheckUp   : "
						+ CHECKUP + "\n\n\n");
			}
		});
	}

	// // to show all data from database.
	// public void viewAll() {
	// viewAll.setOnClickListener(new View.OnClickListener() {
	//
	// @Override
	// public void onClick(View v) {
	// Cursor res = myDb.getAllData();
	// if (res.getCount() == 0) {
	// // show message
	// showMessage("Error", "Nothing found");
	// return;
	// }
	// // edo i arithmisi prepi na einia -1 gt 3ekiname apo to 0.
	// StringBuffer buffer = new StringBuffer();
	// while (res.moveToNext()) {
	// buffer.append("Id        : " + res.getString(0) + "\n");
	// buffer.append("Username  : " + res.getString(1) + "\n");
	// buffer.append("Email     : " + res.getString(2) + "\n");
	// buffer.append("Password  : " + res.getString(3) + "\n");
	// buffer.append("Sex       : " + res.getString(4) + "\n");
	// buffer.append("Age       : " + res.getString(5) + "\n");
	// buffer.append("Family    : " + res.getString(6) + "\n");
	// buffer.append("Money     : " + res.getString(7) + "\n");
	// buffer.append("CheckUp   : " + res.getString(8) + "\n\n\n");
	// }
	// // show all data
	// showMessage("Data", buffer.toString());
	// }
	// });
	// }

	// log_out.
	public void Log_Out() {
		Log_OutButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent act2 = new Intent(view.getContext(), MainActivity.class);
				finish();
				Toast.makeText(getBaseContext(), R.string.Log_Out,
						Toast.LENGTH_LONG).show();
				startActivity(act2);
			}
		});
	}

	// to go the list for update the data.
	public void Update() {
		Change_The_DataButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent act2 = new Intent(view.getContext(), Update_user.class);
				finish();
				startActivity(act2);
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_user, menu);
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