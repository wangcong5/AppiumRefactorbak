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
		
		
		// System.out.println("������ҳ��"+driver.getTitle());
		PersonPage loginObj = new PersonPage();
		loginObj.loginPhone(driver);
		/*
		 * BasePage i = new homepage(); BasePage j = new LivePage();
		 * ArrayList<BasePage> aa = new ArrayList<>(); aa.add(i); aa.add(j);
		 * for(int k = 0;k< aa.size() ;k++){ BasePage as = aa.get(k);
		 * as.homePage(driver); }
		 */
		/*
		 * BaseMethods i= new BaseMethods(); System.out.println("��ʼ¼��");
		 * i.startRecord(); System.out.println("����¼��"); i.share(driver);
		 * i.snapshot((TakesScreenshot)driver, "����ҳ��");
		 */

	}
}
