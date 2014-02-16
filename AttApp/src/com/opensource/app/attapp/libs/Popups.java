package com.opensource.app.attapp.libs;

import com.opensource.app.attapp.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class Popups {

	public Popups() {

	}

	public static void showAlert(Context ctx, String msg) {

		final Dialog dialog = new Dialog(ctx, R.style.CustomDialogTheme);
		dialog.setContentView(R.layout.common_custom_dialog);
		// dialog.setTitle("Message");
		
		if(!dialog.isShowing()){
		dialog.show();
		}else{
			dialog.dismiss();
		}
		// set the custom dialog components - text, image and button
		TextView text = (TextView) dialog.findViewById(R.id.dialog_text);
		text.setText(msg);

		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		// if button is clicked, close the custom dialog

		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});

	}
	
	

}
