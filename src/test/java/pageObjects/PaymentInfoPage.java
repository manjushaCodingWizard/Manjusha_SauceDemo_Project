package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentInfoPage {
	
	
	 WebDriver driver;
		
	  public PaymentInfoPage(WebDriver driver) {			
			this.driver=driver;			
		}
	
	
      By finish_Btn=By.xpath("//button[@name='finish']");
	  
	  By cancel_Btn=By.xpath("//button[@name='finish']");
	  
	  By total_Price=By.xpath("//div[@class='summary_info_label summary_total_label']");
	  
	  
	  public void click_finish_Btn() {		  
		  driver.findElement(finish_Btn).click();		  
	  }
	  
	  
	  public String getTotalPrice() {		  
			String total= driver.findElement(total_Price).getText();
			String text[] =total.split(":");
			String totalCost =text[text.length-1].trim();
			return totalCost;		  
	  }
	  
	

}
