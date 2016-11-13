package com.moji.miweather.mc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MainPage extends BasePage {

	@Test
	public void test() throws InterruptedException, IOException {
		startRecord();
		new MainPage().newTutorial();
		
		
		// System.out.println("天气首页："+driver.getTitle());
		PersonPage loginObj = new PersonPage();
		loginObj.loginPhone(driver);
		/*
		 * BasePage i = new homepage(); BasePage j = new LivePage();
		 * ArrayList<BasePage> aa = new ArrayList<>(); aa.add(i); aa.add(j);
		 * for(int k = 0;k< aa.size() ;k++){ BasePage as = aa.get(k);
		 * as.homePage(driver); }
		 */
		/*
		 * BaseMethods i= new BaseMethods(); System.out.println("开始录屏");
		 * i.startRecord(); System.out.println("结束录屏"); i.share(driver);
		 * i.snapshot((TakesScreenshot)driver, "分享页面");
		 */

	}
}
