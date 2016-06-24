package com.example.vamos;

import android.app.Application;

public class GlobalClass extends Application {

	private String First_Name, Last_Name, Username, Email, Password,
			Re_Password;
	private String job, Sex, Family;
	private int Age, Money, checkup;
	private int A, B, C, D, X, te;
	private int Test, moneylast, updatetest;
	private String maxlast;

	// from log_in data.
	private String user, userpass, EMAIL, SEX, FAMILY;
	private int ID, AGE, MONEY, CHECKUP;

	public int getupdatetest() {
		return updatetest;
	}

	public void setupdatetest(int aupdatetest) {
		updatetest = aupdatetest;
	}

	public String getmaxlast() {
		return maxlast;
	}

	public void setmaxlast(String amaxlast) {
		maxlast = amaxlast;
	}

	public int getmoneylast() {
		return moneylast;
	}

	public void setmoneylast(int amoneylast) {
		moneylast = amoneylast;
	}

	// INT
	// CHECKUP for log in

	public int gette() {
		return te;
	}

	public void sette(int ate) {
		te = ate;
	}

	public int getlog_checkup() {
		return CHECKUP;
	}

	public void setlog_checkup(int aCHECKUP) {
		CHECKUP = aCHECKUP;
	}

	// MONEY for log in
	public int getlog_money() {
		return MONEY;
	}

	public void setlog_money(int aMONEY) {
		MONEY = aMONEY;
	}

	// AGE for log in
	public int getlog_age() {
		return AGE;
	}

	public void setlog_age(int aAGE) {
		AGE = aAGE;
	}

	// ID for log in
	public int getlog_id() {
		return ID;
	}

	public void setlog_id(int aID) {
		ID = aID;
	}

	// String
	// FAMILY for log in
	public String getlog_family() {
		return FAMILY;
	}

	public void setlog_family(String aFAMILY) {
		FAMILY = aFAMILY;
	}

	// SEX for log in
	public String getlog_sex() {
		return SEX;
	}

	public void setlog_sex(String aSEX) {
		SEX = aSEX;
	}

	// EMAIL for log in
	public String getlog_email() {
		return EMAIL;
	}

	public void setlog_email(String aEMAIL) {
		EMAIL = aEMAIL;
	}

	// PASSWORD for log in
	public String getlog_userpass() {
		return userpass;
	}

	public void setlog_userpass(String auserpass) {
		userpass = auserpass;
	}

	// USERNAME to show to log in and after
	public String getlog_user() {
		return user;
	}

	public void setlog_user(String auser) {
		user = auser;
	}

	//
	//
	//
	//
	//
	//
	//
	//
	public int getX() {
		return X;
	}

	public void setX(int Xs) {
		X = Xs;
	}

	// Integer
	// checkup for see if do update, yes =2, no =1.
	public int getTest() {
		return Test;
	}

	public void setTest(int Tests) {
		Test = Tests;
	}

	public int getCheckup() {
		return checkup;
	}

	public void setCheckup(int checkups) {
		checkup = checkups;
	}

	// A++ run for the test +1
	public int getA() {
		return A;
	}

	public void setA(int Aa) {
		A = Aa;
	}

	// B++ run for the test +1
	public int getB() {
		return B;
	}

	public void setB(int Bb) {
		B = Bb;
	}

	// C++ run for the test +1
	public int getC() {
		return C;
	}

	public void setC(int Cc) {
		C = Cc;
	}

	// D++ run for the test +1
	public int getD() {
		return D;
	}

	public void setD(int Dd) {
		D = Dd;
	}

	// money to give the user
	public int getMoney() {
		return Money;
	}

	public void setMoney(int Moneys) {
		Money = Moneys;
	}

	// age to user
	public int getAge() {
		return Age;
	}

	public void setAge(int Ages) {
		Age = Ages;
	}

	// male OR female for user
	public String getSex() {
		return Sex;
	}

	public void setSex(String aSex) {
		Sex = aSex;
	}

	// Family Yes OR Family No
	public String getFamily() {
		return Family;
	}

	public void setFamily(String aFamily) {
		Family = aFamily;
	}

	// the job to give the user
	public String getjob() {
		return job;
	}

	public void setjob(String joba) {
		job = joba;
	}

	// Password for log up
	public String getPassword() {
		return Password;
	}

	public void setPassword(String aPassword) {
		Password = aPassword;
	}

	// Re_Password for log up
	public String getRe_Password() {
		return Re_Password;
	}

	public void setRe_Password(String aRe_Password) {
		Re_Password = aRe_Password;
	}

	// Username for log up
	public String getUsername() {
		return Username;
	}

	public void setUsername(String aUsername) {
		Username = aUsername;
	}

	// Email for log up
	public String getEmail() {
		return Email;
	}

	public void setEmail(String aEmail) {
		Email = aEmail;
	}

	// First_Name for log up
	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String aFirst_Name) {
		First_Name = aFirst_Name;
	}

	// Last_Name for log up
	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String aLast_Name) {
		Last_Name = aLast_Name;
	}
}

// Help for GlobalClass
//
// // On GlobalClass.

// // to get the value
// public String get() {
// return A;
// }
//
// // to set the value
// public void set(String aA) {
// A = aA;
// }
//
//
// For .java
//
// final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
//
// // to set the value
// globalVariable.setA(A);
//
// // to get the value
// String A = globalVariable.getA();
//