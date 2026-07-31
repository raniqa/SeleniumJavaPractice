package datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class CustomCalendarNextPrevious extends BaseClass {

	public static void main(String[] args) {

		CustomCalendarNextPrevious custcalendar = new CustomCalendarNextPrevious();

		custcalendar.launchBrowser();

		WebDriverWait wait = new WebDriverWait(custcalendar.driver, Duration.ofSeconds(10));

		custcalendar.navigateTo("https://testautomationpractice.blogspot.com/");

		JavascriptExecutor js = (JavascriptExecutor) custcalendar.driver;

		WebElement datepicker1 = custcalendar.driver.findElement(By.id("datepicker"));

		js.executeScript("arguments[0].scrollIntoView(true);", datepicker1);

		wait.until(ExpectedConditions.visibilityOf(datepicker1));

		datepicker1.click();
		
		wait.until(ExpectedConditions.visibilityOf(custcalendar.driver.findElement(By.cssSelector("div.ui-datepicker-title"))));
		
		String requiredMonth = "August";
		String requiredYear ="2030";
		
		while(true) {
			
			String month = custcalendar.driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
			String year = custcalendar.driver.findElement(By.cssSelector("span.ui-datepicker-year")).getText();
			
			if((requiredMonth.equals(month)) && (requiredYear.equals(year))) {
				break;				
			}
			
			// Next Button for Selection of Month and Year in the Future
			custcalendar.driver.findElement(By.xpath("//span[text()='Next']")).click();
			
			// Previous Button for Selection of Month and Year in the Past			
			// custcalendar.driver.findElement(By.xpath("//span[text()='Prev']")).click();
			
			// Wait for the Calendar to Refresh
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector("span.ui-datepicker-month")));
		}
		 
		// Selecting Date		
		String requiredDate = "24";
		
		List<WebElement> dates = custcalendar.driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td/a"));

		for(WebElement date:dates) {
			if(date.getText().equals(requiredDate)) {
				
				date.click();
				break;
			}
			
		}
		custcalendar.closeBrowser();
	}
}
