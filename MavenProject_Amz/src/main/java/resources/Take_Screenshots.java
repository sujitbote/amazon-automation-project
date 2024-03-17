package resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Take_Screenshots extends Launch_Quit_Browser 
{
	
	public static void getScreenshot(String test_case_status, String methodname, String date) throws IOException
	{
		
		TakesScreenshot ss = (TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);

		if (test_case_status.equalsIgnoreCase("pass")) 
		{
			File dest = new File("C:\\Users\\Shree\\eclipse new version workplace\\Demo\\Screenshots\\Passed_SS\\passed_"+ methodname + date + Math.random() + ".png");
			FileUtils.copyFile(src, dest);
		} 
		else if (test_case_status.equalsIgnoreCase("fail")) 
		{
			File dest = new File("C:\\Users\\Shree\\eclipse new version workplace\\Demo\\Screenshots\\Failed_SS\\failed_"+ methodname + date + Math.random() + ".png");
			FileUtils.copyFile(src, dest);
		}
	}

}
