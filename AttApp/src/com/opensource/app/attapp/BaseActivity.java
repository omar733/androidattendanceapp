package com.opensource.app.attapp;

import java.util.ArrayList;
import java.util.List;

import com.actionbarsherlock.app.SherlockActivity;

import com.opensource.app.attapp.libs.ExternalDbOpenHelper;
import com.opensource.app.attapp.model.Employee;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class BaseActivity extends SherlockActivity implements AppConstants{

	
	private SQLiteDatabase database;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}
	
	public ArrayList<Employee> getEmpArraylist(){
		
		
		ArrayList<Employee> empList = new ArrayList<Employee>();
		
		ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(this,
				DB_NAME);
		database = dbOpenHelper.openDataBase();

		String selectQuery = "SELECT * FROM emp";
		Cursor dbcursor = database.rawQuery(selectQuery, null);
		  if (dbcursor.moveToFirst()) {
		    do {
		    	Employee objEmp = new Employee();
		    	objEmp.setEmpid(dbcursor.getInt(0));
		    	objEmp.setEmp_fname(dbcursor.getString(1));
		    	objEmp.setEmp_lname(dbcursor.getString(2));
		    	objEmp.setEmp_desig(dbcursor.getString(3));
		    	objEmp.setEmp_doj(dbcursor.getInt(4));
		    	Log.d("Employee >>> ", "# "+objEmp.toString());
		    	empList.add(objEmp);
		    } while (dbcursor.moveToNext());
		  } 
		
		
		
		return empList;
	}
}
