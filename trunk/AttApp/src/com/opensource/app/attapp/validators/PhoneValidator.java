package com.opensource.app.attapp.validators;

import com.opensource.app.attapp.forms.Form;

public class PhoneValidator extends BasicValidator {

	@Override
	public String validate(Form form, String thisname) {
		String regexStrforPhn = "^[0-9]*$";
		if(form.getValue(thisname)=="") return "";
		
		if(((String) form.getValue(thisname)).length()>13)
			return "\n Please enter a valid "+thisname+"!";
		if(((String) form.getValue(thisname)).length()<10)
			return "\n Please enter a valid "+thisname+"!";
		if(!((String) form.getValue(thisname)).matches(regexStrforPhn))
			return "\n Please enter a valid "+thisname+"!";
		
		return "";
	}

}