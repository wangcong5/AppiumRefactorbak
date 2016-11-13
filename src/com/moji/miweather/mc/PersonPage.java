package com.moji.miweather.mc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class PersonPage extends BasePage {

	// 注册
	public void register(AndroidDriver<WebElement> driver) {

	}

	// 登录
	/**
	 * 登录方式：手机、微信、微博、QQ
	 * 
	 * @param driver
	 * @throws InterruptedException
	 * 
	 */
	public void loginPhone(AndroidDriver<WebElement> driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("new UiSelector().text(\"我\")").click();
		Thread.sleep(1000);
		// 点击【我】页面手机icon
		driver.findElement(By.id("com.moji.mjweather:id/tv_login_phone")).click();
		Thread.sleep(1000);
		// 点击【我】页面“使用密码登录”
		// driver.findElementById("com.moji.mjweather:id/tv_login_by_email").click();
		driver.findElementByXPath("//android.widget.TextView[@text=\"使用其他方式登录\"]").click();

		List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
		//textFieldsList.get(0).clear();
		textFieldsList.get(0).sendKeys("15527913638");
		textFieldsList.get(1).sendKeys("12345678");
		// 另一种输入方法，与List效果一致
		/*
		 * driver.findElement(By.id(
		 * "com.moji.mjweather:id/et_login_input_account")).sendKeys(
		 * "15527913638"); driver.findElement(By.id(
		 * "com.moji.mjweather:id/et_login_input_password")).sendKeys("123456");
		 */
		driver.findElement(By.id("com.moji.mjweather:id/tv_action_login")).click();

		// wait login success
		Assert.assertTrue(driver.findElement(By.name("好友动态")).isDisplayed());

		// 登录成功后截屏
		snapshot((TakesScreenshot) driver, "登录成功页面.png");
		// driver.findElementByAndroidUIAutomator("new
		// UiSelector().text(\"皮肤小铺\")").click();

		driver.findElementById("com.moji.mjweather:id/tv_friend_moment_title").click();
		Thread.sleep(1000);
		snapshot((TakesScreenshot) driver, "我的好友_动态.png");

		driver.findElementById("com.moji.mjweather:id/friend_click_area").click();
		Thread.sleep(1000);
		snapshot((TakesScreenshot) driver, "我的好友_时景.png");

		driver.findElementById("com.moji.mjweather:id/attention_click_area").click();
		Thread.sleep(1000);
		snapshot((TakesScreenshot) driver, "我的好友_关注.png");

		driver.findElementById("com.moji.mjweather:id/fans_click_area").click();
		Thread.sleep(1000);
		snapshot((TakesScreenshot) driver, "我的好友_粉丝.png");

		// 点击“返回”按钮
		driver.findElementById("com.moji.mjweather:id/iv_title_back").click();

		swipeToUp(driver, 1000);
		swipeToUp(driver, 1000);
		//退出当前登录
		quitLogin();
		loginWeibo();
		//退出微博登录
		quitLogin();
	}
	//微博登录
	public void loginWeibo() throws InterruptedException{
		driver.findElementById("com.moji.mjweather:id/tv_login_weibo").click();
		Thread.sleep(2000);
		snapshot((TakesScreenshot) driver, "微博登录成功.png");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//弹出“有身份，才安全”绑定页面，点“取消”
		driver.findElementById("com.moji.mjweather:id/buttonDefaultNegative").click();
	}

	private void quitLogin() throws InterruptedException {
		// TODO Auto-generated method stub
		// 点击我页面【设置】按钮
				driver.findElementById("com.moji.mjweather:id/rl_setting").click();
				snapshot((TakesScreenshot) driver, "设置页面.png");
				driver.findElementByAndroidUIAutomator("new UiSelector().text(\"账号管理\")").click();
				snapshot((TakesScreenshot) driver, "账号管理页面.png");
				swipeToUp(driver, 1000);
				swipeToUp(driver, 1000);
				// 点击【退出登录】
				driver.findElementById("com.moji.mjweather:id/tv_action").click();
				snapshot((TakesScreenshot) driver, "退出登录提示.png");
				// 退出登录
				driver.findElementById("com.moji.mjweather:id/buttonDefaultPositive").click();
				Thread.sleep(1000);
				snapshot((TakesScreenshot) driver, "退出登录成功.png");
				//返回登录前页面
				List<WebElement> settingBack = driver.findElementsByClassName("android.widget.ImageView");
				settingBack.get(0).click();
	}
}
