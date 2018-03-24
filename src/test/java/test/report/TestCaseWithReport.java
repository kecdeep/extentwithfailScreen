package test.report;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestCaseWithReport extends BaseTest{
	public ExtentReports extent ;
	public ExtentTest test;
	
	@BeforeTest
	public  void  setUpReport(){
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
	}
	@Test
	public void ValidateLogo() {
		test=extent.startTest("First Test case");
		init("Chrome");
		driver.get("https://www.facebook.com/");
		test.log(LogStatus.INFO, "open browser");
		WebElement Month=driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]/div/a"));
		test.log(LogStatus.INFO, "open browser");
		String month=Month.getAttribute("innerText");
		Assert.assertEquals(month, "deepak");
	}
	
	@AfterMethod
	public void quit(ITestResult result){
   if(result.getStatus()==ITestResult.FAILURE){
	   test.log(LogStatus.INFO, "tets case name"+result.getName());
	   test.log(LogStatus.INFO, "tets case name"+result.getThrowable());

	   String addedScreenI=takeScreenShot(driver, result.getName());
	   test.log(LogStatus.INFO, test.addScreenCapture(addedScreenI));
	   
   }
   driver.quit();
	}
	
@AfterTest
public void endReport(){
	extent.flush();
	extent.endTest(test);
}
}