package testcases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductsPage;

//here I am taking only product price and adding in the cart, 
//taking text of the same


public class ProductsTest extends Base {
	
	@Test(priority=1)
	public void getProductPrice() {
		logger.info("-------------------------Get ProductPrice testcase started-----------------------");
		lp.enter_username("standard_user");
		lp.enter_password("secret_sauce");
		lp.click_login();
	    String price=productpage.getPrice_saus_Lab_Backpack();
	    System.out.println("Product Price of saus_Lab_Backpack is: "+price);
	    logger.info("*************************Get ProductPrice test Ended***************************");
		
	}
	
	
	@Test(priority=2)
	public void clickAddCartBtn() {
		logger.info("------------------------- click Add Cart Button test started-----------------------");
		lp.enter_username("standard_user");
		lp.enter_password("secret_sauce");
		lp.click_login();
	    productpage.aadCart_saus_Lab_Backpack();
	    logger.info("***********************click Add Cart Button test Ended**************************");
		
	}
	
	
	@Test(priority=3)
	public void getProductText() {
		logger.info("-----------------------Get Product Text test started--------------------------");
		lp.enter_username("standard_user");
		lp.enter_password("secret_sauce");
		lp.click_login();
	    String text=productpage.productText_saus_Lab_Backpack();
	    System.out.println("Product Text of saus_Lab_Backpack is: "+text);
	    logger.info("***********************Get Product Text test Ended***********************");		
	}
	

}
