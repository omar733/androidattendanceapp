package com.opensource.app.attapp.validators;

import com.opensource.app.attapp.forms.Form;

public class EmailValidator extends BasicValidator {

	@Override
	public String validate(Form form, String thisname) {
		String regexStrforEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
		if(((String) form.getValue(thisname)).trim().length()==0) return "";
		if(!((String) form.getValue(thisname)).matches(regexStrforEmail))
			return "\n Please enter a valid email id!";
		return "";
	}
}
