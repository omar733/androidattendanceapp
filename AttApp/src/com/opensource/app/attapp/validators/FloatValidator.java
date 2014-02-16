package com.opensource.app.attapp.validators;

import com.opensource.app.attapp.forms.Form;

public class FloatValidator extends BasicValidator {

	@Override
	public String validate(Form form, String thisname) {
		String regexStrforFloat = "[-+]?[0-9]*\\.?[0-9]+";
		if(form.getValue(thisname)=="") return "";
		
		if(!((String) form.getValue(thisname)).matches(regexStrforFloat))
			return "\n Please enter a number with decimal point!";
		
		return "";
	}

}