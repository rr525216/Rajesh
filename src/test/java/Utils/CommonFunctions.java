package Utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class CommonFunctions {

	public static WebDriver driver;

	static Scenario scenario;

	public static void takescreenshot(String screenshotName) {

		try {
			if (Config.isContains("Scenario")) {
				scenario = (Scenario) Config.getScenarioContext("Scenario");
				driver =Config.getDriver("driver");
				TakesScreenshot ts = (TakesScreenshot) driver;
				System.out.println("ts : "+ts);
				byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
				System.out.println("screenshot : "+screenshot);
				
//				scenario.attach(screenshot, "image/png", screenshotName);
				System.out.println("present driver2 :"+driver);
				File SrcFile = ts.getScreenshotAs(OutputType.FILE);
				String screenShotName = screenshotName + ".png";
				File destinationpath = new File(
						System.getProperty("user.dir" + "/target/screenshots/" + screenshotName));
				FileUtils.copyFile(SrcFile, destinationpath.getAbsoluteFile());
				scenario.attach(screenshot, "image/png", screenshotName);
			}
		} catch (Exception e) {
			System.out.println("Screen shot not found");
		}
	}

}
