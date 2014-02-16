package com.opensource.app.attapp.libs;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Parser {
	public JSONObject data;
	
	private static Parser instance = null;
	
	protected Parser() {
	      // Exists only to defeat in
	}
		
	public static Parser getParser() {
      if(instance == null) {
         instance = new Parser();
      }
      return instance;
	}
	
	public Object parse(String inputString) throws JSONException{
		inputString = inputString.trim();
		if("".equals(inputString)) Log.d("input string is: ", "NULL");
		Log.d("input string is: ", inputString);
		//Log.d("starts with:",inputString.substring(0, 2));
		try{
			if(inputString.startsWith("[")){
				return new JSONArray(inputString);
			}else{
				return new JSONObject(inputString);
			}
		}catch(JSONException jsonException){
			throw jsonException;
		}
	}

}
