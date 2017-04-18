package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		Log.info("Test " + result.getName() + " Started !");		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("Test " + result.getName() + " Succeeded !");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Log.error("Test " + result.getName() + " Failed !");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Log.warn("Test " + result.getName() + " Skipped !");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		//Log.info("Suite Run Started !");
	}

	@Override
	public void onFinish(ITestContext context) {
		//Log.info("Suite Run Ended !");
	}

}
