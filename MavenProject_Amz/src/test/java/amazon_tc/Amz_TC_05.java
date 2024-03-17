package amazon_tc;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.Launch_Quit_Browser;
import source_pages.Amz_Account_Page;
import source_pages.Amz_Login_Page;
import source_pages.Amz_Logout_Page;
import source_pages.Amz_Product_Page;

//scenario = Login->searching->logout

@Listeners(resources.TestListeners.class)

public class Amz_TC_05 extends Launch_Quit_Browser
{
	@Test (dataProvider="data1", dataProviderClass=resources.Fetch_Excel_Data.class)
	public void login_Searching_Logout(String un, String pwd) throws EncryptedDocumentException, IOException
	{
		Amz_Login_Page login = new Amz_Login_Page(driver);
		Amz_Product_Page search = new Amz_Product_Page(driver);
		Amz_Account_Page account = new Amz_Account_Page(driver);
		Amz_Logout_Page logout = new Amz_Logout_Page(driver);

		
		login.navigatetoSigninPage();
		login.enterUsername(un);
		login.click_Continue_pb();
		login.enterPassword(pwd);
		login.click_sign_in_pb();

		search.searchProduct();
		search.enter_after_searchProduct();
		
		Assert.assertEquals(search.getPageTitle(), "Amazon.in : shoe", "selected product is incorrect");
		System.out.println("selected product is correct");
		
		account.hoverOver_AccountOptions();
		logout.click_sign_out_pb();
		
		
	}
	
}
