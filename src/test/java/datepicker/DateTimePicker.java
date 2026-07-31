package datepicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class DateTimePicker extends BaseClass {

	public static void main(String[] args) {

		DateTimePicker datetimepicker = new DateTimePicker();

		datetimepicker.launchBrowser();

		WebDriverWait wait = new WebDriverWait(datetimepicker.driver, Duration.ofSeconds(10));

		datetimepicker.navigateTo("https://demoqa.com/date-picker");

		WebElement dateTimeSelector = datetimepicker.driver.findElement(By.id("dateAndTimePickerInput"));
		dateTimeSelector.click();

		wait.until(ExpectedConditions.visibilityOf(
				datetimepicker.driver.findElement(By.xpath("//div[@class='react-datepicker__month-container']"))));

		// Month Dropdown
		datetimepicker.driver.findElement(By.xpath("//span[contains(@class,'month-read-view--selected-month')]")).click();
		
		List<WebElement> months = datetimepicker.driver
				.findElements(By.xpath("//div[@class='react-datepicker__month-dropdown']/div"));

		for (WebElement month : months) {
			if (month.getText().equals("December")) {
				month.click();
				break;
			}
		}

		// Year Dropdown
		datetimepicker.driver.findElement(By.xpath("//span[contains(@class,'year-read-view--selected-year')]")).click();
		
		List<WebElement> years = datetimepicker.driver
				.findElements(By.xpath("//div[@class='react-datepicker__year-option']"));

		for (WebElement year : years) {
			if (year.getText().equals("2026")) {
				year.click();
				break;
			}
		}
		
		//Date Selection
		
		List<WebElement> dates = datetimepicker.driver.findElements(
				By.xpath("//div[@class='react-datepicker__month']//div[contains(@class,'day')]"));
		
		for(WebElement date:dates) {
			if(date.getText().equals("25")) {
				date.click();
				break;
			}
		}
		
		// Select time
		
		List<WebElement> timeList = datetimepicker.driver.findElements(
				By.xpath("//ul/li[contains(@class,'time-list-item')]"));
		
		for(WebElement time:timeList) {
			if(time.getText().equals("10:00")) {
				time.click();
				break;
			}
		}
		
		datetimepicker.closeBrowser();
	}
}
