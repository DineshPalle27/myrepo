package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DreamsTotal 
{
	WebDriver driver;
	
	public DreamsTotal(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getStatByRow(int rowNumber)
	{
		return driver.findElement(By.xpath("//tbody/tr["    + rowNumber + "]")).getText().trim();
	}

}
