package com.opensource.app.attapp.validators;

import com.opensource.app.attapp.forms.Form;

public class LengthValidator extends BasicValidator {
	int limit = 0;
	public LengthValidator(int l){
		limit=l;
	}

	@Override
	public String validate(Form form, String thisname) {
		if(((String) form.getValue(thisname)).length()>limit)
			return "\n"+thisname+" has been exceeded by "+(((String) form.getValue(thisname)).length()-limit) +" charecters!";
		else
			return "";
	}

}