package pagemethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import locators.LocatorsTest;

public class PageMethods extends LocatorsTest {


	public WebDriverWait wait;
	public void homePage() throws IOException {
		
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(5000));

        // Wait for the search input field to be visible
        wait.until(ExpectedConditions.visibilityOf(serachTrainInputField));
        serachTrainInputField.sendKeys("17256");
        submitButton.click();

       
        
	
	}

}
