package com.cg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class GoogleSaerchStepDef {
	WebDriver driver;

	@Given("user should be on google")
	public void user_should_be_on_google() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("user enters text to search")
	public void user_enters_text_to_search() {
		WebElement searchBox=driver.findElement(By.name("q"));
		
		searchBox.sendKeys("java 8 features");
	}

	@When("click on google saerch button")
	public void click_on_google_saerch_button() {
		WebElement btn=driver.findElement(By.name("btnK"));
		btn.submit();
	}

	@Then("multi[le results on that topic should be displayed")
	public void multi_le_results_on_that_topic_should_be_displayed() {
		
	}
	
	@When("user click on images link")
	public void user_click_on_images_link() {
		
		 driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[2]/a")).click();
	  
	}
	@When("user enter text to saerch image and submit")
	public void user_enter_text_to_saerch_image_and_submit() {
WebElement searchBox=driver.findElement(By.name("q"));
		
		searchBox.sendKeys("rose");
		searchBox.submit();
	}
	
	@Then("title should change according top search text")
	public void title_should_change_according_top_search_text() {
	    String actualTitle="rose - Google Search";
	    String expectedTitle=driver.getTitle();
	    Assert.assertEquals(expectedTitle, actualTitle);
	    
	}

}
