package MasterData;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


 
 
  @CucumberOptions(features=
 "E:\\SeleniumAutomation\\CucumberJava\\src\\test\\resources\\Test\\homepage.feature",
  glue= {"MasterData"}, monochrome=true,plugin=
  {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
 public class Runner_MasterData extends AbstractTestNGCucumberTests 
  {
	  
	  @BeforeSuite
	  public void startMethod()
	  {
		  System.out.println("Before Suite is run");
	  }
	 
	  @AfterSuite
	  public void endMethod()
	  {
		  System.out.println("After Suite is run");

	  }
  
  }
  
  


/*
 * package StepDefinition;
 * 
 * import org.junit.runner.RunWith; import io.cucumber.junit.Cucumber;
 * 
 * import io.cucumber.testng.CucumberOptions;
 * 
 * //import io.cucumber.junit.CucumberOptions; import
 * io.cucumber.testng.AbstractTestNGCucumberTests;
 * 
 * 
 * //@RunWith(Cucumber.class)
 * 
 * // @CucumberOptions(features= //
 * "E:/SeleniumAutomation/CucumberJava/src/test/resources/Test/login.feature",
 * // glue= {"StepDefinition"}, monochrome=true,plugin= //
 * {"pretty","html:target/HtmlReports/report.html"}) // // // public class
 * TestRunner extends AbstractTestNGCucumberTests { // }
 * 
 * 
 * 
 * @RunWith(Cucumber.class)
 * 
 * @CucumberOptions(features=
 * "/CucumberwithExtent/src/test/resources/features.feature", glue=
 * {"StepDefinition"}, monochrome=true,plugin=
 * {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
 * public class TestRunner extends AbstractTestNGCucumberTests {
 * 
 * }
 * 
 
 */