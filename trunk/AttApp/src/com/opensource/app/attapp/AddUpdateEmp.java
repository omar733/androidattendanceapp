package com.opensource.app.attapp;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockActivity;
import com.opensource.app.attapp.forms.Form;
import com.opensource.app.attapp.forms.SubmitHandler;
import com.opensource.app.attapp.libs.ExternalDbOpenHelper;
import com.opensource.app.attapp.libs.Popups;
import com.opensource.app.attapp.model.Employee;
import com.opensource.app.attapp.validators.RequiredValidator;


public class AddUpdateEmp extends SherlockActivity implements AppConstants{

	EditText emp_fname;
	EditText emp_lname;
	EditText emp_desig;
	EditText emp_doj;
	
	private SQLiteDatabase database;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_update_emp);
		init();
		
		ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(this,
				DB_NAME);
		database = dbOpenHelper.openDataBase();
		
		formSubmit(); // Saving emps
		
	}
	
	private void init()
	{
		emp_fname = (EditText) findViewById(R.id.emp_fname);
		emp_lname = (EditText) findViewById(R.id.emp_lname);
		emp_desig = (EditText) findViewById(R.id.emp_desig);
		emp_doj = (EditText) findViewById(R.id.emp_doj);
	}
	
	private void formSubmit() {
		Form form = new Form((Activity) this);

		form.addFormElement(R.id.emp_fname).setName("First Name")
				.addValidator(new RequiredValidator());

		
		form.addSubmit(R.id.emp_settings_form_submit, this).setName("submit")
				.addSubmitHandler(new SubmitHandler() {

					@Override
					public void submit(Form form) {

						Employee empObj = new Employee();

						empObj.setEmp_fname(emp_fname.getText().toString());
						empObj.setEmp_lname(emp_lname.getText().toString());
						empObj.setEmp_desig(emp_desig.getText().toString());
						empObj.setEmp_doj(Integer.parseInt(emp_doj.getText().toString()));
						
						Log.d(" +++++ Settings Object +++++ ",
								empObj.toString());

						insertSettings(empObj);

						Popups.showAlert(AddUpdateEmp.this,
								"Settings Saved !");

						Log.d("######## Submit called ######## ",
								"<<<<<<<<<<<<<<<<<<<< Subit Called >>>>>>>>>>>>>>>>>>>>>>>");

					}
				});
	}
	
	public long insertSettings(Employee empObj){
		
		ContentValues values = new ContentValues();
		values.put(EMP_FNAME, empObj.getEmp_fname());
		values.put(EMP_LNAME, empObj.getEmp_lname());
		values.put(EMP_DESIG, empObj.getEmp_desig());
		values.put(EMP_DOJ, empObj.getEmp_doj());

		// updating row
		return database.insert(EMP_TABLE, null, values);
		
	}
	
	public int updateSettings(Employee empObj) {

		ContentValues values = new ContentValues();
		values.put(EMP_FNAME, empObj.getEmp_fname());
		values.put(EMP_LNAME, empObj.getEmp_lname());
		values.put(EMP_DESIG, empObj.getEmp_desig());
		values.put(EMP_DOJ, empObj.getEmp_doj());

		// updating row
		return database.update(EMP_TABLE, values, EMP_ID + " = ?",
				new String[] { String.valueOf(empObj.getEmpid()) });
	}
}
