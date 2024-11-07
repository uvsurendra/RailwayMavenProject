package pagemethod;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import locators.LocatorsTest;

public class StationDeatails extends LocatorsTest {

	public WebDriverWait wait;
	public JavascriptExecutor jsx;
	public String actualPageTitle = "Live Train Running Status";
	public String trainNum = "17256";
	public String expectedTrainName = "NARASAPUR EXP";
	public Actions actions;

	public void stationDetails() {

		jsx = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		actions = new Actions(driver);

		String pageTitle = driver.getTitle();
		System.out.println("Page Title is " + pageTitle);
		Assert.assertTrue(pageTitle.contains(actualPageTitle));
		
		trainInformationDropdown.click();
		selectTimeTable.click();
		trainNameInputField.sendKeys(trainNum);
		
		actions.sendKeys(Keys.ENTER).perform();
		
		
		boolean sationNames= true;
		//boolean stationNames = true;
		while (sationNames ) {
			 wait.until(ExpectedConditions.visibilityOfAllElements(sationName));
			List<WebElement> stationNames = sationName;

			for (int i = 0; i < stationNames.size(); i++) {

				stationNames = sationName;

				WebElement stationNam = stationNames.get(i);
				
				// Scroll to the element
		    //    jsx.executeScript("arguments[0].scrollIntoView(true);", stationName);
		        
				System.out.println("How many stations will cover " + stationNam.getText());
				stationNam.click();

				wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(sNamess));

				String sName = sNamess.getText();
				
				System.out.println("After click station " + sName);
				// Assert.assertTrue(sName.contains(stationName));
				 

				WebElement stationBoard = stationBoards;

				Path path = Paths.get(System.getProperty("user.dir"), "screenshot");

				if (Files.exists(path)) {

					File source = stationBoard.getScreenshotAs(OutputType.FILE);
					String screenshotName = "StationBoard_" + System.currentTimeMillis() + ".png";
					File target = new File(path.toString(), screenshotName);

					source.renameTo(target);
					Assert.assertTrue(target.exists(), "Caputured Station Board Screenshot");
					System.out.println("Captured Station screenshot: " + screenshotName);
					
				}
				
				driver.navigate().back();

				wait.until(ExpectedConditions.visibilityOfAllElements(stationNames));
			
			}
			break;
		}

	}

}
