package end2endframework;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.BaseUtility;

public class Listeners extends BaseUtility implements ITestListener   {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		try {
			screenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Error while taking screenshot");
		}
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		try {
			screenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Error while taking screenshot");
		}
		
	}

	public void onTestFailure(ITestResult result) {
		try {
			screenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Error while taking screenshot");
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
}
