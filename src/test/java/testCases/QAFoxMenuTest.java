package testCases;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import utils.ScreenshotUtil;
import utils.TimestampUtil;
public class QAFoxMenuTest {

	WebDriver driver;
	int count = 0;
	
	@Test
	public void setup()
	{
		//This is a comment added from Github
		System.out.println("starting Execution : "+ TimestampUtil.getCurrentTimestamp());
		//for (int i = 0; i < 20; i++) {
			try {
				count++;
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new"); // Use --headless=new for Chrome 109+
				options.addArguments("window-size=1920,1080");
				options.addArguments("--disable-gpu");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
				//driver.manage().window().setSize(new Dimension(1920, 1080));
				driver.manage().window().maximize();
				System.out.println("Screen shot is taken : ");
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(
					    webDriver -> ((JavascriptExecutor) webDriver)
					        .executeScript("return document.readyState").equals("complete"));
				ScreenshotUtil.takeScreenshot(driver, "clickError");
				//again changing		
				
				driver.quit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				ScreenshotUtil.takeScreenshot(driver, "clickError");
			    throw e;
				//e.printStackTrace();
			}
		//}
		
		System.out.println("Ending Execution : "+ TimestampUtil.getCurrentTimestamp());
		
	}
	
	
}
