package com.example.vamos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	// String = First_Name, Last_Name, Username, Email, Password, job,
	// String static = Sex, Family,
	// Integer = ID => AUTOINCREMENT, Money, update => 0 OR 1, Age,

	public static final String DATABASE_NAME = "User.db";
	public static final String TABLE_NAME = "user_table";
	public static final String COL_1 = "ID";
	public static final String COL_2 = "USERNAME";
	public static final String COL_3 = "EMAIL";
	public static final String COL_4 = "PASSWORD";
	public static final String COL_5 = "SEX";
	public static final String COL_6 = "AGE";
	public static final String COL_7 = "FAMILY";
	public static final String COL_8 = "MONEY";
	public static final String COL_9 = "CHECKUP";

	// public static final String COL_10 = "DOULIA";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table " + TABLE_NAME
				+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "USERNAME TEXT, " + "EMAIL TEXT, " + "PASSWORD TEXT, "
				+ "SEX TEXT, " + "AGE INTEGER, " + "FAMILY TEXT,"
				+ " MONEY INTEGER, " + "CHECKUP INTEGER)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

	public boolean insertData(String username, String email, String password,
			String sex, Integer age, String family, Integer money,
			Integer checkup, String doulia) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		// contentValues.put(COL_2, firstname);
		// contentValues.put(COL_3, lastname);
		// edo i arithmisi prepi na einai idia me tin dilosi pano.
		contentValues.put(COL_2, username);
		contentValues.put(COL_3, email);
		contentValues.put(COL_4, password);
		contentValues.put(COL_5, sex);
		contentValues.put(COL_6, age);
		contentValues.put(COL_7, family);
		// contentValues.put(COL_10, doulia);
		contentValues.put(COL_8, money);
		contentValues.put(COL_9, checkup);
		long result = db.insert(TABLE_NAME, null, contentValues);
		if (result == -1)
			return false;
		else
			return true;
	}

	// afto doulevi kanonika
	public Cursor getAllData() {
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
		return res;
	}

	// afto skai prepi na do gt ?
	public Cursor getuserData(String user) {
		SQLiteDatabase db = this.getWritableDatabase();

		// edo prepi na pesi erotima sqlite... gia to user.
		// meta prepi na do pos perno ta dedomena apo afto gia na ta stilo se
		// global gia na mporeso na ta xrisimopiiso

		Cursor res = db.rawQuery("select * from " + TABLE_NAME
				+ " where USERNAME = " + user, null);
		return res;
	}

	// afto doulevi kanonika
	// prepi omos na prostheso to jobs sto pinaka
	public boolean updateData(String user, Integer age, String family,
			Integer money, Integer checkup) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(COL_2, user);
		contentValues.put(COL_6, age);
		contentValues.put(COL_7, family);
		contentValues.put(COL_8, money);
		contentValues.put(COL_9, checkup);
		db.update(TABLE_NAME, contentValues, "USERNAME = ?",
				new String[] { user });
		return true;
	}

	// afto doulevi kanonika
	public Integer deleteData(String user) {
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete(TABLE_NAME, "USERNAME = ?", new String[] { user });
	}

	// get data user for bigin for log in and after.
	public Cursor getInformation(DatabaseHelper dop) {
		SQLiteDatabase db = dop.getReadableDatabase();
		String[] coloumns = { COL_1, COL_2, COL_3, COL_4, COL_5, COL_6, COL_7,
				COL_8, COL_9, };
		Cursor CR = db
				.query(TABLE_NAME, coloumns, null, null, null, null, null);
		return CR;
	}

	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
}
