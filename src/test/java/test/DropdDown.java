package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdDown {
	

	@Test
	public void dropdown(){
		System.setProperty("webdriver.chrome.driver","D:\\Users\\deepak-r\\workspace\\DEEPAKMARS\\SeleniumPractice\\chromedriver.exe");
		//System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.get("https://www.facebook.com/");
WebElement Month=driver.findElement(By.xpath("//table/tbody/tr[3]/td[2]/div/a"));
System.out.println(Month.getAttribute("innerText"));
//driver.findElement(by.)
//table/tbody/tr[3]/td[2]/div/a
/*WebElement Month=driver.findElement(By.id("month"));
Select Option=new Select(Month);
WebElement el=Option.getFirstSelectedOption();
System.out.println(el.getText());
//test
List<WebElement> alloption=Option.getOptions();
System.out.println(alloption.size());
for(WebElement month:alloption){
	String Printmonth=month.getText();
	//System.out.println(Printmonth);
	if(Printmonth.equals("Jun")){
		month.click();
	
	}
}
	}*/
}}
