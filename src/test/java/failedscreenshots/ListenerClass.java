package failedscreenshots;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import base.TestBase;

public class ListenerClass extends TestBase implements ITestListener {
	
	@Test
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test is failed "+result.getName());
		
		try {
			
			captureScreenshots(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

}
