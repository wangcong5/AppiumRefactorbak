package com.moji.miweather.mc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class WeatherCorrectPage extends BasePage{
	public void homePage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElementById("com.moji.mjweather:id/iv_voice").click();
		Thread.sleep(5000);
		snapshot((TakesScreenshot) driver, "������ҳ.png");

		// ֱ���ı���λ
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"��������\")").click();

		List<WebElement> listReport = driver.findElementsByClassName("android.widget.TextView");// ��ȡTextView������Ԫ��
		
		WebElement targetReport = listReport.get(4);// ��ȡ�б��е��ĸ�Textview����������
		targetReport.click();
		// �������������ť
		driver.findElementByXPath(
				"//android.widget.Button[@resource-id=\"com.moji.mjweather:id/btn_weather_feedback_publish\"]").click();
		Thread.sleep(2000);

		// ��������
		/*
		 * driver.sendKeyEvent(AndroidKeyCode.HOME);
		 * driver.sendKeyEvent(AndroidKeyCode.BACK);
		 * //��ȡ��ǰ�����activity,�����ڶ����Ƿ���ת��Ԥ�ڵ�activity driver.currentActivity();
		 * driver.sendKeyEvent(AndroidKeyCode.HOME);
		 * 
		 * el = driver.findElementByName("Add note");
		 * assertThat(el.getText(),equalTo("Add note"));
		 */
		
	}
}
