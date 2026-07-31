package datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class CustomCalendarMonthYearDropdown extends BaseClass {

	public static void main(String[] args) {
		CustomCalendarMonthYearDropdown monthyeardd = new CustomCalendarMonthYearDropdown();

		monthyeardd.launchBrowser();

		WebDriverWait wait = new WebDriverWait(monthyeardd.driver, Duration.ofSeconds(10));

		monthyeardd.navigateTo("https://testautomationpractice.blogspot.com/");

		JavascriptExecutor js = (JavascriptExecutor) monthyeardd.driver;

		WebElement datepicker2 = monthyeardd.driver.findElement(By.id("txtDate"));

		js.executeScript("arguments[0].scrollIntoView(true);", datepicker2);

		wait.until(ExpectedConditions.visibilityOf(datepicker2));

		datepicker2.click();

		// Select Month

		WebElement monthSelector = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='ui-datepicker-month']")));

		Select month = new Select(monthSelector);

		month.selectByVisibleText("Aug");

		// Select Year

		WebElement yearSelector = monthyeardd.driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));

		Select year = new Select(yearSelector);

		year.selectByValue("2030");

		// Select Date

		List<WebElement> dates = monthyeardd.driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td/a"));

		for (WebElement date : dates) {

			if (date.getText().equals("28")) {

				date.click();
				break;
			}

		}

		monthyeardd.closeBrowser();

	}

}
