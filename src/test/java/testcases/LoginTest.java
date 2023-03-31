package testcases;


import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
public class LoginTest extends Base {
	

	@Test(priority=1)
	public void valid_Username_Password() throws InterruptedException {
		
		logger.info("---------------------Login with valid_Username_Password testcase started----------------------------------");
		lp.enter_username("standard_user");
		lp.enter_password("secret_sauce");
		lp.click_login();
		String title=driver.getTitle();
		System.out.println("Page title is :  "+title);
	    Boolean value=productsPage.disply_Header_Title();
	    System.out.println(value);
	    Assert.assertEquals(true, value);
		logger.info("*********************Login with valid_Username_Password testcase Ended***********************************");
	}
	
	
	@Test(priority=2)
	public void valid_Username_Invalid_Password() throws InterruptedException {
		
		logger.info("------------------------Login with valid_Username_Invalid_Password testcase started---------------------------");
		lp.enter_username("standard_user");
		lp.enter_password("secret");
		lp.click_login();
		String title=driver.getTitle();
		System.out.println("Page title is :  "+title);
		 Boolean value=productsPage.disply_Header_Title();
		 System.out.println(value);
		 Assert.assertEquals(true, value);
		logger.info("*************************Login with valid_Username_Invalid_Password testcase Ended****************************");
		
		
		}
	
/*
	<class name="testcases.ProductsTest" />
	<class name="testcases.AddCartTest" />
	<class name="testcases.CheckOutTest" />
	<class name="testcases.PaymentTest" />
	<class name="testcases.LogoutTest" />
*/
		
	
	

}
