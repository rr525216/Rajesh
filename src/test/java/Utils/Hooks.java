package Utils;

//import org.junit.After;
//import org.junit.Before;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static Utils.CommonFunctions.driver;

public class Hooks {
    Config conFig = new Config();
    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("Hooks before");
        System.out.println(scenario.getName());
        Config.setScenarioContext("Scenario", scenario);
    }

    @After
    public void afterScenario(final Scenario scenario) {
        if (scenario.isFailed()) {


            if (!(driver == null)) {

                try {

                    TakesScreenshot ts = (TakesScreenshot) driver;

                    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                    String screenshotName = scenario.getName().replaceAll(" ", "");
                    scenario.attach(screenshot, "image/png", screenshotName);
                } catch (Exception e) {
                    System.out.println("Screenshot not created....");
                }
            }

            driver.close();
        }
    }

}
