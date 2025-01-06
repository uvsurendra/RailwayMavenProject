package testcases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.TestBase;
import pagemethod.TrainTimeTable;

//@Listeners(failedscreenshots.Listener.class)

@Listeners(failedscreenshots.ListenerClass.class)
public class TimeTableoftheTrain extends TestBase{
	
	public TrainTimeTable timeTable;
	
	@Test(priority = 1)
	public void verifyEnteringTrainDetails() throws IOException {
		
		initilizeBrowser("chrome");
		timeTable = new TrainTimeTable();
		timeTable.enterTrainDeatils();
		
	}
	
	@Test(priority = 2)
	public void verifyTrainDetails() {
		
		timeTable.checkTrainDetails();
		
	}
	
	@Test(priority = 3)
	public void verifyPlatformDetails() {
		
		timeTable.checkPlatformDetails();
		
	}
	
	@Test(priority = 4)
	public void verifyFoodDetails() {
		timeTable.foodInformation();
		
	}
	
	@Test(priority = 5)
	public void verifyTimeTableDetails() {
		
		timeTable.checkTimeTable();
		
	}
	

}
