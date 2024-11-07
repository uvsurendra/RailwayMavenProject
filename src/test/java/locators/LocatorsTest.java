package locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LocatorsTest extends TestBase {

	public LocatorsTest() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='train_number']")
	public WebElement serachTrainInputField;
	
	@FindBy(xpath= "//button[@type='submit']")
	public WebElement submitButton;
	
	
	@FindBy(xpath = "//tbody/tr/td/a")
	public List<WebElement> sationName;
	
	@FindBy(xpath = "//div/h1[@class='h2-tittle fw-bold c-black marg-top-30']")
	public WebElement sNamess;
	
	@FindBy(xpath = "//img[@class='img-responsive stn-hero-img']")
	public WebElement stationBoards;
	
	@FindBy(xpath= "(//div[@class='flexRow flexCenter']/following::p)[1]")
	public WebElement status;
	
	@FindBy(xpath ="//div[contains(@class,'flexRow')]/div[@class='flexCol']")
	public List<WebElement> stationList;
	
	@FindBy(xpath = "//button[@id='basic-button']")
	public WebElement dropDown;
	
	@FindBy(xpath ="//ul/li/div[text()='Start Day - Yesterday']")
	public WebElement selectValue;
	
	@FindBy(xpath = "//button[@aria-label='Check Time Table']")
	public WebElement checkStatusButton;
	
	@FindBy(xpath= "//p[text()='Train has reached destination.']")
	public WebElement afterReachTrainStatus;
	
	
	@FindBy(xpath = "(//ul/li/a)[3]")
	public WebElement trainInformationDropdown;
	
	@FindBy(xpath = "(//ul[@class='popup_list']/li[3])[1]")
	public WebElement selectTimeTable;
	
	@FindBy(id ="train")
	public WebElement trainNameInputField;
	
	@FindBy(xpath ="//h1[contains(@class,'MuiTypography-root ')]")
	public WebElement trainName;
	
	@FindBy(xpath = "//div[contains(@class,'trainstopage_white_txt__FkFer')]")
	public List<WebElement> days;
	
	
	@FindBy(xpath ="//div[contains(@class,'trainstopage_grey_4a__9i_Q8')]")
	public List<WebElement> stationNames;
	
	@FindBy(xpath = "//div[contains(@class,'MuiTypography-root MuiTypography-body1')]/span")
	public List<WebElement> trainTimings;
	
	@FindBy(xpath ="//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-8')]/following::div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-8')]")
	public List<WebElement> platforms;
	
	@FindBy(xpath ="//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-8')]/following::div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-8')]")
	public List<WebElement> foodStations;
	
	@FindBy(xpath = "//table[@class='timetable_table__4hbNj']")
	public WebElement actualTimeTable;
	
	@FindBy(xpath = "//p[@class='no-pad no-marg']")
	public WebElement actualTrainName;
	
	@FindBy(xpath = "//span[text()=' Start Date ']")
	public WebElement trainStartDate;
	
	
	@FindBy(xpath = "//div[@class='flexCol']/h2")
	public List<WebElement> beforeTrackingGetAllStations;
	
	@FindBy(xpath = "(//img[@id='trainIcon']/following::p)[1]")
	public WebElement trainStatus;
	
	@FindBy(xpath ="//div[@class='result_blueLine__voCzw']/following::div[1]/div/div/h2")
	public List<WebElement> afterTrackingRemaingStations;
	
	
	
	
	
}
