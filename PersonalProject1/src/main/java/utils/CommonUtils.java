package utils;

import java.util.Date;

public class CommonUtils {
       
	
    public  String getEmailWithTimeStamp() {
		
		Date date = new Date();
		return "amotoori"+date.toString().replace("","_").replace(":","_")+"@gmail.com";
	}
	
	
}
