package com.opensource.app.attapp.libs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.opensource.app.attapp.AppConstants;
import com.opensource.app.attapp.R;


public class OkDialog implements AppConstants{

	public OkDialog(Context ctx, String msg,final OkDialogListener okLi) {
		
		
		final Dialog dialog = new Dialog(ctx, R.style.CustomDialogTheme);
		dialog.setContentView(R.layout.common_custom_dialog);
		// dialog.setTitle("Message");
		
		dialog.show();
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
				okLi.onOkButtonClick();
			}
		});
		
	}
	
	public OkDialog(Context ctx,final InputDialogListener okLi) {
		
		
		final Dialog dialog = new Dialog(ctx, R.style.CustomDialogTheme);
		dialog.setContentView(R.layout.input_dialog);
		// dialog.setTitle("Message");
		
		dialog.show();
		// set the custom dialog components - text, image and button
	
		Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		// if button is clicked, close the custom dialog

		dialogButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText uname = (EditText) dialog.findViewById(R.id.dialog_uname);
				EditText pass = (EditText) dialog.findViewById(R.id.dialog_pass);
				okLi.onInputDialogButtonClick(uname.getText().toString(),pass.getText().toString());
				dialog.dismiss();
				
			}
		});
		
	}
	
	public OkDialog(Context ctx,String msg,final YesNoDialogueListener yesNoObj){
		
		final Dialog dialog = new Dialog(ctx, R.style.CustomDialogTheme);
		dialog.setContentView(R.layout.yes_no_dialog);
		// dialog.setTitle("Message");
		dialog.show();
		// set the custom dialog components - text, image and button
		TextView text = (TextView) dialog.findViewById(R.id.dialog_text);
		text.setText(msg);

		Button dialogButtonYes = (Button) dialog.findViewById(R.id.dialogButtonYes);
		Button dialogButtonNo = (Button) dialog.findViewById(R.id.dialogButtonNo);
		// if button is clicked, close the custom dialog
		

		dialogButtonYes.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				yesNoObj.onYesButtonClick();
			}
		});
		
		dialogButtonNo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				yesNoObj.onNoButtonClick();
			}
		});
		
	}
	
}
	
