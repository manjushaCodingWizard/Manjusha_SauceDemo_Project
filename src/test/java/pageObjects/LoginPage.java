package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
  public LoginPage(WebDriver driver) {	
		this.driver=driver;		
	}
	
 	By username=By.xpath("//input[@id='user-name']");                     
	By password=By.xpath("//input[@data-test='password']");
	By loginButton=By.xpath("//input[@name='login-button']");
	
	
	
	
	
	public void enter_username(String uName) {	
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(uName);		
	}
	
    public void enter_password(String pw) {		
    	driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pw);	
	}
	
	   public void click_login() {	
		driver.findElement(loginButton).click();
	}

}
