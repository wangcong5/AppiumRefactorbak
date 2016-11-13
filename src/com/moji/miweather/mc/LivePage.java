package com.moji.miweather.mc;

import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LivePage extends BasePage {
	@Test
	public void livePicture() throws InterruptedException {
		new LivePage().newTutorial();
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"时景\")").click();
		snapshot((TakesScreenshot) driver, "时景页面.png");

		List<WebElement> list = driver.findElementsByClassName("android.widget.ImageView");
		WebElement Livelist = list.get(4);// liveView list third picture
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.toString());
		}
		Livelist.click();
		snapshot((TakesScreenshot) driver, "进入时景单张.png");
	}

}
