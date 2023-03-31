package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import utilities.XLUtils;

public class LoginDatadrivenTest extends Base {	
	
	@Test(priority=1,dataProvider="LoginDataProvider")
	public void loginDatadriven(String username,String pwd) {
		
		logger.info("-----------------------------Datadriven Login Testcase is starting now------------------------------ ");		
		lp.enter_username(username);
		lp.enter_password(pwd);
		lp.click_login();

		String title=driver.getTitle();
		System.out.println("Page title is :  "+title);
	    Boolean value=productsPage.disply_Header_Title();
	    System.out.println(value);
	    Assert.assertEquals(true, value);

	   logger.info("*****************************Datadriven Login Testcase Ended***************************");
		
	}
	
	
	
	
	
	@DataProvider(name="LoginDataProvider")
	public String[][] userDataProvider() throws IOException{
		String filePath="./DataFiles/loginData.xlsx";
		XLUtils xl=new XLUtils(filePath);
		int rows=xl.getRowCount("Sheet1");
		System.out.println("Number of Rows are: "+rows);
		int colums=xl.getCellCount("Sheet1",1);
		System.out.println("Number of Colums are: "+colums);
		String[][] userdata=new String[rows][colums];
		
		for(int i=1;i<=rows;i++) {			
			for(int j=0;j<=colums-1;j++) {			
				userdata[i-1][j]=xl.getCellData("Sheet1",i,j);			
				}				
		}
		
		return userdata;		
	}

}
