package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pagemethod.TrainTracking;

public class LiveStatusoftheTrain extends TestBase{
	
	public TrainTracking train;
	
	@Test(priority=1)
	public void verifyEnteringTrainDetails() throws IOException {
		
		initilizeBrowser("chrome");
		train = new TrainTracking();
		train.enterTrainDetails();
	
	}

	@Test(priority =2)
	public void verifyAllStations() {
		
		train.getAllStationsList();
		
	}
	
	@Test(priority =3)
	public void verifyTrackingTrain() {
		train.trackTheTrain();
		
	}
	
	@Test(priority =4)
	public void verifyRemainingStationsAfterTracking() {
		train.leftStationstoReachDestination();
		
	}
}
