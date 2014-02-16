package com.opensource.app.attapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.actionbarsherlock.app.SherlockActivity;

public class ActivityStatusSurface extends SherlockActivity implements
		AppConstants {

	private Button btnIn;
	private Button btnOut;
	private Button btnSubmit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_status_surface);

		init();
		performActions();

	}

	private void performActions() {
		btnIn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Intent cameraIntent = new Intent(ActivityStatusSurface.this,CameraViewActivity.class);
				startActivity(cameraIntent);
			}
		});

		btnOut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Intent cameraIntent = new Intent(ActivityStatusSurface.this,CameraViewActivity.class);
				startActivity(cameraIntent);
			}
		});
	}

	private void init() {
		btnIn = (Button) findViewById(R.id.btnIn);
		btnOut = (Button) findViewById(R.id.btnOut);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
	}

}
