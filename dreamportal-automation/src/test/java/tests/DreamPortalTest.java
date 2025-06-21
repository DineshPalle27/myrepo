package tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DreamsDiary;
import pageObjects.DreamsTotal;
import pageObjects.HomePage;
import utils.BaseTest;

public class DreamPortalTest extends BaseTest
{
	List<String> tabs;
	 @Test(priority = 1)
	 public void verifyAndClickDreamButton() {
	       HomePage homePage = new HomePage(driver);
	        assertTrue(homePage.isMyDreamsVisible(), "My Dreams Button Should Be Displayed...");
	        homePage.clickMyDreams();

	        Set<String> windowHandles = driver.getWindowHandles();
	        tabs = new ArrayList<>(windowHandles);
	        System.out.println(tabs.size());
	        Assert.assertTrue(tabs.size() >= 3, "Expected at least 3 tabs to be opened.");
	    }
	 
	 @Test(priority = 2, dependsOnMethods = "verifyAndClickDreamButton")
	    public void validateDreamTableEntries() {
	        driver.switchTo().window(tabs.get(1));

	        DreamsDiary diaryPage = new DreamsDiary(driver);
	        Assert.assertEquals(diaryPage.getDreamRowCount(), 10, "Expected 10 Entries in Dream Diary Table...");

	       
	        for (WebElement cell : diaryPage.getDreamTypes()) {
	            String value = cell.getText();
	            System.out.println("Status: " + value);
	            Assert.assertTrue(value.equalsIgnoreCase("Good") || value.equalsIgnoreCase("Bad"),
	                    "Invalid dream type found: " + value);
	        }

	        assertTrue(diaryPage.areAllCellsFilled(), "All Cells in the table Should be Filled");
	    }
	 
	 @Test(priority = 3, dependsOnMethods = "verifyAndClickDreamButton")
	    public void validateDreamStats() {
	        driver.switchTo().window(tabs.get(2));

	        DreamsTotal statsPage = new DreamsTotal(driver);
	        Assert.assertEquals(statsPage.getStatByRow(1), "Good Dreams 6");
	        Assert.assertEquals(statsPage.getStatByRow(2), "Bad Dreams 4");
	        Assert.assertEquals(statsPage.getStatByRow(3), "Total Dreams 10");
	        Assert.assertEquals(statsPage.getStatByRow(4), "Dreams This Week 7");
	        Assert.assertEquals(statsPage.getStatByRow(5), "Recurring Dreams 2");

		 driver.switchTo().window(tabs.get(1));
	       DreamsDiary diary = new DreamsDiary(driver);
	        List<String> recurring = diary.getRecurringDreams();
	        Assert.assertTrue(recurring.contains("Flying over mountains"));
	        Assert.assertTrue(recurring.contains("Lost in maze"));
	    }
	

}
