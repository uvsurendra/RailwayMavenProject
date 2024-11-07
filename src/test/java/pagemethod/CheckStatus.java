package pagemethod;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import locators.LocatorsTest;

public class CheckStatus extends LocatorsTest{
	
	public WebDriverWait wait;
	public JavascriptExecutor jsx;
	
	public List<WebElement> trackingBeforeAllStations;
	public List<WebElement> afterTrackingAllStations;
	
	public String expectedAlert = "Train has reached destination.";
	public String beforeStartTrainExpectedAlert = "Train hasn't started yet. But all looks good.";

	public void beforeStartingTraintoCheckStatus() throws IOException {
		
		jsx = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5000));

        // Wait for the search input field to be visible
        wait.until(ExpectedConditions.visibilityOf(serachTrainInputField));
        serachTrainInputField.sendKeys("17256");
       // wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
        
        wait.until(ExpectedConditions.visibilityOf(status));
       // jsx.executeScript("arguments[0].scrollIntoView(true);", status);
        String sta = status.getText();
        System.out.println("Status is " + sta);
		Assert.assertEquals(sta, beforeStartTrainExpectedAlert);
		
		for (WebElement station : stationList) {
			System.out.println("Stations are " + station.getText());
		}
	}
		
		public void afterReachTrainDestinationtoCheckStatus() {

			//wait.until(ExpectedConditions.visibilityOf(dropDown));
			dropDown.click();

			wait.until(ExpectedConditions.visibilityOf(selectValue));
			selectValue.click();

			wait.until(ExpectedConditions.visibilityOf(checkStatusButton));
			checkStatusButton.click();

			String afterReachTrainAlert = afterReachTrainStatus.getText();

			System.out.println("After reach train the train text is " + afterReachTrainAlert);

			Assert.assertEquals(afterReachTrainAlert, expectedAlert);

		}
	}


