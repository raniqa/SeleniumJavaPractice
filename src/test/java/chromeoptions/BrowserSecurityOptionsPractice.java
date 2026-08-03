package chromeoptions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserSecurityOptionsPractice {

	public static void main(String[] args) {

		// Create ChromeOptions object
		ChromeOptions options = new ChromeOptions();

		// Ignore SSL certificate errors
		options.addArguments("--ignore-certificate-errors");

		// Create Chrome Preferences
		Map<String, Object> prefs = new HashMap<>();

		// Disable browser notifications
		prefs.put("profile.default_content_setting_values.notifications", 2);

		// Disable location permission
		prefs.put("profile.default_content_setting_values.geolocation", 2);

		// Disable microphone permission
		prefs.put("profile.default_content_setting_values.media_stream_mic", 2);

		// Disable camera permission
		prefs.put("profile.default_content_setting_values.media_stream_camera", 2);

		// Apply Chrome preferences
		options.setExperimentalOption("prefs", prefs);

		// Launch Chrome
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.easemytrip.com/");

		System.out.println("Page Title : " + driver.getTitle());

		driver.quit();
	}
}