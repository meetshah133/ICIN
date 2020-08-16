package frontEndTesting;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import   frontEndTesting.LoginTest;


public class TransferFundTest {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromeDriver\\chromeDriver.exe");
		driver =  new ChromeDriver(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("localhost:4200");
	}
	
	@Test
	public void transferFund() throws InterruptedException  {
		
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("meetshah133@gmail.com");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("abc@1234");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.linkText("Transfer")).click();;
		
		//Filling Up transfer fund form
		driver.findElement(By.id("beneficiaryName")).sendKeys("Sunil Vyas");
		driver.findElement(By.id("beneficiaryAccountNumber")).sendKeys("110004445551");
		driver.findElement(By.id("beneficiaryIFSCCode")).sendKeys("ICIN00105");
		driver.findElement(By.id("amountToBeTransfered")).sendKeys("100");
		driver.findElement(By.id("description")).sendKeys("Fund Transfer");
		driver.findElement(By.id("tranferFundButton")).click();
		Thread.sleep(2000L);
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		//assertEquals(text, "Transaction Successfull");
		
		

		

	}
	
	@AfterTest
	public void cleanUp() {
		//driver.close();
	}
}
