package frontEndTesting;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DepositFundTest {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromeDriver\\chromeDriver.exe");
		driver =  new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
		driver.get("localhost:4200/login");
	}
	
	@Test
	public  void depositFundInPrimaryAccount() throws InterruptedException {
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("meetshah133@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("abc@1234");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.id("depositFundSection")).click();

		//Depositing money in primary account
		driver.findElement(By.id("amountToBeDeposited")).sendKeys("1000");
		
		driver.findElement(By.id("depositMoneyButton")).click();
		Thread.sleep(1000L);
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		assertEquals(message, "Money deposited successfully!!");
		alert.accept();
	}
	@Test
	public  void depositFundInSavingAccount() throws InterruptedException {
	
		driver.findElement(By.id("depositFundSection")).click();
		Select accounts = new Select(driver.findElement(By.id("accountType")));
		accounts.selectByIndex(1);
		//Depositing money in saving account
		driver.findElement(By.id("amountToBeDeposited")).sendKeys("1000");
		
		driver.findElement(By.id("depositMoneyButton")).click();
		Thread.sleep(1000L);
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		assertEquals(message, "Money deposited successfully!!");
		alert.accept();
	}
	
	@AfterTest
	public void cleanUp() {
		driver.close();
	}

}
