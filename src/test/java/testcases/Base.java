package testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddToCartPage;
import pageObjects.CheckOutPage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.PaymentInfoPage;
import pageObjects.ProductsPage;
import utilities.WaitUtil;

public class Base {
	
public static   WebDriver driver;
public 	Logger logger;
TakesScreenshot ts;
public LoginPage lp;
public ProductsPage productsPage;
public ProductsPage productpage;
public AddToCartPage addCart;
 public WaitUtil wait;
public  CheckOutPage checkOutPage;
public	PaymentInfoPage paymentInfoPage;
public LogoutPage logoutpage;
	
static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());     //time stamp

	
	@BeforeMethod
	public void setup() {
		

	
		logger=Logger.getLogger("Sausdemo");
	    PropertyConfigurator.configure("Log4j.properties");
	    //for any browser
	//	ChromeOptions op=new ChromeOptions();
	//	op.addArguments("--remote-allow-origins=*");
	//	driver=new ChromeDriver(op);
		
		
//	    WebDriverManager.firefoxdriver();
//	    driver = new FirefoxDriver();
	    
//	    WebDriverManager.edgedriver();
//	    driver = new EdgeDriver();
	    
	  driver=new ChromeDriver();
		logger.info("-----------------Broswer has been invoked-----------------");
		lp=new LoginPage(driver);
		productsPage=new ProductsPage(driver);
		productpage=new ProductsPage(driver);
		addCart=new AddToCartPage(driver);
		wait=new WaitUtil();
		checkOutPage=new CheckOutPage(driver);
		paymentInfoPage=new PaymentInfoPage(driver);
		logoutpage=new LogoutPage(driver);
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(7000);
		driver.close();
		logger.info("***********************Broswer Terminated or closed***********************");
		
	}

	//taking screenshot
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+timeStamp+".png");
		FileUtils.copyFile(source, target);
		System.out.println("==========================Screenshot taken==============================");
	}


	
}

	

