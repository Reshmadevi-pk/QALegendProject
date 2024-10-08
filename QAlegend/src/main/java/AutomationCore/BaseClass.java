package AutomationCore;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.offline.OfflineResxDelegate;
import com.google.common.io.Files;

public class BaseClass {
	public WebDriver driver; // WebDriver is is an interface in Selenium that provides methods to interact with the browser.
    public String excelFilePath="//src//main//java//resources//Userdetails.xlsx";
	public WebDriver browserIntialization(String browsername)
	{
	if(browsername.equalsIgnoreCase("Chrome"))
	{
	driver = new ChromeDriver();
	}
	else if(browsername.equalsIgnoreCase("Edge"))
	{
	driver = new EdgeDriver();
	}
	else if(browsername.equalsIgnoreCase("Firefox"))
	{
	driver = new FirefoxDriver();
	}
	else
	{
	System.out.println("Invalid Browser name");
	}
	//driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	}
	public String getScreenShotPath(String testcasename,WebDriver driver) throws Exception {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationfile=System.getProperty("user.dir")+"\\test-output\\"+testcasename+".png";
		Files.copy(source, new File(destinationfile));
		return destinationfile;
		
	}
}
