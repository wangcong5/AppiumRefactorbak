package com.moji.miweather.mc;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	/*@Override
	public void doSth() {
		// TODO Auto-generated method stub
		
	}*/
	public void homePage(AndroidDriver<WebElement> driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElementById("com.moji.mjweather:id/iv_voice").click();
		Thread.sleep(5000);

		// 直接文本定位
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"反馈天气\")").click();

		List<WebElement> listReport = driver.findElementsByClassName("android.widget.TextView");// 获取TextView的所有元素
		
		WebElement targetReport = listReport.get(4);// 获取列表中第四个Textview，即“阴”
		targetReport.click();
		// 点击【发布】按钮
		driver.findElementByXPath(
				"//android.widget.Button[@resource-id=\"com.moji.mjweather:id/btn_weather_feedback_publish\"]").click();
		Thread.sleep(2000);
		
	}
	
	
}
