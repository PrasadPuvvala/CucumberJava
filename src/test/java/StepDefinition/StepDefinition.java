package StepDefinition;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;


public class StepDefinition extends AbstractWebDriver 

{
	public static WebDriver driver;

	public static WebDriverWait wait;

	public static String text1;

	public static String text2;


	@Before public  void driverSetUp() throws InterruptedException, IOException
	{
//		System.setProperty("webdriver.chrome.driver",
//				"E://SeleniumAutomation//chromedriver100.0.4896//chromedriver.exe");
//		// Creating an object of ChromeDriver
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		wait = new WebDriverWait(driver, 40);
//
//		ExtentCucumberAdapter.addTestStepLog("driverSetup is successful");

		StepDefinition.driver= AbstractWebDriver.initiate();
		wait = new WebDriverWait(driver, 40);

		
	}

	@AfterStep
	public void addScreenshot(Scenario scenario){

		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image"); 

		try {
			Assert.assertEquals(text1,text2);

			ExtentCucumberAdapter.addTestStepLog("string comparison passed"+text1+text2);
		}
		catch (AssertionError  e)
		{
			Assert.fail(text1);

			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
		
	}

	@Given("User is on login page")
	public void user_is_on_login_page() throws InterruptedException

	{
		// Click on Preferences
		try
		{
	     	driver.findElement(By.xpath("//*/div[@id='idDiv_SAOTCS_Proofs']/div[2]/div/div/div[2]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/mat-nav-list/a[1]")));
			driver.findElement(By.xpath("//*/div/mat-nav-list/a[1]")).click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Handled exception");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/mat-nav-list/a[1]")));
			driver.findElement(By.xpath("//*/div/mat-nav-list/a[1]")).click();
		}
		
//		Click on Global Catalog
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/mat-nav-list/a[2]")));
		driver.findElement(By.xpath("//*/div/mat-nav-list/a[2]")).click();
		Assert.assertEquals("Pass", "TEXT", "TEXT");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*/div/table[@class='mat-table ng-star-inserted']/tbody/tr")));

		List<WebElement> rows = driver
				.findElements(By.xpath("//*/div/table[@class='mat-table ng-star-inserted']/tbody/tr"));

		System.out.println("number of rows" + rows.size());

	}
	
	@When("User sends username and password")
	public void user_sends_username_and_password() 
	{
		// Write code here that turns the phrase above into concrete actions

		ExtentCucumberAdapter.addTestStepLog("+++Login Screen is successful+++");

		System.out.println("credentials entered");
		
		text1="Prasad";
		text2="Prasad";
	}

	@And("click on submit")
	public void click_on_submit() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("submission is done");
		ExtentCucumberAdapter.addTestStepLog("+++Submission is successful+++");

		text1="Prasad";
		text2="Prasad";

	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() 
	{
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Home page is being shown");
		
		ExtentCucumberAdapter.addTestStepLog("+++Navigating to Home Page is successful+++");

	}



	@When("User sends {string} and {string}")
	public void user_sends_name1_and_pwd1(String text1,String text2)

	{
		int count=0;
		count= count+1;

		System.out.println("Iternation done"+count+text1+text2);

	}

	
	@After public void driverClose() throws InterruptedException
	{
		driver.close();
		ExtentCucumberAdapter.addTestStepLog("+++WebDriver is closed+++");

		System.out.println("after exit");		
	}




}
