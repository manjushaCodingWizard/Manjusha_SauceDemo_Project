package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.CheckOutPage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.PaymentInfoPage;
import pageObjects.ProductsPage;
import utilities.WaitUtil;

public class LogoutTest extends Base {
	
	
	
	@Test(priority=1)
	public void logOutTest() throws InterruptedException {
		logger.info(" logOutTest Test  started");
		lp.enter_username("standard_user");
		lp.enter_password("secret_sauce");
		lp.click_login();
		productpage.aadCart_saus_Lab_Backpack();
		productpage.clickCartLink();
		addCart.click_checkOut_Button();
		checkOutPage.enter_firstName("Manjusha");
		checkOutPage.enter_lastName("abcd");
		wait.shortWait();
		checkOutPage.enter_Zipcode("412308");
		wait.shortWait();
		JavascriptExecutor js = ((JavascriptExecutor) driver);                      //from 0 to height of page 
        js.executeScript("window.scrollBy(0,200)");
        wait.shortWait();
		checkOutPage.click_continue_Btn();
		wait.shortWait();
		paymentInfoPage.click_finish_Btn();
		wait.shortWait();
		String text=logoutpage.orderCompleteText();
		System.out.println("Order Status:  "+text);
		wait.shortWait();
		logoutpage.click_MenuPanel();
		wait.shortWait();
		logoutpage.click_logOut();
		wait.longWait();
		logger.info(" logOutTest Test  Ended");
		
	}
	
	

}
