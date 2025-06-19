package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	WebDriver driver;
	WebDriverWait wait;
	
	By mainContent = By.id("mainContent");
	By myDreamsBtn = By.id("dreamButton");
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
		
	}
	
	
	public boolean isMyDreamsVisible()
	{
		return 
				wait.until(ExpectedConditions.visibilityOfElementLocated(myDreamsBtn)).isDisplayed();
	}
	
	public void clickMyDreams()
	{
		driver.findElement(myDreamsBtn).click();
	}

}
