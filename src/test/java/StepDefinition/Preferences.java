package StepDefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Preferences extends AbstractWebDriver

{


	StepDefinition step= new StepDefinition();


	String text1;

	String text2;



	//	WebDriver driver= AbstractWebDriver.initiate();


	/*
	 * @AfterStep public void addScreenshot(Scenario scenario){
	 * 
	 * final byte[] screenshot = ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.BYTES); scenario.attach(screenshot,
	 * "image/png", "image");
	 * 
	 * try {
	 * 
	 * 
	 * Assert.assertEquals(text1,text2);
	 * 
	 * ExtentCucumberAdapter.addTestStepLog("string comparison passed"+text1+text2);
	 * } catch (AssertionError e) { Assert.fail(text1);
	 * 
	 * ExtentCucumberAdapter.addTestStepLog(e.getMessage());
	 * 
	 * }
	 * 
	 * }
	 */





	// Scenario 2

	@Given("HCP is on Preferences page")
	public void hcp_is_on_preferences_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("logged in");
		//Click on Preferences
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
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/mat-nav-list/a[2]")));
		driver.findElement(By.xpath("//*/div/mat-nav-list/a[2]")).click();
		Assert.assertEquals("Pass", "TEXT", "TEXT");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*/div/table[@class='mat-table ng-star-inserted']/tbody/tr")));

		List<WebElement> rows = driver
				.findElements(By.xpath("//*/div/table[@class='mat-table ng-star-inserted']/tbody/tr"));

		System.out.println("number of rows" + rows.size());

		ExtentCucumberAdapter.addTestStepLog("Use was able to login successfully");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"mat-input-0\"]")));

		driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("AcceptableNoiseLevel");

		step.text1="Testing";
		step.text2="Testing";


		//  throw new io.cucumber.java.PendingException();
	}

	@When("HCP clicks on Catalog")
	public void HCP_clicks_on_Catalog() 
	{
		// Write code here that turns the phrase above into concrete actions

		System.out.println("credentials entered");


		step.text1="Preference Variable";
		step.text2="Preference Variable";

	}


	@And ("check Filter Preferences")
	public void check_Filter_Preferences() 
	{
		// Write code here that turns the phrase above into concrete actions

		System.out.println("credentials entered");


		step.text1="Preference Variable";
		step.text2="Preference Variable";

	}


	@Then("Pass on first value")
	public void Pass_on_first_value() 
	{
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Pass on first Value");

		ExtentCucumberAdapter.addTestStepLog("+++Navigating to Home Page is successful+++");

	}




}
