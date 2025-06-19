package utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest 
{
	protected WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setup()
	{
		    driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://arjitnigam.github.io/myDreams/");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	

	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}
