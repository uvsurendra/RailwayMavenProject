package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import base.TestBase;
import locators.LocatorsTest;
import pagemethod.PageMethods;

public class TestScripts extends TestBase{
	
	public PageMethods pageMethods;
	public LocatorsTest loc;
	@Parameters({"browser", "url"})
	@Test
	public void StationDetails() throws IOException {
		
		
		initilizeBrowser("chrome");
		
		 pageMethods = new PageMethods();
		
		 loc = new LocatorsTest();
		
		 pageMethods.homePage();
		
		
		
	}
	
}
