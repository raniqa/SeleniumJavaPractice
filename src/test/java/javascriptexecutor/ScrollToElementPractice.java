package javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ScrollToElementPractice extends BaseClass {

    public static void main(String[] args) throws InterruptedException {

        ScrollToElementPractice scrollPractice = new ScrollToElementPractice();

        scrollPractice.launchBrowser();
        scrollPractice.navigateTo("https://testautomationpractice.blogspot.com/");

        WebElement paginationWebTable = scrollPractice.driver.findElement(
                By.xpath("//h2[text()='Pagination Web Table']"));

        JavascriptExecutor js = (JavascriptExecutor) scrollPractice.driver;

        js.executeScript("arguments[0].scrollIntoView(true);", paginationWebTable);

        // Pause for 5 seconds to visually confirm the scrolling
        Thread.sleep(5000);

        scrollPractice.closeBrowser();
    }
}