package google.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleResultsPage {
	
	public WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@FindBy(className = "MUFPAc")
	WebElement searchModesBar;
	
	@FindBy(css = "#rso > div:nth-child(13) > div > div > div.tF2Cxc > div.yuRUbf > a > h3")
	WebElement authorsPage;
	
	public GoogleResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//I think the problem is that the definition of the wait is before driver is initialized in the constructor
		//wait.until(ExpectedConditions.visibilityOf(searchModesBar));
	}
	
	public void clickOnMoreSearchModes() {
		
		
		List<WebElement> moreOptions = driver.findElements(By.className("GOE98c"));		
		
		moreOptions.get(0).click();
	}
	
	public void clickOnAuthorsPage() {
		
		
		//LC20lb
		List<WebElement> results = driver.findElements(By.className("LC20lb"));
		
		for(WebElement w: results) {
			//System.out.println(w.getText());
			if (w.getText().equals("The Books - Patrick Rothfuss")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				w.click();
			}
		}
		
	}
	
	public void clickOnAuthorsPage_1() {
		
		authorsPage.click();		
		
	}
	
	

}
