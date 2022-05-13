package StepDefinition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


 
 
  @CucumberOptions(features=
 "E:\\SeleniumAutomation\\CucumberJava\\src\\test\\resources\\Test\\login.feature",
  glue= {"StepDefinition"}, monochrome=true,plugin=
  {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
 public class TestRunner extends AbstractTestNGCucumberTests 
  {
  
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