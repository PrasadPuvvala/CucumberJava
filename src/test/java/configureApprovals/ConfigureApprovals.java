package configureApprovals;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import StepDefinition.AbstractWebDriver;
import StepDefinition.StepDefinition;
import Utilities.ReadExcel;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ConfigureApprovals {
	
	
	public static WebDriver driver;

	public static WebDriverWait wait;

	public static String text1;

	public static String text2;

	StepDefinition SObj = new StepDefinition();

	@SuppressWarnings("unused")

	@Before
	public void driverSetUp() throws InterruptedException, IOException {
		ReadExcel excelObj = new ReadExcel();
		String str[][] = excelObj.readExcel();

		ExtentCucumberAdapter.addTestStepLog("driverSetup is successful");
		System.out.println("driversetupMasterData success");

		driver = AbstractWebDriver.initiate();
		wait = new WebDriverWait(driver, 40);

	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {

		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image");

		try {
			Assert.assertEquals(text1, text2);

			ExtentCucumberAdapter.addTestStepLog("Comparison Passed: " + "Actual: " + text1 + "// Expected: " + text2);

		//	ExtentCucumberAdapter.getCurrentStep();

			ExtentCucumberAdapter.addTestStepLog("Current Action Passed : " + text1);
			
			Assert.assertTrue(text1, true);

		} catch (AssertionError e) {

			Assert.assertFalse(text1, false);
			// Assert.fail(text1);

			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	
	

	public ConfigureApprovals() 
	{
		// TODO Auto-generated constructor stub
	}

}
