package test.report;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	public WebDriver driver;
	public void init(String btype){
		
		if(btype.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\Users\\deepak-r\\workspace\\DEEPAKMARS\\SeleniumPractice\\chromedriver.exe");
			driver=new ChromeDriver();
	 
		
	}
		else if(btype.equals("FireFox")){
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	public String takeScreenShot(WebDriver driver ,String screenNameandFormat) {
		Date d=new Date();
		screenNameandFormat=d.toString().replace(":", "_").replace(" ", "_")+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/ScreenShots/"+screenNameandFormat;
		try {
			FileUtils.copyFile(scrFile, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return destination;
		
		
		
		

	}
	
	
}
