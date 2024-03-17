package resources;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Launch_Quit_Browser
{
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(String browser)
	{
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		
		if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.navigate().to("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
