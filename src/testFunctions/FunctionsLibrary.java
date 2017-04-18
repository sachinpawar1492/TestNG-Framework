package testFunctions;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import operations.UIOperations;
import utilities.Constants;
import utilities.Log;

public class FunctionsLibrary {
	
	static WebDriver driver;
	static UIOperations operation = new UIOperations();
	
	static String value;
	static boolean bValue;
	
	public static void initializeLog4J() throws Exception{
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public static void openBrowser(String browserName, String URL) throws Exception{
		driver = UIOperations.selectBrowser(browserName);
		value = operation.perform(driver, "GoToURL", null, null, URL);
		Thread.sleep(2000);			
	}
	
	public static void loginGuru() throws Exception{
		value = operation.perform(driver, "SetText", "UserName", "NAME", Constants.UserName);
		value = operation.perform(driver, "SetText", "Password", "NAME", Constants.Password);
		value = operation.perform(driver, "Click", "Login", "NAME", null);		
		Thread.sleep(2000);
		value = operation.perform(driver, "ElementExists", "Manager", "LINK", null);
		bValue = operation.checkCondition(value, "True", "User logged in to Guru99 successfully !", "Login to Guru99 unsuccessful !");
		Assert.assertTrue(bValue);
	}
	
	public static void addNewCustomer() throws Exception{
		value = operation.perform(driver, "Click", "NewCustomer", "XPATH", null);
		Thread.sleep(3000);
		value = operation.perform(driver, "ElementExists", "AddNewCustomer", "XPATH", null);
		bValue = operation.checkCondition(value, "True", "User navigated to Add New Customer page successfully !", "Navigation to Add New Customer page unsuccessful !");
		Assert.assertTrue(bValue);
		value = operation.perform(driver, "SetText", "CustomerName", "NAME", "Sachin");
		value = operation.perform(driver, "SetText", "DateOfBirth", "NAME", "01-04-1992");
		value = operation.perform(driver, "SetText", "Address", "NAME", "Maarten Lutherweg 220");
		value = operation.perform(driver, "SetText", "City", "NAME", "Amstelveen");
		value = operation.perform(driver, "SetText", "State", "NAME", "North Holland");
		value = operation.perform(driver, "SetText", "PIN", "NAME", "118514");
		value = operation.perform(driver, "SetText", "MobileNo", "NAME", "031633745981");
		value = operation.perform(driver, "SetText", "EMail", "NAME", "sachin_pawar1482@gmail.com");
		value = operation.perform(driver, "SetText", "Password", "NAME", "Sachin");
		value = operation.perform(driver, "Click", "Submit", "NAME", null);
		Thread.sleep(3000);
		value = operation.perform(driver, "ElementExists", "RegistrationSuccess", "XPATH", null);
		bValue = operation.checkCondition(value, "True", "Customer Registered Successfully!!!", "Customer Registration Unsuccessful!!!");
		Assert.assertTrue(bValue);
		value = operation.perform(driver, "GETTEXT", "CustomerID", "XPATH", null);
		Log.info("Customer with Customer ID : " + value + " registered successfully !");
		value = operation.perform(driver, "Click", "Continue", "LINK", null);
	}
	
	public static void deleteCustomer() throws Exception{
		value = operation.perform(driver, "Click", "DeleteCustomer", "XPATH", null);
		Thread.sleep(3000);
		value = operation.perform(driver, "ElementExists", "DeleteCustomerForm", "XPATH", null);
		bValue = operation.checkCondition(value, "True", "User navigated to Delete Customer page successfully !", "Navigation to Delete Customer page unsuccessful !");
		Assert.assertTrue(bValue);
		value = operation.perform(driver, "SetText", "DeleteCustomerID", "NAME", "75711");
	}
	
	public static void closeBrowser() throws Exception{
		value = operation.perform(driver, "CloseBrowser", null, null, null);
	}

}
