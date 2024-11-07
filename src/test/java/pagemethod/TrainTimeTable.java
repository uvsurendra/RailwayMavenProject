package pagemethod;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import locators.LocatorsTest;



public class TrainTimeTable extends LocatorsTest {

	public WebDriverWait wait;
	public JavascriptExecutor jsx;
	public String actualPageTitle = "Live Train Running Status";
	public String trainNum = "17256";
	public String expectedTrainName = "NARASAPUR EXP";
	public Actions actions;
	public String expectedTimeTable = "STATION ARRIVES HALT TIME DEPARTS PLATFORM LOCOMOTIVE REVERSE\r\n"
			+ "Narasapur (NS) ------- START 11:15 1 NO\r\n" + "Palakollu (PKO) 11:23 2 MINS 11:25 2 NO\r\n"
			+ "Bhimavaram Town (BVRT) 11:53 2 MINS 11:55 1 NO\r\n" + "Akividu (AKVD) 12:08 2 MINS 12:10 1 NO\r\n"
			+ "Kaikaluru (KKLR) 12:23 2 MINS 12:25 2 NO\r\n" + "Gudivada Jn (GDV) 12:58 2 MINS 13:00 1 NO\r\n"
			+ "Vijayawada Jn (BZA) 13:50 15 MINS 14:05 7 NO\r\n" + "Khammam (KMT) 15:23 2 MINS 15:25 2 NO\r\n"
			+ "Warangal (WL) 17:01 2 MINS 17:03 2 NO\r\n" + "Kazipet Jn (KZJ) 17:18 2 MINS 17:20 2 NO\r\n"
			+ "Secunderabad Jn (SC) 19:50 15 MINS 20:05 8 NO\r\n" + "Kamareddi (KMC) 21:29 1 MINS 21:30 2 NO\r\n"
			+ "Nizamabad (NZB) 22:18 2 MINS 22:20 1 NO\r\n" + "Basar (BSX) 22:44 1 MINS 22:45 1 NO\r\n"
			+ "Mudkhed (MUE) 00:23 2 MINS 00:25 1 NO\r\n" + "Huzur Sahib Nanded (NED) 00:50 5 MINS 00:55 1 NO\r\n"
			+ "Purna Jn (PAU) 00:30 5 MINS 00:35 2 NO\r\n" + "Parbhani Jn (PBN) 00:08 2 MINS 00:10 3 NO\r\n"
			+ "Jalna (J) 00:53 2 MINS 00:55 1 NO\r\n" + "Aurangabad (AWB) 00:30 5 MINS 00:35 1 NO\r\n"
			+ "Nagarsol (NSL) 00:10 END ------ 1 NO";

	public void enterTrainDeatils() {

		jsx = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		actions = new Actions(driver);

		String pageTitle = driver.getTitle();
		System.out.println("Page Title is " + pageTitle);
		Assert.assertTrue(pageTitle.contains(actualPageTitle));

		wait.until(ExpectedConditions.visibilityOf(trainInformationDropdown));
		trainInformationDropdown.click();
		
		wait.until(ExpectedConditions.visibilityOf(selectTimeTable));
		selectTimeTable.click();
		
		wait.until(ExpectedConditions.visibilityOf(trainNameInputField));
		//jsx.executeScript("arguments[0].scrollIntoView(true);", trainNameInputField);
		trainNameInputField.sendKeys(trainNum);

		actions.sendKeys(Keys.ENTER).perform();

	}

	public void checkTrainDetails() {

		wait.until(ExpectedConditions.visibilityOf(trainName));
		String tName = trainName.getText();
		System.out.println("Train name is " + tName);
		Assert.assertTrue(tName.contains(expectedTrainName));

		for (WebElement day : days) {
			System.out.println("How many days will travel tarin is " + day.getText());
		}

		for (WebElement stationName : stationNames) {
			System.out.println("How many stations will cover " + stationName.getText());

		}

		for (WebElement trainTime : trainTimings) {
			System.out.println("Station Timings " + trainTime.getText());
		}

	}

	public void checkPlatformDetails() {

		for (int i = 0; i < platforms.size(); i++) {
			String platformText = platforms.get(i).getText();
			System.out.println("Station details is " + platformText);

			String[] lines = platformText.split("\n");

			if (lines.length == 3) {
				// Get station name
				String[] stationNam = lines[0].split(" ");
				String stationName = stationNam[0];
				System.out.println("Station name is " + stationName);

				// Get PF Number
				String[] pfNumber = lines[1].split("#");
				String PFNumber = pfNumber[1];
				System.out.println("PF Number is " + PFNumber);

				String time = lines[2].trim();
				System.out.println("Time is " + time);
				System.out.println(trainNum + " " + expectedTrainName + " train next station will be stop at "
						+ stationName + " on platform " + PFNumber + " at " + time);
				

			} else if (lines.length == 4) {
				// Get station name
				String[] stationNam = lines[0].split(" ");
				String stationName = stationNam[0];
				System.out.println("Station name is " + stationName);

				// Get PF Number
				String[] pfNumber = lines[1].split("#");
				String PFNumber = pfNumber[1];
				System.out.println("PF Number is " + PFNumber);

				String food = lines[2].trim();
				System.out.println("Food " + food);

				String time = lines[3].trim();
				System.out.println("time is " + time);

				System.out.println(trainNum + " " + expectedTrainName + " train next station will be stop at "
						+ stationName + " on platform " + PFNumber + " at " + time);

			}

		}
	}

	public void foodInformation() {

		for (int i = 0; i < foodStations.size(); i++) {
			String platformText = foodStations.get(i).getText();
			System.out.println("Text is " + platformText);

			String[] lines = platformText.split("\n");

			if (lines.length == 4) {
				// Get station name
				String[] stationNam = lines[0].split(" ");
				String stationName = stationNam[0];
				System.out.println("Station name is " + stationName);

				// Get PF Number
				String[] pfNumber = lines[1].split("#");
				String PFNumber = pfNumber[1];
				System.out.println("PF Number is " + PFNumber);

				String food = lines[2].trim();
				System.out.println("Food " + food);

				String time = lines[3].trim();
				System.out.println("time is " + time);

				if (food.equals("Order Food")) {
					System.out.println("Food delivery available at " + stationName + " on platform " + PFNumber);

				}
			} else {

			}

		}

	}

	public void checkTimeTable() {
		
		
		String timeTable = actualTimeTable.getText();
		System.out.println("Time table is " + timeTable);
		//Assert.assertTrue(timeTable.contains(expectedTimeTable));
		

	}
}
