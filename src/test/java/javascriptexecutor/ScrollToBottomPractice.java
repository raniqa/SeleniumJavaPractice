package javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;

import base.BaseClass;

public class ScrollToBottomPractice extends BaseClass {

    public static void main(String[] args) throws InterruptedException {

        ScrollToBottomPractice scrollToBottom = new ScrollToBottomPractice();

        scrollToBottom.launchBrowser();
        scrollToBottom.navigateTo("https://testautomationpractice.blogspot.com/");

        JavascriptExecutor js = (JavascriptExecutor) scrollToBottom.driver;

        // Scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Pause to verify scrolling
        Thread.sleep(5000);

        scrollToBottom.closeBrowser();
    }
}