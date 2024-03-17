package resources;

import org.openqa.selenium.WebDriver;

public class Navigations_on_Tab 
{
	WebDriver driver;
	
	public void navigate_Tab_Forward() 
	{
		driver.navigate().forward();
	}

	public void navigate_Tab_Back() 
	{
		driver.navigate().back();
	}

	public void tab_Refresh() 
	{
		driver.navigate().refresh();
	}

	public void switch_to_Frame() 
	{
		driver.switchTo().frame(0);
	}
	
	public void switch_to_DefaultPage() 
	{
		driver.switchTo().defaultContent();
	}

	public Navigations_on_Tab(WebDriver driver) 
	{
		this.driver = driver;
	}
}
