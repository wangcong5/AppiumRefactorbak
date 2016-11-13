package com.moji.miweather.mc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class PersonPage extends BasePage {

	// ע��
	public void register(AndroidDriver<WebElement> driver) {

	}

	// ��¼
	/**
	 * ��¼��ʽ���ֻ���΢�š�΢����QQ
	 * 
	 * @param driver
	 * @throws InterruptedException
	 * 
	 */
	public void loginPhone(AndroidDriver<WebElement> driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"��\")").click();
		Thread.sleep(1000);
		// ������ҡ�ҳ���ֻ�icon
		driver.findElement(By.id("com.moji.mjweather:id/tv_login_phone")).click();
		Thread.sleep(1000);
		// ������ҡ�ҳ�桰ʹ�������¼��
		// driver.findElementById("com.moji.mjweather:id/tv_login_by_email").click();
		driver.findElementByXPath("//android.widget.TextView[@text=\"ʹ��������ʽ��¼\"]").click();

		List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
		//textFieldsList.get(0).clear();
		textFieldsList.get(0).sendKeys("15527913638");
		textFieldsList.get(1).sendKeys("12345678");
		// ��һ�����뷽������ListЧ��һ��
		/*
		 * driver.findElement(By.id(
		 * "com.moji.mjweather:id/et_login_input_account")).sendKeys(
		 * "15527913638"); driver.findElement(By.id(
		 * "com.moji.mjweather:id/et_login_input_password")).sendKeys("123456");
		 */
		driver.findElement(By.id("com.moji.mjweather:id/tv_action_login")).click();

		// wait login success
		Assert.assertTrue(driver.findElement(By.name("���Ѷ�̬")).isDisplayed());

		// ��¼�ɹ������
		snapshot((TakesScreenshot) driver, "��¼�ɹ�ҳ��.png");
		// driver.findElementByAndroidUIAutomator("new
		// UiSelector().text(\"Ƥ��С��\")").click();

		driver.findElementById("com.moji.mjweather:id/tv_friend_moment_title").click();
		Thread.sleep(1000);
		snapshot((TakesScreenshot) driver, "�ҵĺ���_��̬.png");

		driver.findElementById("com.moji.mjweather:id/friend_click_area").click();
		Thread.sleep(1000);
		snapshot((TakesScreenshot) driver, "�ҵĺ���_ʱ��.png");

		driver.findElementById("com.moji.mjweather:id/attention_click_area").click();
		Thread.sleep(1000);
		snapshot((TakesScreenshot) driver, "�ҵĺ���_��ע.png");

		driver.findElementById("com.moji.mjweather:id/fans_click_area").click();
		Thread.sleep(1000);
		snapshot((TakesScreenshot) driver, "�ҵĺ���_��˿.png");

		// ��������ء���ť
		driver.findElementById("com.moji.mjweather:id/iv_title_back").click();

		swipeToUp(driver, 1000);
		swipeToUp(driver, 1000);
		//�˳���ǰ��¼
		quitLogin();
		loginWeibo();
		//�˳�΢����¼
		quitLogin();
	}
	//΢����¼
	public void loginWeibo() throws InterruptedException{
		driver.findElementById("com.moji.mjweather:id/tv_login_weibo").click();
		Thread.sleep(2000);
		snapshot((TakesScreenshot) driver, "΢����¼�ɹ�.png");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//����������ݣ��Ű�ȫ����ҳ�棬�㡰ȡ����
		driver.findElementById("com.moji.mjweather:id/buttonDefaultNegative").click();
	}

	private void quitLogin() throws InterruptedException {
		// TODO Auto-generated method stub
		// �����ҳ�桾���á���ť
				driver.findElementById("com.moji.mjweather:id/rl_setting").click();
				snapshot((TakesScreenshot) driver, "����ҳ��.png");
				driver.findElementByAndroidUIAutomator("new UiSelector().text(\"�˺Ź���\")").click();
				snapshot((TakesScreenshot) driver, "�˺Ź���ҳ��.png");
				swipeToUp(driver, 1000);
				swipeToUp(driver, 1000);
				// ������˳���¼��
				driver.findElementById("com.moji.mjweather:id/tv_action").click();
				snapshot((TakesScreenshot) driver, "�˳���¼��ʾ.png");
				// �˳���¼
				driver.findElementById("com.moji.mjweather:id/buttonDefaultPositive").click();
				Thread.sleep(1000);
				snapshot((TakesScreenshot) driver, "�˳���¼�ɹ�.png");
				//���ص�¼ǰҳ��
				List<WebElement> settingBack = driver.findElementsByClassName("android.widget.ImageView");
				settingBack.get(0).click();
	}
}
