package webtable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class DynamicWebTablePractice extends BaseClass {

	public static void main(String[] args) {

		DynamicWebTablePractice table = new DynamicWebTablePractice();

		table.launchBrowser();

		table.navigateTo("https://testautomationpractice.blogspot.com/");

		// Scroll to table

		WebElement taskTable = table.driver.findElement(By.id("taskTable"));

		JavascriptExecutor js = (JavascriptExecutor) table.driver;

		js.executeScript("arguments[0].scrollIntoView(true);", taskTable);

		// Find number of rows

		List<WebElement> rows = table.driver.findElements(By.xpath("//table[@id='taskTable']//tbody/tr"));

		int rowCount = rows.size();

		System.out.println("Number of records: " + rowCount);

		// Find number of columns

		List<WebElement> columns = table.driver.findElements(By.xpath("//table[@id='taskTable']//thead//th"));

		int columnCount = columns.size();

		System.out.println("Number of attributes maintained: " + columnCount);

		// Find Chrome CPU Load dynamically

		String chromeLoad = "";

		for (int r = 1; r <= rowCount; r++) {

			String processName = table.driver.findElement(By.xpath("//table[@id='taskTable']/tbody/tr[" + r + "]/td[1]"))
					.getText();

			if (processName.equals("Chrome")) {

				WebElement cpu = table.driver.findElement(By.xpath("//table[@id='taskTable']//td[normalize-space()='Chrome']"
						+ "/following-sibling::td[contains(text(),'%')]"));

				chromeLoad = cpu.getText();

				break;
			}

		}

		System.out.println("Chrome CPU Load: " + chromeLoad);

		// Verify Chrome CPU Load displayed below table

		String message = table.driver.findElement(By.xpath("//div[@class='display-values']/p[1]")).getText();

		if (message.contains(chromeLoad)) {

			System.out.println("Chrome CPU Load verification passed");

		} else {

			System.out.println("Chrome CPU Load verification failed");
		}

		// Find Firefox Disk Space dynamically

		String firefoxDisk = "";

		for (int r = 1; r <= rowCount; r++) {

			String processName = table.driver.findElement(By.xpath("//table[@id='taskTable']/tbody/tr[" + r + "]/td[1]"))
					.getText();

			if (processName.equals("Firefox")) {

				WebElement disk = table.driver
						.findElement(By.xpath("//table[@id='taskTable']//td[normalize-space()='Firefox']"
								+ "/following-sibling::td[contains(text(),'MB/s')]"));

				firefoxDisk = disk.getText();

				break;

			}

		}

		System.out.println("Firefox Disk Space: " + firefoxDisk);

		table.closeBrowser();

	}

}