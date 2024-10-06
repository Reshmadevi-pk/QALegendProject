package Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy.Simple;

public class DateUtilities {

	
	public static String getCurrentDate(){
		
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("mm/dd/yyyy");
		String FormatDate= sdf.format(date);
		return FormatDate;
		
	}
}
