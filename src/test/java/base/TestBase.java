package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;

	@Parameters({ "browser", "url" })

	public void initilizeBrowser(String browser) throws IOException {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			FirefoxOptions opt = new FirefoxOptions();
			driver = new FirefoxDriver(opt);

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}

		intilizeApplication(getProperty("url"));

	}

	public void intilizeApplication(String url) {

		driver.get(url);
		driver.manage().window().maximize();

	}

	public String getProperty(String Key) throws IOException {

		Properties properties = new Properties();
		String filePath = System.getProperty("user.dir") + "/src/test/java/Properties/config.properties";
		//C:\Users\Admin\eclipse-workspace\RailwayMavenProject\src\test\java\Properties\config.properties
		FileInputStream fileInputStream = new FileInputStream(filePath);
		properties.load(fileInputStream);
		return properties.getProperty(Key);

	}

	public void captureScreenshots(String methodName) throws IOException {
		
		try {
			
			
			Path path = Paths.get(System.getProperty("user.dir"), "screenshots");

			if (Files.exists(path)) {

				File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String screenshotName = "failed screenshot " + System.currentTimeMillis() + ".png";
				//String screenshotName = methodName + ".png";
				
				File target = new File(path.toString(), screenshotName);

				source.renameTo(target);
				Assert.assertTrue(target.exists(), "Caputured failed Screenshot");
				System.out.println("Captured failed screenshot: " + screenshotName);
				
			}
			
		} catch (Exception e) {
			e.getMessage();

		}
		

	}

	@AfterClass
	public void tearDown() {
		closeAllBrowser();

	}

	public void closeAllBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

}
