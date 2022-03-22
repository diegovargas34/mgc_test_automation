package google.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class GoogleHomePage {
	
	public WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@FindBy(className = "gLFyf")
	WebElement searchField;
	
	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//wait.until(ExpectedConditions.visibilityOf(searchField));
	}
	
	public void inputSearchText(String text) {
		
		searchField.sendKeys(text);
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void clickOnGoogleSearch() {
		
		List<WebElement> searchButtons = driver.findElements(By.className("gNO89b"));		
		
		searchButtons.get(0).click();
	}
	
	public void clickOnFirstSuggestion() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement firstOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//ul[@role='listbox']/li)[1]")));
		firstOption.click();
		
		
		//List<WebElement> suggestions = driver.findElements(By.className("pcTkSc"));
		//List<WebElement> suggestions = driver.findElements(By.cssSelector("div.wM6W7d > span"));
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//suggestions.get(0).click();
	}
	

}
