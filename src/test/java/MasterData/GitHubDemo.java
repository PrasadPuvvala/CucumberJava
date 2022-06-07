
package MasterData;

import org.openqa.selenium.support.ui.WebDriverWait;

import StepDefinition.*;

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


	

public class GitHubDemo {
	
	   static int age=2;
	   static WebDriver driver;
	   static WebDriverWait wait;


	public GitHubDemo() 
	{
		// TODO Auto-generated constructor stub
	  age=age+1;	
	
	}
	
	public static void testGit1(WebDriver driver) throws InterruptedException, IOException {
		
//		age=age+1;
//		System.out.println("age is"+age);
		
		
		try {
			driver.findElement(By.xpath("//*/div[@id='idDiv_SAOTCS_Proofs']/div[2]/div/div/div[2]")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/mat-nav-list/a[6]")));
			driver.findElement(By.xpath("//*/div/mat-nav-list/a[6]")).click();
			

		} catch (NoSuchElementException e) {
			System.out.println("Handled exception");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/mat-nav-list/a[6]")));
			driver.findElement(By.xpath("//*/div/mat-nav-list/a[6]")).click();

			
		}

		// Click on Releases Catalog
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/mat-nav-list/a[2]")));
		driver.findElement(By.xpath("//*/div/mat-nav-list/a[2]")).click();
		Assert.assertEquals("Pass", "TEXT", "TEXT");

		

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*/div/table[@class='mat-table']/tbody/tr")));

		List<WebElement> rows = driver.findElements(By.xpath("//*/div/table[@class='mat-table']/tbody/tr"));

		System.out.println("number of rows in MasterDataPage" + rows.size());
		
		
		
		String text1 = driver.findElement(By.xpath("//*/div/table[@class='mat-table']/tbody/tr[6]/td[2]")).getText();
		driver.findElement(By.xpath("//*/div/input[@id='mat-input-0']")).sendKeys(text1);

		String date= driver.findElement(By.xpath("//*/table/tbody/tr[1]/td[6]")).getText();
		String PM= driver.findElement(By.xpath("//*/table/tbody/tr[1]/td[7]")).getText();
		String PDM = driver.findElement(By.xpath("//*/table/tbody/tr[1]/td[8]")).getText();

		
		System.out.println("date"+ date + "PM Name : "+ PM + "PDM Name : "+ PDM);
		
	}

	
	
	
	public static class test
	
	{
		public void testing()
		
		{
			
		}
		
		public static void main(String args[]) throws InterruptedException, IOException
		
		{
		//	GitHubDemo.age=4;
			
			
			driver = AbstractWebDriver.initiate();
			wait = new WebDriverWait(driver, 40);
			GitHubDemo.testGit1(driver);
			
			

		}
		
		
	}
	
}



