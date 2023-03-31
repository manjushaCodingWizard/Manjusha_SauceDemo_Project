package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
	
	   WebDriver driver;
	
	  public AddToCartPage(WebDriver driver) {
			this.driver=driver;			
		}
	  
	  
	  By checkOut_Button=By.xpath("//button[@name='checkout']");	  
	  By continueShopping_Button=By.xpath("//button[@name='continue-shopping']");	  
	  By openMenu_Button=By.xpath("//button[.='Open Menu']");	  
	  
	  
	  public void click_checkOut_Button() {		  
		  driver.findElement(checkOut_Button).click();		  
	        }
	  
	  
      public void click_continueShopping_Button() {		  
		  driver.findElement(continueShopping_Button).click();		  
	  }
      
      
  public void click_OpenMenu_Button() {		  
		  driver.findElement(openMenu_Button).click();		  
	  }
	  
	  

}
