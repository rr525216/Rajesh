package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class Config {
	private static Properties getProperties;

	private static final String setConfigFilePath = System.getProperty("user.dir")
			+ "/src/main/resources/set.properties";
//    private static final Properties getProperties;
	public final static HashMap<String, String> dynamicConfigs = new HashMap<>();
	public final static Map<String, Object> scenarioContext = new HashMap<>();
	public final static Map<String, Object> localdriver = new HashMap<>();
	static {
		try {
			InputStream is = null;
			getProperties = new Properties();
//Pass the path of the your config file here
			String currentDirectory = System.getProperty("user.dir");
			is = new FileInputStream(currentDirectory +"/src/test/resources"+ "/Get.properties");
			// is = new
			// FileInputStream("/Users/ashish.bhendarkar/Desktop/indirectios/OB_Mobile_Indirect/config.properties");
			getProperties.load(is);
		} catch (FileNotFoundException e) {
			System.out.println("file notfound");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return getProperties.getProperty(key);
	}

	// set and get into hashmap
	public static void setDynamicValue(String key, String value) {
		dynamicConfigs.put(key, value);
		// System.out.println("dynamic key: " +key+ " dynamic value: "+ value);
	}

	public static String getDynamicValue(String key) {
		return dynamicConfigs.get(key);
	}

	public static void setScenarioContext(String key, Object Value) {
		scenarioContext.put(key, Value);
	}

	public static Object getScenarioContext(String key) {
		return scenarioContext.get(key);
	}

	public static boolean isContains(String key) {
		return scenarioContext.containsKey(key);
	}

	public static void setDriver(String key, WebDriver value) {
		localdriver.put(key, value);
	}

	public static WebDriver getDriver(String key) {
		return (WebDriver) localdriver.get(key);
	}

}
