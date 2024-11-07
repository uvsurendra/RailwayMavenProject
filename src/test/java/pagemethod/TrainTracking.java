package pagemethod;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import locators.LocatorsTest;

public class TrainTracking extends LocatorsTest{

	public WebDriver driver;
	public String actualPageTitle = "Live Train Running Status";
	public Actions actions;
	public String trainNum = "12787";
	public JavascriptExecutor jsx;
	public List<WebElement> trackingBeforeAllStations;
	public List<WebElement> afterTrackingAllStations;
	public WebDriverWait wait;
	
	public void enterTrainDetails() {
		
		jsx = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		actions = new Actions(driver);

		String pageTitle = driver.getTitle();
		System.out.println("Page Title is " + pageTitle);
		Assert.assertTrue(pageTitle.contains(actualPageTitle));
	
		//wait.until(ExpectedConditions.visibilityOf(serachTrainInputField));
		//jsx.executeScript("arguments[0].scrollIntoView(true);", serachTrainInputField);
		serachTrainInputField.sendKeys(trainNum);
		wait.until(ExpectedConditions.visibilityOf(submitButton));
		submitButton.click();
		

	}
	
	public void getAllStationsList() {
		
		
		String trainName = actualTrainName.getText();
		System.out.println("Train Name is "+ trainName);
		Assert.assertTrue(trainName.contains(trainNum));
		
		
		LocalDate today = LocalDate.now();

		// Format the date as needed
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = today.format(formatter);

		// Print today's date
		System.out.println("Today's date: " + formattedDate);

		String startDate = trainStartDate.getText();
		System.out.println("Train start date is "+ startDate);
		Assert.assertTrue(startDate.contains(formattedDate));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(beforeTrackingGetAllStations));
		for(WebElement allStations: beforeTrackingGetAllStations) {
			System.out.println("Before tracking stations list "+allStations.getText());
		}
		
		
	}
	
	public void trackTheTrain() {
		
		wait.until(ExpectedConditions.visibilityOf(trainStatus));
		String liveStatus = trainStatus.getText();
		System.out.println("Train is now "+ liveStatus);
		
	}
	
	public void leftStationstoReachDestination() {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(afterTrackingRemaingStations));
		for(WebElement eachStation :afterTrackingRemaingStations){
			
			System.out.println("Remaining Stations are "+ eachStation);
			
		}
	}
}
