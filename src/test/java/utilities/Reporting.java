package utilities;

//Listener class used to generate Extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testcases.Base;

public class Reporting extends Base  implements ITestListener
{
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	String timeStamp;
	
		@BeforeTest()
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
		
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/Reports/"+repName);//specify location of the report
		
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Manjusha");
		
		htmlReporter.config().setDocumentTitle("Sausdemo Test Project"); // Tile of report
		htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report
		
		htmlReporter.config().setTheme(Theme.DARK);
	}
	@Test()
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	}
	@Test()
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		try {
		String	obj=tr.getMethod().toString();	
			String obj1=obj.replace(".", "/");
			String currentObj[] =obj1.split("/");
			String obj2 = currentObj[0].trim();
			captureScreen(driver,obj2);
			System.out.println(tr.getMethod().toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}
	@Test()
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	  @AfterTest()
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}
