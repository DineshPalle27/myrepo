package pageObjects;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DreamsDiary 
{
	WebDriver driver;
	WebDriverWait wait;
	
	public DreamsDiary(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
	}
	
	public int getDreamRowCount()
	{
		return driver.findElements(By.xpath("//table/tbody/tr")).size();
	}
	
	public List<WebElement> getDreamTypes()
	{
		return driver.findElements(By.xpath("//tbody/tr/td[3]"));
	}
	
	public boolean areAllCellsFilled() {
		 List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		 for (int i = 1; i <= rows.size(); i++) 
		 {
		       for (int j = 1; j <= 3; j++) 
		       {
		              String cellText = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]")).getText().trim();
		              if (cellText.isEmpty()) return false;
		        }
		 }
		 return true;
	}
}
