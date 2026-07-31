package datepicker;

// Imports for date handling
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Selenium imports
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Base class containing reusable browser methods
import base.BaseClass;

public class HTMLDatePickerPractice extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		HTMLDatePickerPractice htmldatepicker = new HTMLDatePickerPractice();

		htmldatepicker.launchBrowser();

		htmldatepicker.navigateTo("https://testautomationpractice.blogspot.com/");

		JavascriptExecutor js = (JavascriptExecutor) htmldatepicker.driver;

		WebDriverWait wait = new WebDriverWait(htmldatepicker.driver, Duration.ofSeconds(10));

		WebElement startDate = htmldatepicker.driver.findElement(By.id("start-date"));

		js.executeScript("arguments[0].scrollIntoView(true);", startDate);

		// Wait until the Start Date field becomes visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("start-date")));

		// Enter Start Date
		// Browser accepts MM/dd/yyyy while typing
		startDate.sendKeys("08/15/2026");

		Thread.sleep(5000);

		
		WebElement endDate = htmldatepicker.driver.findElement(By.id("end-date"));

		
		endDate.sendKeys("10/15/2026");

		Thread.sleep(5000);

		// Read the internally stored Start Date value
		// HTML5 date inputs store value as yyyy-MM-dd
		String startDateSelected = startDate.getDomProperty("value");

		// Convert String into LocalDate object
		LocalDate start = LocalDate.parse(startDateSelected);

		// Convert LocalDate into MM/dd/yyyy format
		String formattedStartDate =
		        start.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		// Read the internally stored End Date value
		String endDateSelected = endDate.getDomProperty("value");

		// Convert String into LocalDate object
		LocalDate end = LocalDate.parse(endDateSelected);

		// Convert LocalDate into MM/dd/yyyy format
		String formattedEndDate =
		        end.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		// Verify that the selected dates match the expected dates
		if (formattedStartDate.equals("08/15/2026")
		        && formattedEndDate.equals("10/15/2026")) {

		    System.out.println("Start and End dates selected successfully");
		} else {
		    System.out.println("Start and End dates not selected successfully");
		}

		
		WebElement submitBtn = htmldatepicker.driver.findElement(By.cssSelector("button.submit-btn"));

		submitBtn.click();

		htmldatepicker.closeBrowser();
	}
}