package Runner;



import org.junit.BeforeClass; 
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"Features"}, 
     glue = {"com.cg"}, 
     
     plugin = {
		"pretty",
		"json:target/cucumber-reports/Cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		},
     stepNotifications = true,
     tags = "@login", 
     dryRun = false,
     monochrome = true)
public class TestRunner {
	
	@BeforeClass
	public static void stupReportName() {
		
	}
}
