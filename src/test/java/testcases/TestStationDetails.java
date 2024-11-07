package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import pagemethod.StationDeatails;

public class TestStationDetails extends TestBase{
	public StationDeatails ss;
	
	@Test
	public void checkStationDeatils() throws IOException {
		
		initilizeBrowser("chrome");
//		initilizeBrowser("firefox");
		//initilizeBrowser("edge");
				
		ss= new StationDeatails();
		ss.stationDetails();
		
	}
	
	
	
	

}
