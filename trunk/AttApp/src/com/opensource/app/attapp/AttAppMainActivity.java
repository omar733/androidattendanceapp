package com.opensource.app.attapp;

import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.opensource.app.attapp.R;
import com.opensource.app.attapp.libs.InputDialogListener;
import com.opensource.app.attapp.libs.OkDialog;
import com.opensource.app.attapp.libs.Popups;
import com.opensource.app.attapp.model.Employee;

import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

public class AttAppMainActivity extends BaseActivity {
	ActionMode mMode;

	ListView list;
	CustomAdapter adapter;
	public AttAppMainActivity CustomListView = null;
	public ArrayList<ListModel> CustomListViewValuesArr = new ArrayList<ListModel>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Used to put dark icons on light action bar
        boolean isLight = true;

        menu.add("Settings")
            .setIcon(isLight ? R.drawable.ic_compose_inverse : R.drawable.ic_compose)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        /*
        menu.add("Refresh")
            .setIcon(isLight ? R.drawable.ic_refresh_inverse : R.drawable.ic_refresh)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
         */
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //This uses the imported MenuItem from ActionBarSherlock
        Toast.makeText(this, "Got click: " + item.getItemId(), Toast.LENGTH_SHORT).show();
        new OkDialog(AttAppMainActivity.this,new InputDialogListener()
        {

			@Override
			public void onInputDialogButtonClick(String uname, String pass) {
				// TODO Auto-generated method stub
				
				if(uname.equals("admin")){
					Intent addUpdateIntent = new Intent(AttAppMainActivity.this,AddUpdateEmp.class);
					startActivity(addUpdateIntent);
				}else{
					Popups.showAlert(AttAppMainActivity.this, "You are not admin.");
				}
				
			}
        
        });
        
        /*switch(item.getItemId()){
    	case: 
    	}*/
    	return true;
    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.att_app_main);
		

		CustomListView = this;

		/******** Take some data in Arraylist ( CustomListViewValuesArr ) ***********/
		setListData();

		Resources res = getResources();
		list = (ListView) findViewById(R.id.list);

		/**************** Create Custom Adapter *********/
		adapter = new CustomAdapter(CustomListView, CustomListViewValuesArr,
				res);
		list.setAdapter(adapter);

	}

	/****** Function to set data in ArrayList *************/
	public void setListData() {

		ArrayList<Employee> empList = getEmpArraylist();
		for(Employee emp:empList)
		{
			final ListModel sched = new ListModel();

			/******* Firstly take data in model object ******/
			sched.setEmpName(emp.getEmp_fname()+" "+emp.getEmp_lname());
			sched.setImage("image");
			sched.setEmpId(String.valueOf(emp.getEmpid()));

			/******** Take Model Object in ArrayList **********/
			CustomListViewValuesArr.add(sched);
		}
		
	}

	public void onItemClick(int mPosition) {
		ListModel tempValues = (ListModel) CustomListViewValuesArr
				.get(mPosition);

		Toast.makeText(
				CustomListView,
				"" + tempValues.getEmpName() + " \nImage:"
						+ tempValues.getImage() + " \nUrl:"
						+ tempValues.getEmpId(), Toast.LENGTH_LONG).show();
		
		Intent surfaceActivityIntent = new Intent(AttAppMainActivity.this,ActivityStatusSurface.class);
		startActivity(surfaceActivityIntent);
	}

	
}
