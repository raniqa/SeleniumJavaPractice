package javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;

import base.BaseClass;

public class ScrollToTopPractice extends BaseClass {

    public static void main(String[] args) throws InterruptedException {

        ScrollToTopPractice scrollToTop = new ScrollToTopPractice();

        scrollToTop.launchBrowser();
        scrollToTop.navigateTo("https://testautomationpractice.blogspot.com/");

        JavascriptExecutor js = (JavascriptExecutor) scrollToTop.driver;

        // Scroll to the bottom first
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Pause to verify scrolling to the bottom
        Thread.sleep(3000);

        // Scroll back to the top
        js.executeScript("window.scrollTo(0, 0);");

        // Pause to verify scrolling to the top
        Thread.sleep(3000);

        scrollToTop.closeBrowser();
    }
}