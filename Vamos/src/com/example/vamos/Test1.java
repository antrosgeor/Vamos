package com.example.vamos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Test1 extends ActionBarActivity {

	TextView Username, Question;
	Button Next, Cancel;
	TextView TextA, TextB, TextC, TextD;
	CheckBox CheckBoxA, CheckBoxB, CheckBoxC, CheckBoxD;
	int X, A, B, C, D;
	int usertype;
	String Users = "Neos";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test1);
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

		// TextView
		Username = (TextView) findViewById(R.id.Username);
		Question = (TextView) findViewById(R.id.Question);
		// Button
		Next = (Button) findViewById(R.id.Next);
		Cancel = (Button) findViewById(R.id.Cancel);
		// ImageView
		TextA = (TextView) findViewById(R.id.TextA);
		TextB = (TextView) findViewById(R.id.TextB);
		TextC = (TextView) findViewById(R.id.TextC);
		TextD = (TextView) findViewById(R.id.TextD);
		// CheckBox
		CheckBoxA = (CheckBox) findViewById(R.id.CheckBoxA);
		CheckBoxB = (CheckBox) findViewById(R.id.CheckBoxB);
		CheckBoxC = (CheckBox) findViewById(R.id.CheckBoxC);
		CheckBoxD = (CheckBox) findViewById(R.id.CheckBoxD);

		// public void showNameUser()
		showNameUser();
		// public void showCheckbox()
		showCheckbox();
		// public void onBackPressed()
		onBackPressed();

		Back();

		onBackPressed();

		int usertype = globalVariable.gette();

		if (usertype == 1) {
			// NEOS
			userN();
		} else if (usertype == 2) {
			// PANTREMENOS
			userP();
		} else if (usertype == 3) {
			// PAPOUS
			userG();
		} else {
			userN();
		}

	}

	@Override
	public void onBackPressed() {
		// Do Here what ever you want do on back press;
		Back();
	}

	public void Back() {
		Cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
				final Integer Test = globalVariable.getTest();
				final Integer X = globalVariable.getX();
				int A = X - 1;
				if (!(A == 1) && !(A == 0)) {
					globalVariable.setX(A);
					globalVariable.setTest(Test);
					Intent act1 = new Intent(v.getContext(), Test1.class);
					startActivity(act1);
				}
				if (A == 1) {
					int Te = 1;
					globalVariable.setX(A);
					globalVariable.setTest(Te);
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
				if (A == 0) {
					Intent act3 = new Intent(v.getContext(),
							Show_before_test.class);
					startActivity(act3);
				}
			}
		});
	}

	// Next.setOnClickListener(new View.OnClickListener() {
	// @Override
	// public void onClick(View v) {
	// X++;
	// }
	// });

	// click the Button("NEXT"), ++ the x value.
	// Next.setText("NEXT");
	// Next.setOnClickListener(new View.OnClickListener() {
	// @Override
	// public void onClick(View v) {
	// X++;
	// }
	// });
	// End do-while
	// now the Button("NEXT") run the send value A,B,C,D and go to the
	// Show_Answer
	// Next.setText("Finish");
	// Next.setOnClickListener(new View.OnClickListener() {
	// @Override
	// public void onClick(View v) {
	// globalVariable.setA(A);
	// globalVariable.setB(B);
	// globalVariable.setC(C);
	// globalVariable.setD(D);
	//
	// Intent act2 = new Intent(v.getContext(), Show_Answer.class);
	// startActivity(act2);
	// }
	// });

	// to show to user the checked CheckBox
	public void showCheckbox() {
		CheckBoxA.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (((CheckBox) v).isChecked()) {
					Toast.makeText(Test1.this, R.string.Check_A,
							Toast.LENGTH_LONG).show();
				}
			}
		});
		CheckBoxB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (((CheckBox) v).isChecked()) {
					Toast.makeText(Test1.this, R.string.Check_B,
							Toast.LENGTH_LONG).show();
				}
			}
		});
		CheckBoxC.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (((CheckBox) v).isChecked()) {
					Toast.makeText(Test1.this, R.string.Check_C,
							Toast.LENGTH_LONG).show();
				}
			}
		});
		CheckBoxD.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (((CheckBox) v).isChecked()) {
					Toast.makeText(Test1.this, R.string.Check_D,
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	// show the UserName to user from Global.
	public void showNameUser() {
		final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
		final String user = globalVariable.getlog_user();
		// show the username on welcome text.
		Username.setText(user);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test1, menu);
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

	// NEOS
	public void userN() {

		final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
		final Integer Test = globalVariable.getTest();
		final Integer X = globalVariable.getX();
		if (Test == 1) {
			Next.setText(R.string.Next);
			Question.setText(R.string.question1);
			TextA.setText(R.string.answer1aN);
			TextB.setText(R.string.answer1bN);
			TextC.setText(R.string.answer1cN);
			TextD.setText(R.string.answer1dN);
			// Check the checked CheckBox.
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					// int X = 2;
					// int Test = 2;
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 2;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 2;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 2;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 2;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 2) {
			Next.setText(R.string.Next);
			Question.setText(R.string.question2);
			TextA.setText(R.string.answer2aN);
			TextB.setText(R.string.answer2bN);
			TextC.setText(R.string.answer2cN);
			TextD.setText(R.string.answer2dN);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					// int X = 3;
					// int Test = 2;
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 3;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 3;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 3;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 3;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 3) {
			Next.setText(R.string.Next);
			Question.setText(R.string.question3);
			TextA.setText(R.string.answer3aN);
			TextB.setText(R.string.answer3bN);
			TextC.setText(R.string.answer3cN);
			TextD.setText(R.string.answer3dN);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

					int Test = 2;
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 4;
						globalVariable.setX(X);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 4;
						globalVariable.setX(X);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 4;
						globalVariable.setX(X);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 4;
						globalVariable.setX(X);
						globalVariable.setD(Dd);
					}
					globalVariable.setTest(Test);
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 4) {
			Next.setText(R.string.Next);
			Question.setText(R.string.question4);
			TextA.setText(R.string.answer4aN);
			TextB.setText(R.string.answer4bN);
			TextC.setText(R.string.answer4cN);
			TextD.setText(R.string.answer4dN);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					int Test = 2;
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 5;
						globalVariable.setX(X);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 5;
						globalVariable.setX(X);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 5;
						globalVariable.setX(X);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 5;
						globalVariable.setX(X);
						globalVariable.setD(Dd);
					}
					globalVariable.setTest(Test);
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 5) {
			Next.setText(R.string.Next);
			Question.setText(R.string.question5);
			TextA.setText(R.string.answer5aN);
			TextB.setText(R.string.answer5bN);
			TextC.setText(R.string.answer5cN);
			TextD.setText(R.string.answer5dN);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					// int X = 6;
					int Test = 2;
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 6;
						globalVariable.setX(X);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 6;
						globalVariable.setX(X);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 6;
						globalVariable.setX(X);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 6;
						globalVariable.setX(X);
						globalVariable.setD(Dd);
					}
					globalVariable.setTest(Test);
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 6) {
			Next.setText(R.string.Next);
			Question.setText(R.string.question6);
			TextA.setText(R.string.answer6aN);
			TextB.setText(R.string.answer6bN);
			TextC.setText(R.string.answer6cN);
			TextD.setText(R.string.answer6dN);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					int Test = 2;
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 7;
						globalVariable.setX(X);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 7;
						globalVariable.setX(X);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 7;
						globalVariable.setX(X);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 7;
						globalVariable.setX(X);
						globalVariable.setD(Dd);
					}
					globalVariable.setTest(Test);
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 7) {
			Next.setText(R.string.Next);
			Question.setText(R.string.question7);
			TextA.setText(R.string.answer7aN);
			TextB.setText(R.string.answer7bN);
			TextC.setText(R.string.answer7cN);
			TextD.setText(R.string.answer7dN);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					int Test = 2;
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 8;
						globalVariable.setX(X);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 8;
						globalVariable.setX(X);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 8;
						globalVariable.setX(X);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 8;
						globalVariable.setX(X);
						globalVariable.setD(Dd);
					}
					globalVariable.setTest(Test);
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 8) {
			Next.setText(R.string.finish);
			Question.setText(R.string.question8);
			TextA.setText(R.string.answer8aN);
			TextB.setText(R.string.answer8bN);
			TextC.setText(R.string.answer8cN);
			TextD.setText(R.string.answer8dN);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 10;
						int Test = 10;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 10;
						int Test = 10;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 10;
						int Test = 10;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 10;
						int Test = 10;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Show_Answer.class);
					startActivity(act2);
				}
			});
		}
	}

	// PANTREMENOS
	public void userP() {

		final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
		final Integer Test = globalVariable.getTest();
		final Integer X = globalVariable.getX();
		if (Test == 1) {
			Next.setText("NEXT");
			Question.setText(R.string.question1);
			TextA.setText(R.string.answer1aP);
			TextB.setText(R.string.answer1bP);
			TextC.setText(R.string.answer1cP);
			TextD.setText(R.string.answer1dP);
			// Check the checked CheckBox.
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 2;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 2;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 2;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 2;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 2) {
			Next.setText("NEXT");
			Question.setText(R.string.question2);
			TextA.setText(R.string.answer2aP);
			TextB.setText(R.string.answer2bP);
			TextC.setText(R.string.answer2cP);
			TextD.setText(R.string.answer2dP);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 3;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 3;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 3;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 3;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 3) {
			Next.setText("NEXT");
			Question.setText(R.string.question3);
			TextA.setText(R.string.answer3aP);
			TextB.setText(R.string.answer3bP);
			TextC.setText(R.string.answer3cP);
			TextD.setText(R.string.answer3dP);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 4;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 4;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 4;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 4;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 4) {
			Next.setText("NEXT");
			Question.setText(R.string.question4);
			TextA.setText(R.string.answer4aP);
			TextB.setText(R.string.answer4bP);
			TextC.setText(R.string.answer4cP);
			TextD.setText(R.string.answer4dP);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 5;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 5;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 5;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 5;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 5) {
			Next.setText("NEXT");
			Question.setText(R.string.question5);
			TextA.setText(R.string.answer5aP);
			TextB.setText(R.string.answer5bP);
			TextC.setText(R.string.answer5cP);
			TextD.setText(R.string.answer5dP);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 6;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 6;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 6;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 6;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 6) {
			Next.setText("NEXT");
			Question.setText(R.string.question6);
			TextA.setText(R.string.answer6aP);
			TextB.setText(R.string.answer6bP);
			TextC.setText(R.string.answer6cP);
			TextD.setText(R.string.answer6dP);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 7;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 7;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 7;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 7;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 7) {
			Next.setText("NEXT");
			Question.setText(R.string.question7);
			TextA.setText(R.string.answer7aP);
			TextB.setText(R.string.answer7bP);
			TextC.setText(R.string.answer7cP);
			TextD.setText(R.string.answer7dP);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int X = 8;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						int Aa = A + 1;
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 8;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 8;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 8;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 8) {
			Next.setText("Finish");
			Question.setText(R.string.question8);
			TextA.setText(R.string.answer8aP);
			TextB.setText(R.string.answer8bP);
			TextC.setText(R.string.answer8cP);
			TextD.setText(R.string.answer8dP);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 10;
						int Test = 10;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int X = 10;
						int Test = 10;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						int Bb = B + 1;
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 10;
						int Test = 10;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 10;
						int Test = 10;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Show_Answer.class);
					startActivity(act2);
				}
			});
		}
	}

	// PAPOUS
	public void userG() {

		final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
		final Integer Test = globalVariable.getTest();
		final Integer X = globalVariable.getX();
		if (Test == 1) {
			Next.setText("NEXT");
			Question.setText(R.string.question1);
			TextA.setText(R.string.answer1aG);
			TextB.setText(R.string.answer1bG);
			TextC.setText(R.string.answer1cG);
			TextD.setText(R.string.answer1dG);
			// Check the checked CheckBox.
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 2;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 2;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 2;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 2;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 2) {
			Next.setText("NEXT");
			Question.setText(R.string.question2);
			TextA.setText(R.string.answer2aG);
			TextB.setText(R.string.answer2bG);
			TextC.setText(R.string.answer2cG);
			TextD.setText(R.string.answer2dG);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 3;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 3;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 3;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 3;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 3) {
			Next.setText("NEXT");
			Question.setText(R.string.question3);
			TextA.setText(R.string.answer3aG);
			TextB.setText(R.string.answer3bG);
			TextC.setText(R.string.answer3cG);
			TextD.setText(R.string.answer3dG);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 4;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 4;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 4;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 4;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 4) {
			Next.setText("NEXT");
			Question.setText(R.string.question4);
			TextA.setText(R.string.answer4aG);
			TextB.setText(R.string.answer4bG);
			TextC.setText(R.string.answer4cG);
			TextD.setText(R.string.answer4dG);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 5;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 5;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 5;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 5;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 5) {
			Next.setText("NEXT");
			Question.setText(R.string.question5);
			TextA.setText(R.string.answer5aG);
			TextB.setText(R.string.answer5bG);
			TextC.setText(R.string.answer5cG);
			TextD.setText(R.string.answer5dG);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 6;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 6;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 6;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 6;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 6) {
			Next.setText("NEXT");
			Question.setText(R.string.question6);
			TextA.setText(R.string.answer6aG);
			TextB.setText(R.string.answer6bG);
			TextC.setText(R.string.answer6cG);
			TextD.setText(R.string.answer6dG);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 7;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 7;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 7;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 7;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 7) {
			Next.setText("NEXT");
			Question.setText(R.string.question7);
			TextA.setText(R.string.answer7aG);
			TextB.setText(R.string.answer7bG);
			TextC.setText(R.string.answer7cG);
			TextD.setText(R.string.answer7dG);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 8;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 8;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 8;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 8;
						int Test = 2;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Test1.class);
					startActivity(act2);
				}
			});
		} else if (X == 8) {
			Next.setText("Finish");
			Question.setText(R.string.question8);
			TextA.setText(R.string.answer8aG);
			TextB.setText(R.string.answer8bG);
			TextC.setText(R.string.answer8cG);
			TextD.setText(R.string.answer8dG);
			Next.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
					if (CheckBoxA.isChecked()) {
						Integer A = globalVariable.getA();
						int Aa = A + 1;
						int X = 10;
						int Test = 10;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setA(Aa);
					} else if (CheckBoxB.isChecked()) {
						final Integer B = globalVariable.getB();
						int Bb = B + 1;
						int X = 10;
						int Test = 10;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setB(Bb);
					} else if (CheckBoxC.isChecked()) {
						final Integer C = globalVariable.getC();
						int Cc = C + 1;
						int X = 10;
						int Test = 10;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setC(Cc);
					} else if (CheckBoxD.isChecked()) {
						final Integer D = globalVariable.getD();
						int Dd = D + 1;
						int X = 10;
						int Test = 10;
						globalVariable.setX(X);
						globalVariable.setTest(Test);
						globalVariable.setD(Dd);
					}
					Intent act2 = new Intent(v.getContext(), Show_Answer.class);
					startActivity(act2);
				}
			});
		}
	}
}
