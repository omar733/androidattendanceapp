package com.opensource.app.attapp.forms;



import java.util.ArrayList;

import android.app.Activity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;

import com.opensource.app.attapp.validators.BasicValidator;

public class FormElement {

	private Integer id = null;
	protected String name = null;

	Form form;
	private ArrayList<BasicValidator> validators = new ArrayList<BasicValidator>();
	
	public FormElement(int layoutId, Form f) {
		setId(layoutId);
		this.form = f;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public FormElement setName(String name) {
		this.name = name;
		return this;
	}
	
	public FormElement setValue(String value) {
		Activity a = form.getActivity();
		EditText editText =(EditText) a.findViewById(id);
		editText.setText(value);
		editText.setSelection(editText.getText().length());
		return this;
	}
	
	public FormElement addValidator(BasicValidator validator) {
		validators.add(validator);
		return this;
	}
	public String validate(){
		Log.d("CAll", "Form Element Validate Called");
		String returnString="";
		for(BasicValidator v:validators){
			returnString+=v.validate(form, name);
		}
		return returnString;
	}

	public FormElement setValue(Boolean value) {
		Activity a = form.getActivity();
		CheckBox checkBox =(CheckBox) a.findViewById(id);
		if(value!=null) checkBox.setChecked(value);
		return this;
	}


}
