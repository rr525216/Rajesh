package com.cg;

import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.addTestStepLog;

import java.io.File;
import java.io.IOException;





import Utils.CommonFunctions;
import Utils.Config;
import Utils.StringOccurence;
import Utils.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenStepDef {
	WebDriver driver;
	
	Scenario scenario;

	@Given("user is on login")
	public void userIsOnLogin() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		Config.setDriver("driver", driver);
		Config.setScenarioContext("Scenario", scenario);
		System.out.println(driver);
		driver.get("https://demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		

	}

	@When("user enter {string} and {string}")
	public void userEnterAnd(String string, String string2) throws InterruptedException, IOException {
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")).sendKeys(string);
		StringOccurence.highlightElement(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input")), driver);
	     Thread.sleep(10000);
	     TestContext testContext=new TestContext();
	     testContext.getCommonFunctions().takescreenshot("username");
//	     if(Config.isContains("Scenario")) {
//				scenario =(Scenario)Config.getScenarioContext("Scenario");
//				driver = Config.getDriver("driver");
//			TakesScreenshot ts=(TakesScreenshot)driver;
//			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshot,"image/png","frstshot");
//			File SrcFile=ts.getScreenshotAs(OutputType.FILE);
//			String screenShotName ="frstshot"+".png";
//			File destinationpath=new File(System.getProperty("user.dir"+"/target/screenshots/"+"frstshot"));
//			FileUtils.copyFile(SrcFile, destinationpath.getAbsoluteFile());
//			}
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys(string2);
		StringOccurence.highlightElement2(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")), driver);
		StringOccurence.highlightElement2(driver.findElement(By.xpath("//a[contains(text(),'Security Project')]")), driver);
		Thread.sleep(10000);
		addTestStepLog("Credentials entered with usernam : " + string + "and password : " + string2);
	}

	@Then("user click on login button")
	public void userClickOnLoginButton() {
		driver.findElement(By.name("btnLogin")).click();
		driver.switchTo().alert().accept();
//		driver.close();
	}

	@Then("close all browsers")
	public void close_all_browsers() {
		driver.quit();
	}
}
