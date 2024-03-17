package resources;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
	int count = 0;
	int retry_upto = 3;
	

	@Override
	public boolean retry(ITestResult result) 
	{
		while(count < retry_upto)
		{
			count++;
			return true;
		}
		

		return false;
	}
	
	
	
	

}
