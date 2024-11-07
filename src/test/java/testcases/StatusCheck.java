package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import locators.LocatorsTest;
import pagemethod.CheckStatus;
import base.TestBase;

//@Listeners(failedscreenshots.Listener.class)

public class StatusCheck extends TestBase{
	
	public CheckStatus cStatus;
	
	
	@Test
	public void checkStatuss() throws IOException {
		
		initilizeBrowser("chrome");
//		initilizeBrowser("firefox");
//		initilizeBrowser("edge");
		
	      cStatus = new CheckStatus();
		
	//	LocatorsTest loc = new LocatorsTest();
		
		cStatus.beforeStartingTraintoCheckStatus();
		cStatus.afterReachTrainDestinationtoCheckStatus();
		
		
	}
}
