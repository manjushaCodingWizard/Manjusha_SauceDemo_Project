package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	
	  WebDriver driver;
		
	  public LogoutPage(WebDriver driver) {			
			this.driver=driver;			
		}
	  
	  
	  By logOut=By.xpath("//a[normalize-space()='Logout']");
	  
	  By orderCompleteText=By.xpath("//div[@class='complete-text']");
	  
	  By openMenu_Panel=By.xpath("//button[.='Open Menu']");
	  
	  
	  public void click_MenuPanel() {
		  driver.findElement(openMenu_Panel).click();		  
	        }
	  
	  
      public void click_logOut() {
		  driver.findElement(logOut).click();
	  }
      
      
  public String orderCompleteText() {
		String orderDone= driver.findElement(orderCompleteText).getText();
		return orderDone;
	  }
	  
	  
	
	
	

}
