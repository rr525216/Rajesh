package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StringOccurence {
	
	public static void highlightElement(WebElement element,WebDriver driver) {
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style','border:3px solid black; background:green')",element);
		
		
	}
	
	public static void highlightElement2(WebElement element,WebDriver driver) {
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style','border:3px solid red; background:pink')",element);
		
		
	}

}
