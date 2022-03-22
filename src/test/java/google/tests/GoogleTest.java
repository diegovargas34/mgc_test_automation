package google.tests;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import google.pages.*;

public class GoogleTest {
	
	public WebDriver driver;
	GoogleHomePage homepage;
	GoogleResultsPage resultspage;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","/usr/local/Caskroom/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}
	
	@Test(priority = 1)
	public void searchByButton() {
		homepage = new GoogleHomePage(driver);
		homepage.inputSearchText("The Name of the Wind");
		homepage.clickOnGoogleSearch();
		
		resultspage = new GoogleResultsPage(driver);
		//resultspage.clickOnMoreSearchModes();
		//resultspage.clickOnAuthorsPage();
	}
	
	@Test(priority = 2)
	public void searchBySuggestion() {
		homepage = new GoogleHomePage(driver);
		homepage.inputSearchText("The Name of the W");
		homepage.clickOnFirstSuggestion();
		
		resultspage = new GoogleResultsPage(driver);
		resultspage.clickOnMoreSearchModes();
		//resultspage.clickOnAuthorsPage();
	
	}
	
	@AfterTest
	public void finish() {
		driver.quit();
	}

}
