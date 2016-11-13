package com.moji.miweather.mc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class CityManagerPage extends BasePage {
	String[] cityNameList = { "北京市", "天津市", "上海市", "重庆市", "沈阳市", "大连市", "长春市", "哈尔滨市" };

	public void addCity() throws InterruptedException {

		for (int i = 0; i < cityNameList.length; i++) {
			// 进入城市管理列表
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElementById("com.moji.mjweather:id/area_name_tv").click();
			Thread.sleep(5000);

			List<WebElement> list = driver.findElementsByClassName("android.widget.ImageView");// 获取ImageView的所有元素
			WebElement targetEle = list.get(2);// 获取列表中第二个ImageView元素,进入添加城市
			targetEle.click();

			WebElement el = driver.findElement(By.name(cityNameList[i].toString()));
			el.click();

			if (i == 7) {
				// 添加完最后一个城市会进入到天气首页，再点击一次首页城市名，进入城市管理页面
				driver.findElementById("com.moji.mjweather:id/area_name_tv").click();
				snapshot((TakesScreenshot) driver, "城市管理列表.png");
			}
			deleteCity();
		}
		// 添加第十个城市
		// 获取ImageView的所有元素
		List<WebElement> list = driver.findElementsByClassName("android.widget.ImageView");
		WebElement targetEle = list.get(2);// 获取列表中第二个ImageView元素,进入添加城市
		targetEle.click();
		snapshot((TakesScreenshot) driver, "添加第十个城市.png");
	}

	/**
	 * 删除城市 1.从首页进入城市管理列表，删除所有9个城市 2.删完所有城市，页面停留在“搜索城市”页面，可通过添加城市进入天气首页
	 * 
	 * @author MC
	 * @throws InterruptedException
	 */

	public void deleteCity() throws InterruptedException {
		driver.findElementById("com.moji.mjweather:id/area_name_tv").click();// 模块调试
		// 城市管理列表编辑
		List<WebElement> list0 = driver.findElementsByClassName("android.widget.ImageView");// 获取ImageView的所有元素

		// snapshot((TakesScreenshot) driver, "准备删除.png");
		// 循环删除城市
		for (int i = 0; i < cityNameList.length + 1; i++) {
			WebElement targetEle0 = list0.get(1);// 获取列表中第二个ImageView元素(笔icon),准备删除城市
			targetEle0.click();
			driver.findElementById("com.moji.mjweather:id/item_city_name_handle").click();
			WebElement e1 = driver.findElementByName("删除");
			e1.click();

			List<WebElement> list1 = driver.findElementsByClassName("android.widget.ImageView");// 获取ImageView的所有元素
			WebElement targetEle1 = list1.get(0);// 获取列表中第一个ImageView元素,准备删除城市
			targetEle1.click();
			Thread.sleep(1000);
			if (i == 8) {
				snapshot((TakesScreenshot) driver, "删除城市后.png");
			}
		}
	}
}
