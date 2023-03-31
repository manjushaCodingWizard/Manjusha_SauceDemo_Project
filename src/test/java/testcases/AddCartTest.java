package testcases;

import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utilities.WaitUtil;

public class AddCartTest extends Base {
	
	@Test(priority=1)
	public void addProductToCart() throws InterruptedException {
		logger.info("----------------------Add Product To Cart test started------------------");
		lp.enter_username("standard_user");
		lp.enter_password("secret_sauce");
		lp.click_login();
		productpage.aadCart_saus_Lab_Backpack();
		productpage.clickCartLink();
		wait.longWait();
		logger.info(" ********************************Add Product To Cart test ENDED****************");
		
	}
	
	

}
