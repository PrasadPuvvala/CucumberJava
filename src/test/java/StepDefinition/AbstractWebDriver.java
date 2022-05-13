package StepDefinition;
import Utilities.*;

import java.io.IOException;
import java.rmi.AccessException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public abstract class AbstractWebDriver 

{
	static WebDriver driver;
	static WebDriverWait wait;
	
	protected static WebDriver initiate() throws InterruptedException, IOException
	{
	    ReadExcel  excelObj= new ReadExcel();
	    String str[][]=excelObj.readExcel();

		
		System.setProperty("webdriver.chrome.driver",
				"E://SeleniumAutomation//chromedriver100.0.4896//chromedriver.exe");
		// Creating an object of ChromeDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 40);

		ExtentCucumberAdapter.addTestStepLog("+++AbstractdriverSetup is successful+++");

		driver.get("https://tstpreferences.gnodinservices.com/");
		// explicit wait - to wait for the compose button to be click-able
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
		// click on the compose button as soon as the "compose" button is visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("loginfmt")));
		driver.findElement(By.name("loginfmt")).sendKeys(str[1][0]);
		//		driver.findElement(By.xpath("//*[@name='loginfmt']")).sendKeys("ppuvvala@gnresound.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
		driver.findElement(By.id("idSIButton9")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='passwd']")));
		driver.findElement(By.xpath("//*[@name='passwd']")).sendKeys(str[1][1]);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idSIButton9")));
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(10000);
		
	return driver;
	}
	public AbstractWebDriver() {
		// TODO Auto-generated constructor stub
	}

}
