package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.CheckOutPage;
import pageObjects.LoginPage;
import pageObjects.PaymentInfoPage;
import pageObjects.ProductsPage;
import utilities.WaitUtil;

public class CheckOutTest extends Base {
	
	
	
	@Test(priority=1)
	public void checkOutShopping() throws InterruptedException {
		logger.info("---------------------check Out Shopping test started---------------------");
		lp.enter_username("standard_user");
		lp.enter_password("secret_sauce");
		lp.click_login();
		productpage.aadCart_saus_Lab_Backpack();
		productpage.clickCartLink();
		addCart.click_checkOut_Button();
		checkOutPage.enter_firstName("Manjusha");
		wait.shortWait();
		checkOutPage.enter_lastName("Mali");
		wait.shortWait();
		checkOutPage.enter_Zipcode("411062");
		wait.shortWait();
		JavascriptExecutor js = ((JavascriptExecutor) driver);                      //from 0 to height of page 
        js.executeScript("window.scrollBy(0,200)");
        wait.shortWait();
		checkOutPage.click_continue_Btn();
		wait.shortWait();
		paymentInfoPage.click_finish_Btn();
		logger.info("***************************check Out Shopping test Ended**************************");
		wait.longWait();
		
	}
	

}
