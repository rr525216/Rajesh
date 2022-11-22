package com.cg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDef {
	
	WebDriver driver;

	@Given("user is on Signin  page")
	public void userIsOnSigninPage() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  
	 driver.get("https://www.browserstack.com/users/sign_in");
	  
	  
	}
	@Then("user enters {string} and {string}")
	public void userEntersAnd(String string, String string2) {
		driver.findElement(By.xpath("//*[@id=\"user_email_login\"]")).sendKeys(string);
		driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys(string2);
	}
	@Then("user click on singnin button")
	public void userClickOnSingninButton() {
	   driver.findElement(By.xpath("//*[@id=\"user_submit\"]")).click();
	}

	
}
