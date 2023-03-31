package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//i am finding here elements by xpath
//also perfomring actions like click, getText

public class ProductsPage {
	
	WebDriver driver;
	
	  public ProductsPage(WebDriver driver) {			
			this.driver=driver;			
		}
	  
	  //Products
	    By header_Product=By.xpath("//span[@class='title']");	  
	 	By addToCartBtn_saus_Lab_Backpack=By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	 	By productLink_saus_Lab_Backpack=By.xpath("//div[.='Sauce Labs Backpack']");
	 	By price_saus_Lab_Backpack=By.xpath("//div[normalize-space()='$29.99']");		                     
		By addToCartBtn_sauce_Labs_Bike_Light=By.xpath("//button[@name='add-to-cart-sauce-labs-bike-light']");
		By addToCartBtn_sauce_Labs_Bolt_Tshirt=By.xpath("//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']");
		
		
		
		//Cart Link		
		By cartLink=By.xpath("//a[@class='shopping_cart_link']");
		
		
	//Action Methods		
  public Boolean disply_Header_Title() {			
		return	driver.findElement(header_Product).isDisplayed();			
		}
		
		public void aadCart_saus_Lab_Backpack() {			
			driver.findElement(addToCartBtn_saus_Lab_Backpack).click();			
		}
		
         public void productLinkClick_saus_Lab_Backpack() {			
			driver.findElement(productLink_saus_Lab_Backpack).click();			
		}
         
         public String getPrice_saus_Lab_Backpack() { 			
        	 String text=driver.findElement(price_saus_Lab_Backpack).getText();
        	 return text; 			
 		}
		
         public String productText_saus_Lab_Backpack() { 			
 			String text=driver.findElement(productLink_saus_Lab_Backpack).getText();
 			return text; 			
 		}
		
		public void addCart_sauce_Labs_Bike_Light() {			
			driver.findElement(addToCartBtn_sauce_Labs_Bike_Light).click();
		}
		
		
//Click Cart Link
		
		public void clickCartLink() {			
			driver.findElement(cartLink).click();		
		}
	
}
