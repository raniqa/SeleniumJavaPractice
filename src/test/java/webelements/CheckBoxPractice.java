package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class CheckBoxPractice extends BaseClass {

	public static void main(String[] args) {

		CheckBoxPractice obj = new CheckBoxPractice();

		obj.launchBrowser();
		obj.navigateTo("https://the-internet.herokuapp.com/checkboxes");
		
		// Checkbox 2 is selected by default.

		// Checkbox 1
		WebElement chkBox1 = obj.driver.findElement(
				By.xpath("(//input[@type='checkbox'])[1]"));
		
		//If not already selected, select it

		if (!chkBox1.isSelected()) {
			System.out.println("Checkbox1 is NOT selected. Selecting Checkbox1");
			chkBox1.click();
		} else {
			System.out.println("Checkbox1 is already selected");
		}


		// Checkbox 2
		WebElement chkBox2 = obj.driver.findElement(
				By.xpath("(//input[@type='checkbox'])[2]"));

		//If already selected, de-select it
		if (chkBox2.isSelected()) {
			System.out.println("Checkbox2 is selected. Unchecking Checkbox2");
			chkBox2.click();
		} else {
			System.out.println("Checkbox2 is already unchecked");
		}


		// Verify final states
		if (chkBox1.isSelected()) {
			System.out.println("Checkbox1 selection verification passed");
		} else {
			System.out.println("Checkbox1 selection verification failed");
		}


		if (!chkBox2.isSelected()) {
			System.out.println("Checkbox2 unchecking verification passed");
		} else {
			System.out.println("Checkbox2 unchecking verification failed");
		}


		obj.closeBrowser();
	}
}