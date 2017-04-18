package operations;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utilities.Log;
import utilities.ReadObjects;

public class UIOperations{
	
	static ReadObjects object = new ReadObjects();
	static Properties allObjects = object.getObjectRepository();
	
	public String perform(WebDriver driver, String operation, String objectName, String objectType, String value) throws Exception{
		switch (operation.toUpperCase()){
		case "CLICK":
			//Perform click
			driver.findElement(this.getObject(objectName, objectType)).click();
			Log.info("Clicked on " + objectName + " successfully !");
			break;
		case "SETTEXT":
			//Set text on control
			driver.findElement(this.getObject(objectName, objectType)).sendKeys(value);
			break;
		case "GOTOURL":
			//Open URL of the application
			driver.get(value);
			Log.info("Web application " + value + " launched successfully");
			break;
		case "GETTEXT":
			//Get text of an element
			value = driver.findElement(this.getObject(objectName, objectType)).getText();
			break;
		case "ELEMENTEXISTS":
			//Check whether web element exists
			boolean bValue = driver.findElement(this.getObject(objectName, objectType)).isDisplayed();
			value = Boolean.toString(bValue);
			break;
		case "CLOSEBROWSER":
			//Close browser
			driver.quit();
			break;
		default:
			break;
		}
		return value;
	}
	
	public static WebDriver selectBrowser(String browserName){
		WebDriver driver = null;
		
		if(browserName.equalsIgnoreCase("Mozilla")){
			System.setProperty("webdriver.gecko.driver", "D:\\\\Setups\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Chrome")){
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")){
			driver = new InternetExplorerDriver();
		}
		
		Log.info("New " + browserName + " driver instantiated");
		
		return driver;		
	}
	
	public boolean checkCondition(String value, String condition, String ifTrueMsg, String ifFalseMsg){
		if(value.equalsIgnoreCase(condition)){
			Log.info(ifTrueMsg);
			return true;
		}
		else{
			Log.error(ifFalseMsg);
			return false;
		}		
	}
	
	private By getObject(String objectName, String objectType) throws Exception{
		//Find by xpath
		if(objectType.equalsIgnoreCase("XPATH")){
			return By.xpath(allObjects.getProperty(objectName));
		}
		//Find by class
		else if(objectType.equalsIgnoreCase("CLASSNAME")){
			return By.className(allObjects.getProperty(objectName));
		}
		//Find by name
		else if(objectType.equalsIgnoreCase("NAME")){
			return By.name(allObjects.getProperty(objectName));
		}
		//Find by link
		else if(objectType.equalsIgnoreCase("LINK")){
			return By.linkText(allObjects.getProperty(objectName));
		}
		//Find by partial link
		else if(objectType.equalsIgnoreCase("PARTIALLINK")){
			return By.partialLinkText(allObjects.getProperty(objectName));
		}
		else{
			throw new Exception("Wrong object type");
		}
	}
}
