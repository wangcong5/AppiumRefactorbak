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

		// ֱ���ı���λ
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"��������\")").click();

		List<WebElement> listReport = driver.findElementsByClassName("android.widget.TextView");// ��ȡTextView������Ԫ��
		
		WebElement targetReport = listReport.get(4);// ��ȡ�б��е��ĸ�Textview����������
		targetReport.click();
		// �������������ť
		driver.findElementByXPath(
				"//android.widget.Button[@resource-id=\"com.moji.mjweather:id/btn_weather_feedback_publish\"]").click();
		Thread.sleep(2000);
		
	}
	
	
}
