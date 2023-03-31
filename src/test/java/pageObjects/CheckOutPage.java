package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	
	  WebDriver driver;
		
	  public CheckOutPage(WebDriver driver) {			
			this.driver=driver;			
		}
	  
	  
	  By firstName=By.xpath("//input[@placeholder='First Name']");
	  
	  By lastName=By.xpath("//input[@placeholder='Last Name']");
	  
	  By zipCode=By.xpath("//input[@placeholder='Zip/Postal Code']");
	  
	  By continueBtn=By.xpath("//input[@id='continue']");
	  
	  By cancelBtn=By.xpath("//button[@name='cancel']");
	  
	  public void enter_firstName(String fname) {		  
		  driver.findElement(firstName).sendKeys(fname);		  
	  }
	  
 public void enter_lastName(String lname) {		  
		  driver.findElement(lastName).sendKeys(lname);		  
	  }
 
 public void enter_Zipcode(String zip) {	  
	  driver.findElement(zipCode).sendKeys(zip);	  
 }
	
 
 public void click_continue_Btn() {	  
	  driver.findElement(continueBtn).click();	  
}
	

}
