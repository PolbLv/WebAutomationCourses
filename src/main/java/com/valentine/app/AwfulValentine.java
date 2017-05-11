package com.valentine.app;

import com.valentine.tools.Browser;
import org.openqa.selenium.WebDriver;

public class AwfulValentine {

	public static HomePage openHomePage() {
		WebDriver driver = Browser.open();
		driver.get("http://awful-valentine.com/");
		return new HomePage(driver);
	}
}
