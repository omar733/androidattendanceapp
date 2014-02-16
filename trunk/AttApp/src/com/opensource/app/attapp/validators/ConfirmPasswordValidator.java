package com.opensource.app.attapp.validators;

import com.opensource.app.attapp.forms.Form;

public class ConfirmPasswordValidator extends BasicValidator {

	String passwordControl ="";
	
	public ConfirmPasswordValidator(String passwordControl){
		this.passwordControl=passwordControl;
	}
	
	@Override
	public String validate(Form form, String thisname) {
		String password=(String) form.getValue(passwordControl);
		String confirmPassword=(String) form.getValue(thisname);
		
		if(!password.equals(confirmPassword))
			return "\n Password did not match!";
		return "";
	}
}
