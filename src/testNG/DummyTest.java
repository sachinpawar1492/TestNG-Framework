package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import testFunctions.FunctionsLibrary;
import utilities.Constants;

public class DummyTest {
	
	@BeforeClass
	public void beforeClass() throws Exception{
		FunctionsLibrary.initializeLog4J();
	}
	
	@Test(priority=1)
	public void openGuru() throws Exception{
		FunctionsLibrary.openBrowser(Constants.BrowserName, Constants.URL);
	}
	
	@Test(priority=2, dependsOnMethods="openGuru")
	public void loginGuru() throws Exception{
		FunctionsLibrary.loginGuru();
	}
	
	@Test(priority=3, dependsOnMethods="loginGuru")
	public void addNewCustomer() throws Exception{
		FunctionsLibrary.addNewCustomer();
	}
	
	@Test(priority=4)
	public void deleteCustomer() throws Exception{
		FunctionsLibrary.deleteCustomer();
	}

	@AfterClass
	public void closeBrowser() throws Exception{
		//FunctionsLibrary.closeBrowser();
	}
}
