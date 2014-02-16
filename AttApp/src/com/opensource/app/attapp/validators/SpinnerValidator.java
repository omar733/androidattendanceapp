package com.opensource.app.attapp.validators;

import com.opensource.app.attapp.forms.Form;


public class SpinnerValidator extends BasicValidator {
	int pos;
	String validatorError;
	
	public SpinnerValidator(int _pos,String _validatorError){
		this.pos = _pos;
		this.validatorError = _validatorError;
	}
	
	@Override
	public String validate(Form form, String thisname) {
		if (((Integer) form.getValue(thisname)).intValue() == pos) {
			return validatorError;
		}
		else {
			return "";
		}
	}

}