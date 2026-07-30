package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class HighestPricedBookPractice extends BaseClass {

	public static void main(String[] args) throws InterruptedException {

		// Create object of current class
		HighestPricedBookPractice tablePractice = new HighestPricedBookPractice();

		// Launch browser
		tablePractice.launchBrowser();

		// Navigate to application
		tablePractice.navigateTo("https://testautomationpractice.blogspot.com/");

		// Scroll to the Book Table
		WebElement bookTable = tablePractice.driver.findElement(By.xpath("//table[@name='BookTable']"));

		JavascriptExecutor js = (JavascriptExecutor) tablePractice.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", bookTable);

		Thread.sleep(3000);

		// Count the number of data rows
		List<WebElement> rows = tablePractice.driver
				.findElements(By.xpath("//table[@name='BookTable']//tr[position()>1]"));

		int highestPrice = 0;
		int highestPriceRow = 0;

		// Find the highest priced book
		for (int r = 2; r <= rows.size() + 1; r++) {

			WebElement priceCell = tablePractice.driver
					.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[4]"));

			int currentPrice = Integer.parseInt(priceCell.getText());

			if (currentPrice > highestPrice) {
				highestPrice = currentPrice;
				highestPriceRow = r;
			}
		}

		// Print details of the highest priced book
		System.out.println("Highest Priced Book");
		System.out.println("-------------------");

		System.out.println("Book Name : " + tablePractice.driver
				.findElement(By.xpath("//table[@name='BookTable']//tr[" + highestPriceRow + "]/td[1]")).getText());

		System.out.println("Author : " + tablePractice.driver
				.findElement(By.xpath("//table[@name='BookTable']//tr[" + highestPriceRow + "]/td[2]")).getText());

		System.out.println("Subject : " + tablePractice.driver
				.findElement(By.xpath("//table[@name='BookTable']//tr[" + highestPriceRow + "]/td[3]")).getText());

		System.out.println("Price : " + highestPrice);

		Thread.sleep(3000);

		// Close browser
		tablePractice.closeBrowser();
	}
}