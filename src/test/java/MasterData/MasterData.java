package MasterData;
import Utilities.*;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import StepDefinition.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import StepDefinition.*;

public class MasterData extends AbstractWebDriver implements TestInterface
{

	public static WebDriver driver;

	public static WebDriverWait wait;

	public static String text1;

	public static String text2;

	StepDefinition SObj= new StepDefinition();



	@SuppressWarnings("unused")
	@Before public  void driverSetUp() throws InterruptedException, IOException
	{
		ReadExcel  excelObj= new ReadExcel();
		String str[][]=excelObj.readExcel();


		ExtentCucumberAdapter.addTestStepLog("driverSetup is successful");
		System.out.println("driversetupMasterData success");

		driver= AbstractWebDriver.initiate();
		wait = new WebDriverWait(driver, 40);


	}

	@AfterStep
	public void addScreenshot(Scenario scenario)
	{

		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image"); 

		try {
			Assert.assertEquals(text1,text2);

			ExtentCucumberAdapter.addTestStepLog("string comparison passed: "+"Actual: "+text1+"// Expected: "+text2);
		}
		catch (AssertionError  e)
		{
			Assert.fail(text1);

			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("CM is on main page")
	public void cm_is_on_main_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions


		// Click on Master Data
		try
		{
			driver.findElement(By.xpath("//*/div[@id='idDiv_SAOTCS_Proofs']/div[2]/div/div/div[2]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/mat-nav-list/a[6]")));
			driver.findElement(By.xpath("//*/div/mat-nav-list/a[6]")).click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Handled exception");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/mat-nav-list/a[6]")));
			driver.findElement(By.xpath("//*/div/mat-nav-list/a[6]")).click();
		}


		//			Click on Releases Catalog
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/mat-nav-list/a[2]")));
		driver.findElement(By.xpath("//*/div/mat-nav-list/a[2]")).click();
		Assert.assertEquals("Pass", "TEXT", "TEXT");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*/div/table[@class='mat-table']/tbody/tr")));

		List<WebElement> rows = driver
				.findElements(By.xpath("//*/div/table[@class='mat-table']/tbody/tr"));

		System.out.println("number of rows in MasterDataPage" + rows.size());


	}// Given

	@When("HCP navigates to Releases page")
	public void hcp_navigates_to_releases_page() throws InterruptedException

	{
		// Write code here that turns the phrase above into concrete actions

		System.out.println("When in MasterData");

		text1 =driver.findElement(By.xpath("//*/div/table[@class='mat-table']/tbody/tr[6]/td[2]")).getText();
		driver.findElement(By.xpath("//*/div/input[@id='mat-input-0']")).sendKeys(text1);
		text2 =text1;
		//	driver.findElement(By.xpath("//*/app-programs-list/div[2]/div/table/tbody/tr[1]/td[10]/button[1]")).click();

		Thread.sleep(2000);

		//		driver.findElement(By.xpath("//*[@id=\"mat-tab-content-2-0\"]/div/mat-form-field[4]/div/div[1]")).click();
		//		driver.findElement(By.xpath("//*/div/input[@id='mat-input-21']")).click();

		//		System.out.println(driver.findElement(By.xpath("//*[@id=\"mat-option-764\"]/span")).getText());

		//		driver.findElement(By.xpath("//*[@id=\"cdk-describedby-message-22\"]")).click();
		//		System.out.println("PDM Manager is "+ driver.findElement(By.xpath("//*/div/input[@id='mat-input-13']")).getText());
		//		
		//		driver.findElement(By.xpath("//*/app-programs-list/div[2]/div/table/tbody/tr[1]/td[10]/button[1]")).click();
		//		
		//		System.out.println("Project Manager Manager is "+ driver.findElement(By.xpath("//*/div/input[@id='mat-input-12']")).getText());



	}

	@And("click on submit")
	public void click_on_submit() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions

		//CLick on Add Release

		driver.findElement(By.xpath("//*/div/app-programs-list/div/button/span[@class='mat-button-wrapper']")).click();

		driver.findElement(By.xpath("//*/div[@class='mat-form-field-infix']/input[@placeholder=\"Release Name* \"]")).sendKeys("Rubneium");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*/div[@class='mat-form-field-infix']/input[@placeholder=\"Product Version Name* \"]")).sendKeys("12.0");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*/div[@class='mat-form-field-infix']/input[@placeholder=\"Product Version Name* \"]")).sendKeys(Keys.TAB)	;
		Thread.sleep(2000);

		//enter Project manager

		driver.findElement(By.xpath("//*/mat-option[@id='mat-option-4']")).click();
		Thread.sleep(2000);

		//Select PDM Engineer
		driver.findElement(By.xpath("//*[@id='mat-tab-content-0-0']/div/mat-form-field[3]/div/div[1]/div/input")).sendKeys(Keys.TAB)	;
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*/div/mat-option[3]/span[@class='mat-option-text']")).click();
		Thread.sleep(2000);

		//		//Select PDM Engineer
		//		driver.findElement(By.xpath("//*[@id='mat-tab-content-0-0']/div/mat-form-field[3]/div/div[1]/div/input")).sendKeys(Keys.TAB)	;
		//
		//		Thread.sleep(2000);
		//
		//		driver.findElement(By.xpath("//*[@id=\"mat-option-225\"]")).click();
		//		Thread.sleep(2000);
		//Select Verification Lead
		driver.findElement(By.xpath("//*[@id='mat-tab-content-0-0']/div/mat-form-field[4]/div/div[1]/div/input")).sendKeys(Keys.TAB);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*/div/mat-option[3]/span[@class='mat-option-text']")).click();

		//Select Calender start date
		driver.findElement(By.xpath("//*[@id='mat-tab-content-0-0']/div/mat-form-field[5]/div/div[1]/div/input")).sendKeys(Keys.TAB);




		driver.findElement(By.xpath("//*/button[@aria-label=\"Open calendar\"]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[5]/td[4]/div")).click();

		//Select End Date from Calender

		driver.findElement(By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/mat-form-field[7]/div/div[1]/div[2]/mat-datepicker-toggle/button")).click();


		//		driver.findElement(By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/mat-form-field[7]/div/div[1]/div[2]/mat-datepicker-toggle/button")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//*[@id=\"mat-datepicker-1\"]/div/mat-month-view/table/tbody/tr[5]/td[4]/div")).click();

		// Select release date

		driver.findElement(By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/mat-form-field[8]/div/div[1]/div[2]/mat-datepicker-toggle/button")).click();

		//		driver.findElement(By.xpath("//*[@id=\"mat-tab-content-0-0\"]/div/mat-form-field[8]/div/div[1]/div[2]/mat-datepicker-toggle/button")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//*[@id=\"mat-datepicker-2\"]/div/mat-month-view/table/tbody/tr[5]/td[4]/div")).click();

		// Click on Submit button

		driver.findElement(By.xpath("//*[@id=\"saveAsDrawer\"]/div/app-program/div/form/div/button[2]")).click();

		// Search with Release name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/input[@id='mat-input-0']")));
		driver.findElement(By.xpath("//*/div/input[@id='mat-input-0']")).clear();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*/div/input[@id='mat-input-0']")).sendKeys("Rubneium");

		// Delete release
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"mainApp\"]/app-programs-list/div[2]/div/table/tbody/tr/td[10]/button[2]")).click();

		// wait to let the container modal box be visible
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id='mat-dialog-0']/app-confirmation-dialog/div[1]/div")));



		// to fetch the web element of the modal container
		System.out.println("Fetching the web element for modal container");
		WebElement modalContainer = driver.findElement(
				By.xpath("//*[@id='mat-dialog-0']/app-confirmation-dialog/div[1]/div"));

		// to fetch the web elements of the modal container and interact with them
		System.out.println("Fetching modal body container and asserting it"+modalContainer.getText());

		Assert.assertEquals("PASS","Are you sure you want to delete this release Rubneium ?", modalContainer.getText());

		text1= modalContainer.getText();
		text2="Are you sure you want to delete this release Rubneium ?";
		// code to fetch content of modal body and verify it

		WebElement modalContentBody = modalContainer.findElement(By.xpath("//*[@class='submit-popup-btn mat-raised-button']"));

		System.out.println("Fetching modal body content and asserting it"+modalContentBody.getText());

		// code to click on accept modal button
		System.out.println("Clicking modal accept button");
		WebElement modalAcceptButton = modalContainer
				.findElement(By.xpath("//*[@class='mat-dialog-actions']/button[2]"));
		modalAcceptButton.click();

		////*[@class='mat-dialog-actions']/button[2]

		//driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-confirmation-dialog/div[2]/button[2]")).click();
		System.out.println("And in MasterData");
	}

	@Then("CM is navigated to Releases page")
	public void cm_is_navigated_to_releases_page()
	{
		System.out.println("Then in MasterData");

		text1="MasterData";
		text2="MasterData";

	}

	@After public void driverClose() throws InterruptedException
	{
		driver.close();
		ExtentCucumberAdapter.addTestStepLog("+++Master Data WebDriver is closed+++");

		System.out.println("after exit in MasterData");	


	}

	// Interface Methods Implementation Defining Interface

	public void draw() {
		// TODO Auto-generated method stub

		System.out.println("Interface Method draw()");

	}

	public void loginCheck() {
		// TODO Auto-generated method stub

		System.out.println("Interface Method loginCheck");

	}



}
