package resources;

import java.util.Date;

public class TimeDate 
{
	public static String getTimeDate()
	{
		
		String date = new Date().toString();
		
		String sortdate[] = date.split(" ");
				
		String splitted_date = sortdate[2] +" "+sortdate[1]+" "+sortdate[5]+" "+"at_"+sortdate[3];

		String sorted_date = splitted_date.replaceAll(" ", "_").replaceAll(":", "_");
		
		return sorted_date;
		
	}
	

}
