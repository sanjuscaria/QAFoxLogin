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


public class QAfoxTest {
	
	WebDriver driver;
	int count = 0;
	
	@Test
	public void setup()
	{
		//This is a comment added from Github
		System.out.println("start : "+ TimestampUtil.getCurrentTimestamp());
		//for (int i = 0; i < 20; i++) {
			try {
				count++;
				ChromeOptions options = new ChromeOptions();
				//options.addArguments("--headless");
				options.addArguments("window-size=1920,1080");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
				driver.manage().window().setSize(new Dimension(1920, 1080));
				//driver.manage().window().maximize();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				driver.findElement(By.id("input-email")).sendKeys("fname1.lname1@gmail.com");
				driver.findElement(By.id("input-password")).sendKeys("pass");
				
				WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
				wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
				loginBtn.click();
//			//Assert.assertEquals(driver.getTitle(), "My Account");
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.titleContains("My Account"));
				//My Account
				WebElement element = driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/i/following-sibling::span"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				WebElement myAccount = driver
						.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/i/following-sibling::span"));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
//			//driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/i/following-sibling::span")).click();
//			//log out
				WebElement logout = driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/following-sibling::ul/li[5]/a"));
				wait.until(ExpectedConditions.elementToBeClickable(logout));
				logout.click();
//			System.out.println("title "+driver.getTitle());
//			System.out.println("count : "+count);
				
				driver.quit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				ScreenshotUtil.takeScreenshot(driver, "clickError");
			    throw e;
				//e.printStackTrace();
			}
		//}
		
		System.out.println("end : "+ TimestampUtil.getCurrentTimestamp());
		
	}
	
	
	

}
